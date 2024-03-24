package halotukozak.core

import KBasicUtils.KUnit
import halotukozak.`macro`.KFunction.kotlinFunctionN
import kotlin.jvm.functions as kvf
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.Tuple.*
import scala.annotation.tailrec
import scala.compiletime.constValue
import scala.compiletime.ops.int.{-, S}
import scala.language.implicitConversions
import scala.quoted.*
import scala.runtime.FunctionXXL

final class FunctionOpsTest
  extends AnyWordSpec
    with Matchers {

  type TupleN[+Tpe, N <: Int] <: Tuple =
    N match {
      case 0 => EmptyTuple
      case _ => Tpe *: TupleN[Tpe, N - 1]
    }

  type FunctionN[N <: Int, -T, +R] =
    TupleN[T, N] => R


  "Conversion to Kotlin should be successful" when {
    "Unit" in {
      {}.asKotlin shouldBe a[KUnit]
      kotlin.Unit.INSTANCE.asScala shouldBe a[Unit]
    }


    s"Function0" in {
      val scalaF = (args: TupleN[Int, 0]) => "ok"
      val kotlinF = kotlinFunctionN(0)

      scalaF.asKotlin should be theSameInstanceAs kotlinF.asInstanceOf[AnyRef]
      kotlinF.asScala should be theSameInstanceAs scalaF
    }
  }
}