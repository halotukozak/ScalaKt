package halotukozak.core

import halotukozak.core.KBasicUtils.*

import scala.language.implicitConversions

object KBasicUtils {
  type KUnit = kotlin.Unit
  type KPair[A, B] = kotlin.Pair[A, B]
  type KTriple[A, B, C] = kotlin.Triple[A, B, C]
}

extension [A, B](pair: KPair[A, B])
  def first: A = pair.getFirst
  def second: B = pair.getSecond
  implicit def toTuple: (A, B) = (pair.first, pair.second)

extension [A, B](tuple: (A, B))
  implicit def toKPair: KPair[A, B] = new KPair(tuple._1, tuple._2)

extension [A, B, C](triple: KTriple[A, B, C])
  def first: A = triple.getFirst
  def second: B = triple.getSecond
  def third: C = triple.getThird
  implicit def toTuple: (A, B, C) = (triple.first, triple.second, triple.third)

extension [A, B, C](tuple: (A, B, C))
  implicit def toKTriple: KTriple[A, B, C] = new KTriple(tuple._1, tuple._2, tuple._3)

object KPair:
  implicit def KPairToTuple2[A, B](pair: KPair[A, B]): (A, B) = pair.toTuple

  implicit def Tuple2ToKPair[A, B](tuple: (A, B)): KPair[A, B] = tuple.toKPair

object KTriple:
  implicit def KTripleToTuple3[A, B, C](triple: KTriple[A, B, C]): (A, B, C) = triple.toTuple

  implicit def Tuple3ToKTriple[A, B, C](tuple: (A, B, C)): KTriple[A, B, C] = tuple.toKTriple
