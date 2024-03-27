package halotukozak.core

import KBasicUtils.KUnit
import halotukozak.`macro`.KFunction.kotlinFunctionN
import halotukozak.`macro`.KFunctionMacros.{KFunction, SFunctionN}
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
import halotukozak.core.FunctionOps.*

final class FunctionOpsTest extends AnyWordSpec with Matchers {

  type TupleN[N <: Int] <: Tuple =
    N match {
      case 0 => EmptyTuple
      case _ => ? *: TupleN[N - 1]
    }

  "Conversion to Kotlin should be successful" when {
    //    "Unit" in {
    //      asKotlin() shouldBe a[KUnit]
    //      kotlin.Unit.INSTANCE.asScala shouldBe a[Unit]
    //    }

    s"Function0" in {
      val kotlinF: KFunction[Tuple1[String], Int] =
        new KFunction[Tuple1[String], Int] {
          override def invoke(s: String): Int = 42
        }

      //      val scalaF: SFunctionN[0, EmptyTuple, Int] = (() => 42)
      val dupa: SFunctionN[Tuple1[String], Int] = ((v1: String) => 42).tupled

      dupa.asKotlin.invoke("dupa") shouldBe 42
      //      asScala(kotlinF)
    }
  }
}
