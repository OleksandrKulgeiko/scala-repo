package com.kulgeiko.scala.tasks


object Neverland {
  trait Nat
  trait Zero extends Nat
  trait OnePlus[N <: Nat] extends Nat
  type One = OnePlus[Zero]
  trait Returns[R] {
    type Result <: R
  }

  /*
  trait <+>[A <: Nat, B <: Nat] extends Returns[Nat]

  object <+> {
    implicit def base[B <: Nat]: (Zero <+> B) {type Result = B} = null
    implicit def step[A <: Nat, B <: Nat](implicit A_plus_B: A <+> B): (OnePlus[A] <+> B) {type Result = OnePlus[A_plus_B.Result]} = null
  }

  trait <*>[A <: Nat, B <: Nat] extends Returns[Nat]

  object <*> {
    implicit def base[A <: Nat]: (One <*> A) {type Result = A} = null

    implicit def step[A <: Nat, B <: Nat, AB <: Nat](implicit ev: (A <*> B) {type Result = AB},
                                                     x: /*????*/): (OnePlus[A] <*> B) {type Result = x.Result} = null
  }
}

object RealWorld extends App {

  import Neverland._
  def number[N <: Nat](implicit value: Int with N): Int = value
  implicit def zero = 0.asInstanceOf[Int with Zero]
  implicit def onePlus[N <: Nat](implicit V: Int with N) = (V + 1).asInstanceOf[Int with OnePlus[N]]
  def refine[T <: AnyRef](implicit t: T): t.type = t

  println(
    type Three = OnePlus[OnePlus[One]]

  val product = refine[Three <*> OnePlus[Three]]
  number(product.Result)
  )*/
}