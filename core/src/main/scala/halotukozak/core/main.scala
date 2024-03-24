package halotukozak.core


import halotukozak.`macro`.KFunctionObjectImpl

import scala.annotation.experimental


//object FunctionOps:
//  @experimental
//  implicit inline def implicitMakeFunctionOps: FunctionOps.type = ${ KFunctionObjectImpl }
//

@experimental
@KFunctionObjectImpl
object FunctionOps

@experimental
@main def main(): Unit =
  FunctionOps.getClass.getNestMembers.foreach(println)
