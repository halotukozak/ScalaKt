package halotukozak.`macro`

import scala.compiletime.*
import scala.compiletime.ops.int.>
import halotukozak.`macro`.KFunctionMacros.KFunction
import kotlin.jvm.functions as kvf

import scala.Tuple.*
import scala.compiletime.ops.any.ToString
import compiletime.ops.any.ToString
import scala.compiletime.ops.string.{+, Matches}
import scala.Tuple.{Elem, Size}
import scala.quoted.*
import scala.reflect.*
import scala.annotation.{MacroAnnotation, experimental, targetName}
import scala.runtime.FunctionXXL
import scala.compiletime.*
import scala.compiletime.ops.any.*
import scala.compiletime.ops.int.{-, >, S}
import scala.compiletime.ops.string
import scala.deriving.Mirror

object KFunction {

  @targetName("CONCATENATE")
  type ++[A, B] <: String = (A, B) match
    case (a, b) => a + b

  inline def checkSize4[A <: Tuple, ExpectedSize <: Int]: Unit =
    inline if erasedValue[Size[A] != ExpectedSize] then
      type Message =
        "Too many fields in class: " ++ ToString[Size[A]] ++ " > " ++
          ToString[ExpectedSize]

      error(constValue[Message])

  inline def kotlinFunctionN[Types <: Tuple, R]: KFunction[Types, R] = ${
    kotlinFunctionNImpl
  }

  private def kotlinFunctionNImpl[Types <: Tuple, R](using
    Quotes,
    Type[R],
    Type[Types]
  ): Expr[KFunction[Types, R]] = {
    import quotes.reflect.*
    val nValue = 3 // todo
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
      s"""new functions.Function$nValue$types {
         |    override def invoke$args: String = "ok"
         |  }
         |""".stripMargin // todo use '
    val funDef = Expr(fun).asTerm.asExprOf[KFunction[Types, R]]
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

//@experimental
//class KFunctionObjectImpl extends MacroAnnotation {
//  def transform(using Quotes)(tree: quotes.reflect.Definition): List[quotes.reflect.Definition] = {
//    import quotes.reflect.*
//    tree match {
//      case ClassDef(className, ctr, parents, self, body) =>
//
//        val metSymb = Symbol.newMethod(
//          parent = tree.symbol,
//          name = "asKotlin",
//          flags = Flags.Override,
//          tpe = MethodType(Nil)(_ => Nil, _ => TypeRepr.of[KUnit]),
//          privateWithin = Symbol.noSymbol
//        )
//        val metDef = DefDef(metSymb, _ => Some('{ kotlin.Unit.INSTANCE }.asTerm))
//        val newBody = metDef :: body
//
//        List(ClassDef.copy(tree)(className, ctr, parents, self, newBody))
//
//      case _ =>
//        report.error("Annotation only supports `def` with one argument")
//        List(tree)
//    }
//  }
//}

import scala.quoted.*

object KFunctionMacros {
  private transparent inline def toInt[N <: Int]: Int =
    inline valueOf[N] match
      case 0 => 0
      case _: S[n1] => 1 + toInt[n1]

  type KFunction[Types <: Tuple, R] = Size[Types] match {
    case 0 => kvf.Function0[R]
    case 1 => kvf.Function1[Elem[Types, 0], R]
    //    case 2 => kvf.Function2[?, ?, R]
    //    case 3 => kvf.Function3[?, ?, ?, R]
    //    case 4 => kvf.Function4[?, ?, ?, ?, R]
    //    case _ => kvf.FunctionN[R]
  }

  type SFunctionN[Types <: Tuple, +R] = Types => R

  //  private def asScalaImpl[T <: KotlinFunctionN[N], N <: Int](f: Expr[T])(using Quotes): Expr[ScalaFunctionN[N]] = {
  //
  //  }

  inline def asKotlin[T <: SFunctionN[Types, R], Types <: Tuple, R](
    inline f: T
  ): KFunction[Types, R] = ${
    asKoltinImpl('{ constValue[Size[Types]] })('{ f })
  }

  def asKoltinImpl[T <: SFunctionN[Types, R], Types <: Tuple, R](
    n: Expr[Size[Types]]
  )(
    f: Expr[T]
  )(using
    Quotes,
    Type[R],
    Type[Types],
  ): Expr[KFunction[Types, R]] = {
    import quotes.reflect.*

    val nVal: Int = n.valueOrAbort
    val types = List.fill(nVal + 1)("?").mkString("[", ", ", "]")
    val args = (0 to nVal).map { i => s"p$i: Any" }.mkString("(", ", ", ")")
    //    val invoke = (0 to nVal).map { i => s"p$i" }.mkString("f(", ", ", ")")
    val returnType = Type.show[R]

    val symbol = Symbol.classSymbol(s"kotlin.jvm.functions.Function$nVal$types")
    New(
      symbol,
      List(
        Apply(
          Select.unique(
            New(
              Symbol.classSymbol(s"kotlin.jvm.functions.Function$nVal$types")
            ),
            "<init>"
          ),
          (0 to nVal).map { i =>
            Ident(
              Symbol.newVal(
                Symbol.spliceOwner,
                s"p$i",
                TypeRepr.of[Any],
                Flags.EmptyFlags,
                '{ f }
              )
            )
          }
        )
      )
    )
      .asExprOf[KFunction[Types, R]]
  }
}

object PrintTree {
  inline def printTree[T](inline x: T): Unit = ${ printTreeImpl('{ x }) }

  private def printTreeImpl[T](x: Expr[T])(using Quotes): Expr[Unit] = {
    import quotes.reflect.*

    val tree = x.asTerm
    val treeStr = Expr(tree.show(using Printer.TreeStructure))
    val treeTpeStr = Expr(tree.tpe.show(using Printer.TypeReprStructure))

    '{
      println("treeStr: ")
      print(${ treeStr })
      print("treeTpeStr: ")
      println(${ treeTpeStr })
    }
  }
}
