package halotukozak.core

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import halotukozak.core.KPredef._
import java.{lang => jl, util => ju}

class KPredefTest extends AnyFlatSpec, Matchers {

  "Byte asKotlin" should "return a java.lang.Byte" in {
    val byte: Byte = 1
    byte.asKotlin shouldBe a[jl.Byte]
  }

  "Short asKotlin" should "return a java.lang.Short" in {
    val short: Short = 1
    short.asKotlin shouldBe a[jl.Short]
  }

  "Char asKotlin" should "return a java.lang.Character" in {
    val char: Char = 'a'
    char.asKotlin shouldBe a[jl.Character]
  }

  "Int asKotlin" should "return a java.lang.Integer" in {
    val int: Int = 1
    int.asKotlin shouldBe a[jl.Integer]
  }

  "Long asKotlin" should "return a java.lang.Long" in {
    val long: Long = 1
    long.asKotlin shouldBe a[jl.Long]
  }

  "Float asKotlin" should "return a java.lang.Float" in {
    val float: Float = 1
    float.asKotlin shouldBe a[jl.Float]
  }

  "Double asKotlin" should "return a java.lang.Double" in {
    val double: Double = 1
    double.asKotlin shouldBe a[jl.Double]
  }

  "Boolean asKotlin" should "return a java.lang.Boolean" in {
    val boolean: Boolean = true
    boolean.asKotlin shouldBe a[jl.Boolean]
  }

  // Similar tests for Char, Int, Long, Float, Double, Boolean

  "Iterator asKotlin" should "return a java.util.Iterator" in {
    val iterator = Iterator(1, 2, 3)
    iterator.asKotlin shouldBe a[ju.Iterator[_]]
  }

  "Iterator asKotlinEnumeration" should "return a java.util.Enumeration" in {
    val iterator = Iterator(1, 2, 3)
    iterator.asKotlinEnumeration shouldBe a[ju.Enumeration[_]]
  }

  // Similar tests for Iterable, Buffer, Seq, Set, Map, Tuple

}
