package halotukozak.core

import KBasicUtils.KPair
import java.util.concurrent as juc
import java.{lang as jl, util as ju}
import scala.collection.mutable
import scala.language.implicitConversions
import scala.jdk.javaapi.CollectionConverters as conv

object KPredef:
  extension (x: Byte) def asKotlin: jl.Byte = x.asInstanceOf[jl.Byte]
  extension (x: Short) def asKotlin: jl.Short = x.asInstanceOf[jl.Short]
  extension (x: Char) def asKotlin: jl.Character = x.asInstanceOf[jl.Character]
  extension (x: Int) def asKotlin: jl.Integer = x.asInstanceOf[jl.Integer]
  extension (x: Long) def asKotlin: jl.Long = x.asInstanceOf[jl.Long]
  extension (x: Float) def asKotlin: jl.Float = x.asInstanceOf[jl.Float]
  extension (x: Double) def asKotlin: jl.Double = x.asInstanceOf[jl.Double]
  extension (x: Boolean) def asKotlin: jl.Boolean = x.asInstanceOf[jl.Boolean]
  extension [A](i: Iterator[A])
    def asKotlin: ju.Iterator[A] = conv.asJava(i)
    def asKotlinEnumeration: ju.Enumeration[A] = conv.asJavaEnumeration(i)
  extension [A](i: Iterable[A])
    def asKotlin: jl.Iterable[A] = conv.asJava(i)
    def asKotlinCollection: ju.Collection[A] = conv.asJavaCollection(i)
  extension [A](b: mutable.Buffer[A]) def asKotlin: ju.List[A] = conv.asJava(b)
  extension [A](s: mutable.Seq[A]) def asKotlin: ju.List[A] = conv.asJava(s)
  extension [A](s: Seq[A]) def asKotlin: ju.List[A] = conv.asJava(s)
  extension [A](s: mutable.Set[A]) def asKotlin: ju.Set[A] = conv.asJava(s)
  extension [A](s: Set[A]) def asKotlin: ju.Set[A] = conv.asJava(s)
  extension [K, V](m: mutable.Map[K, V])
    def asKotlin: ju.Map[K, V] = conv.asJava(m)
    def asKotlinDictionary: ju.Dictionary[K, V] = conv.asJavaDictionary(m)
  extension [K, V](m: Map[K, V]) def asKotlin: ju.Map[K, V] = conv.asJava(m)
  extension [K, V](m: collection.concurrent.Map[K, V])
    def asKotlin: juc.ConcurrentMap[K, V] = conv.asJava(m)
  extension [A, B](t: (A, B))
    def asKotlin: KPair[A, B] = new KPair[A, B](t._1, t._2)
