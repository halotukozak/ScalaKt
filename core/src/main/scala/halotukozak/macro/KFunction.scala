package halotukozak.`macro`

import kotlin.jvm.functions as kvf

import scala.quoted.*
import scala.reflect.*
import halotukozak.core.KBasicUtils.KUnit

import scala.annotation.experimental
import scala.annotation.MacroAnnotation

object KFunction {

  private type AnyKFunction =
    kvf.Function0[?] | kvf.Function1[?, ?] | kvf.Function2[?, ?, ?] |
      kvf.Function3[?, ?, ?, ?] | kvf.Function4[?, ?, ?, ?, ?] |
      kvf.Function5[?, ?, ?, ?, ?, ?] | kvf.FunctionN[?]

  type KFunction[N <: Int, T, R] <: AnyKFunction = N match {
    case 0 => kvf.Function0[R]
    case 1 => kvf.Function1[T, R]
    case 2 => kvf.Function2[T, T, R]
    case 3 => kvf.Function3[T, T, T, R]
    case 4 => kvf.Function4[T, T, T, T, R]
    case _ => kvf.FunctionN[R]
  }

  transparent inline def kotlinFunctionN[N <: Int](inline n: N): AnyKFunction =
    ${ kotlinFunctionNImpl('{ n }) }

  private def kotlinFunctionNImpl[N <: Int : Type](
    n: Expr[Int]
  )(using Quotes): Expr[AnyKFunction] = {
    import quotes.reflect.*
    val nValue = n.valueOrAbort
    val args = (1 to nValue)
      .map(i => s"p$i: Int")
      .mkString(
        start = "(",
        sep = ", ",
        end = ")"
      )
    val types = (1 to nValue)
      .map(i => "Int")
      .appended("String")
      .mkString(
        start = "[",
        sep = ", ",
        end = "]"
      )
    val fun =
      s"""new functions.Function$n$types {
         |    override def invoke$args: String = "ok"
         |  }
         |""".stripMargin // todo use '
    val funDef = Expr(fun).asTerm.asExprOf[KFunction[N, Int, String]]
    funDef
  }

  inline def scalaFunctionAsKotlin(n: Int) = ${
    scalaFunctionAsKotlinImpl('{ n })
  }

  private def scalaFunctionAsKotlinImpl[N <: Int : Type](
    n: Expr[N]
  )(using Quotes) = {
    val types = (1 to n.valueOrAbort).map(i => s"T$i")
    val extensionTypes = types.mkString("[", ", ", ", R]")
    val parameterType = types.mkString("(", ", ", ") => R")
    val kjvTypes = types.map("? >: " + _).mkString("[", ", ", ", R]")
    val returnType =
      types.zipWithIndex
        .map { case (tpe, i) => s"t${i + 1}: $tpe" }
        .mkString("(", ", ", ")") ++
        " => f" + types.indices.map(i => s"t${i + 1}").mkString("(", ", ", ")")

    val extensionDef =
      s"""
         |extension $extensionTypes(f: $parameterType)
         |  def asKotlin: kjv.Function$n$kjvTypes = $returnType
    }"""

    Expr(extensionDef)
  }
}

@experimental
class KFunctionObjectImpl extends MacroAnnotation {
  def transform(using Quotes)(tree: quotes.reflect.Definition): List[quotes.reflect.Definition] = {
    import quotes.reflect.*
    tree match {
      case ClassDef(className, ctr, parents, self, body) =>

        val metSymb = Symbol.newMethod(
          parent = tree.symbol,
          name = "asKotlin",
          flags = Flags.Final,
          tpe = MethodType(Nil)(_ => Nil, _ => TypeRepr.of[KUnit]),
          privateWithin = Symbol.noSymbol
        )

        val metDef = DefDef(metSymb, _ => Some('{ kotlin.Unit.INSTANCE }.asTerm))
        val newBody = metDef :: body

        List(ClassDef.copy(tree)(className, ctr, parents, self, body))

      case _ =>
        report.error("Annotation only supports `def` with one argument")
        List(tree)
    }
  }
}
