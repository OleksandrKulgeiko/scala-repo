package com.kulgeiko.scala.coursera.fp



/*
abstract class Boolean {

  def ifTenElse[T](t: => T, e: => T): T

  def && (x: => Boolean): Boolean = ifTenElse()
}
*/
/*

// Peano numbers
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}
object Zero extends Nat {
  def isZero: Boolean = true
  def predecessor: Nat = throw new Exception("0.predecessor")
  def + (that: Nat): Nat = that
  def - (that: Nat): Nat = if (that.isZero) this else throw new Exception("Negative number")
}

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false
  def predecessor: Nat = n
  def + (that: Nat): Nat = new Succ(n + that)
  def - (that: Nat): Nat = if (that.isZero) this else n - that.predecessor
}


// Define an object List{...} with 3 functions in it so that users can create lists of length 0-2 using syntax


trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}


object List {
  def apply[T]() = new Nil
  def apply[T](x: T) = new Cons(x, new Nil)
  def apply[T](x: T, y: T) = new Cons(x, new Cons(y, new Nil))
}

//List() //the empty list
//List(1) //the list with single element 1.
//List(2, 3) // the list with elements 2 and 3
*/
