package halotukozak.core

import halotukozak.`macro`.KFunctionMacros
import halotukozak.`macro`.KFunctionMacros.{KFunction, SFunctionN}

object FunctionOps {

  //  extension [N <: Int, T <: KFunction[Types, R], Types <: Tuple, R](f: T)
  //    def asScala: Any = ???

  extension [N <: Int & Singleton, T <: SFunctionN[Types, R], Types <: Tuple, R](f: T)
    transparent inline def asKotlin: KFunction[Types, R] = KFunctionMacros.asKotlin(f)

}





//
//import halotukozak.core.KBasicUtils.*
//import kotlin.jvm.functions as kjv
//
//import scala.runtime.FunctionXXL
//
//
///*Scala to Kotlin*/
//extension (u: Unit)
//  def asKotlin: KUnit = kotlin.Unit.INSTANCE
//
//extension [R](f: () => R)
//  def asKotlin: kjv.Function0[R] = () => f()
//extension [T, R](f: T => R)
//  def asKotlin: kjv.Function1[? >: T, ? <: R] = (t: T) => f(t)
//extension [T1, T2, R](f: (T1, T2) => R)
//  def asKotlin: kjv.Function2[? >: T1, ? >: T2, R] = (t1: T1, t2: T2) => f(t1, t2)
//extension [T1, T2, T3, R](f: (T1, T2, T3) => R)
//  def asKotlin: kjv.Function3[? >: T1, ? >: T2, ? >: T3, R] = (t1: T1, t2: T2, t3: T3) => f(t1, t2, t3)
//extension [T1, T2, T3, T4, R](f: (T1, T2, T3, T4) => R)
//  def asKotlin: kjv.Function4[? >: T1, ? >: T2, ? >: T3, ? >: T4, R] = (t1: T1, t2: T2, t3: T3, t4: T4) => f(t1, t2, t3, t4)
//extension [T1, T2, T3, T4, T5, R](f: (T1, T2, T3, T4, T5) => R)
//  def asKotlin: kjv.Function5[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5) => f(t1, t2, t3, t4, t5)
//extension [T1, T2, T3, T4, T5, T6, R](f: (T1, T2, T3, T4, T5, T6) => R)
//  def asKotlin: kjv.Function6[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6) => f(t1, t2, t3, t4, t5, t6)
//extension [T1, T2, T3, T4, T5, T6, T7, R](f: (T1, T2, T3, T4, T5, T6, T7) => R)
//  def asKotlin: kjv.Function7[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7) => f(t1, t2, t3, t4, t5, t6, t7)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, R](f: (T1, T2, T3, T4, T5, T6, T7, T8) => R)
//  def asKotlin: kjv.Function8[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8) => f(t1, t2, t3, t4, t5, t6, t7, t8)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9) => R)
//  def asKotlin: kjv.Function9[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => R)
//  def asKotlin: kjv.Function10[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, ? >: T10, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => R)
//  def asKotlin: kjv.Function11[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, ? >: T10, ? >: T11, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => R)
//  def asKotlin: kjv.Function12[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, ? >: T10, ? >: T11, ? >: T12, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => R)
//  def asKotlin: kjv.Function13[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, ? >: T10, ? >: T11, ? >: T12, ? >: T13, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => R)
//  def asKotlin: kjv.Function14[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, ? >: T10, ? >: T11, ? >: T12, ? >: T13, ? >: T14, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => R)
//  def asKotlin: kjv.Function15[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, ? >: T10, ? >: T11, ? >: T12, ? >: T13, ? >: T14, ? >: T15, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => R)
//  def asKotlin: kjv.Function16[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, ? >: T10, ? >: T11, ? >: T12, ? >: T13, ? >: T14, ? >: T15, ? >: T16, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => R)
//  def asKotlin: kjv.Function17[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, ? >: T10, ? >: T11, ? >: T12, ? >: T13, ? >: T14, ? >: T15, ? >: T16, ? >: T17, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => R)
//  def asKotlin: kjv.Function18[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, ? >: T10, ? >: T11, ? >: T12, ? >: T13, ? >: T14, ? >: T15, ? >: T16, ? >: T17, ? >: T18, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => R)
//  def asKotlin: kjv.Function19[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, ? >: T10, ? >: T11, ? >: T12, ? >: T13, ? >: T14, ? >: T15, ? >: T16, ? >: T17, ? >: T18, ? >: T19, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => R)
//  def asKotlin: kjv.Function20[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, ? >: T10, ? >: T11, ? >: T12, ? >: T13, ? >: T14, ? >: T15, ? >: T16, ? >: T17, ? >: T18, ? >: T19, ? >: T20, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => R)
//  def asKotlin: kjv.Function21[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, ? >: T10, ? >: T11, ? >: T12, ? >: T13, ? >: T14, ? >: T15, ? >: T16, ? >: T17, ? >: T18, ? >: T19, ? >: T20, ? >: T21, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21)
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R](f: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => R)
//  def asKotlin: kjv.Function22[? >: T1, ? >: T2, ? >: T3, ? >: T4, ? >: T5, ? >: T6, ? >: T7, ? >: T8, ? >: T9, ? >: T10, ? >: T11, ? >: T12, ? >: T13, ? >: T14, ? >: T15, ? >: T16, ? >: T17, ? >: T18, ? >: T19, ? >: T20, ? >: T21, ? >: T22, R] = (t1: T1, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t10: T10, t11: T11, t12: T12, t13: T13, t14: T14, t15: T15, t16: T16, t17: T17, t18: T18, t19: T19, t20: T20, t21: T21, t22: T22) => f(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22)
//
//extension (f: FunctionXXL)
//  def asKotlin(arity: Int): kjv.FunctionN[Object] = new kjv.FunctionN[Object] {
//    override def invoke(p1: Object*): Object = f(IArray(p1 *))
//
//    override def getArity: Int = arity
//  }
//
///*Kotlin to Scala */
//extension (u: KUnit)
//  def asScala: Unit = ()
//extension [R](f: kjv.Function0[R]) {
//  def asScala: () => R = () => f.invoke()}
//extension [T, R](f: kjv.Function1[T, R])
//  def asScala: T => R = f.invoke
//extension [T1, T2, R](f: kjv.Function2[T1, T2, R])
//  def asScala: (T1, T2) => R = f.invoke
//extension [T1, T2, T3, R](f: kjv.Function3[T1, T2, T3, R])
//  def asScala: (T1, T2, T3) => R = f.invoke
//extension [T1, T2, T3, T4, R](f: kjv.Function4[T1, T2, T3, T4, R])
//  def asScala: (T1, T2, T3, T4) => R = f.invoke
//extension [T1, T2, T3, T4, T5, R](f: kjv.Function5[T1, T2, T3, T4, T5, R])
//  def asScala: (T1, T2, T3, T4, T5) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, R](f: kjv.Function6[T1, T2, T3, T4, T5, T6, R])
//  def asScala: (T1, T2, T3, T4, T5, T6) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, R](f: kjv.Function7[T1, T2, T3, T4, T5, T6, T7, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, R](f: kjv.Function8[T1, T2, T3, T4, T5, T6, T7, T8, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, R](f: kjv.Function9[T1, T2, T3, T4, T5, T6, T7, T8, T9, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R](f: kjv.Function10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R](f: kjv.Function11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R](f: kjv.Function12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R](f: kjv.Function13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R](f: kjv.Function14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R](f: kjv.Function15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R](f: kjv.Function16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R](f: kjv.Function17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R](f: kjv.Function18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R](f: kjv.Function19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R](f: kjv.Function20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R](f: kjv.Function21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => R = f.invoke
//extension [T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R](f: kjv.Function22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R])
//  def asScala: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => R = f.invoke
//extension [R](f: kjv.FunctionN[R])
//  def asScala: Seq[Any] => R = (d: Seq[Any]) => f.invoke(d *)
