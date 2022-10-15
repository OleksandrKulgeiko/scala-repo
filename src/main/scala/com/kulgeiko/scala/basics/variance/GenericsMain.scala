package com.kulgeiko.scala.basics.variance

class Gadget {
  var name: String = _
}


// Gadget <- Phone <- MobilePhone <- SmartPhone <- IPhone <- IPhoneX

class Phone extends Gadget
class MobilePhone extends Phone
class SmartPhone extends MobilePhone
class IPhone extends SmartPhone
class IPhoneX extends IPhone


class NewHolder[T <: IPhone] // Supports IPhone and all its subtypes (IPhoneX e.g.)
class OldHolder[T >: IPhone] // Supports IPhone and all its parent types (MobilePhone e.g.)

object GenericsTest extends App {

  // val newHolder: NewHolder[Phone] = new NewHolder[Phone]    // will NOT compile
  val oldHolder: OldHolder[Phone] = new OldHolder[Phone]  // will compile

}