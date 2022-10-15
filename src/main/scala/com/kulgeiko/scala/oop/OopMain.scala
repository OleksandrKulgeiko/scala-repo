package com.kulgeiko.scala.oop

class Apple(name: String)

// The main/primary constructor is defined when you define your class
class Pineapple(var price: Double, var size: String, var country: String) {
  // Secondary constructor
  def this(price: Int) = this(price, "?", "?")
  // Another secondary constructor
  def this(price: Int, size: String) = this(price, size, "?")

  override def toString: String = {price + " " + size + " " + country}
}


class Person(name: String, age: Integer, favColor: String)
object Person {
  def apply(name: String, age: Integer, favColor: String): Person = {
    println("Constructing person from companion object...")
    new Person(name, age, favColor)
  }
}


object OopMain extends App {


  val apple = new Apple("Semerenko")

  println("-------------------------------------------------------- Constructor")
  val pin1 = new Pineapple(20, "XL", "Brasil")
  val pin2 = new Pineapple(500)
  val pin3 = new Pineapple(5, "S")
  println(pin1) // 20.0 XL Brasil
  println(pin2) // 500.0 ? ?
  println(pin3) // 5.0 S ?

  println("-------------------------------------------------------- Constructor in companion object")
  val p1 = new Person("Bob", 45, "Green") // uses normal constructor
  val p2 = Person("Bob", 45, "Green") // uses apply method from companion object

  println("-------------------------------------------------------- OOP stuff")




}
