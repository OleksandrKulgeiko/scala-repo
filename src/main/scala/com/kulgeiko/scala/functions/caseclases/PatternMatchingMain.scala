package com.kulgeiko.scala.functions.caseclases




object PatternMatchingMain extends App {



  println("-------------------------------------------------------- Constanr patterns")
  def describe(x: Any): String = x match {
    case 5       => "five"
    case true    => "truth"
    case "hello" => "hi!"
    case Nil     => "the empty list"
    case _       => "something else"
  }
  println(describe(Nil))  // the empty list
  println(describe("hi")) // something else

  println("-------------------------------------------------------- Variable patterns")
  def varPattern(expr: Any) = expr match {
    case 0 => "zero"
    case somethingElse => "not zero: "+ somethingElse
  }
  println(varPattern(0))      // zero
  println(varPattern(List(1, 2, 3))) // not zero: List(1, 2, 3)

  println("-------------------------------------------------------- Typed patterns")
  def generalSize(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }
  println(generalSize("Oleksandr"))   // 9
  println(generalSize(List(1, 2, 3))) // -1
  println(generalSize(Map(1 -> 1)))   // 1


  println("-------------------------------------------------------- Case classes patterns")
  trait Animal
  case class Dog(name: String) extends Animal
  case class Cat(name: String) extends Animal
  case object Woodpecker extends Animal

  def determineType(x: Animal): String = x match {
    case Dog(moniker) => "Got a Dog, name = " + moniker
    case _: Cat       => "Got a Cat (ignoring the name)"
    case Woodpecker   => "That was a Woodpecker"
    case _            => "That was something else"
  }
  println(determineType(Dog("Rocky")))  // Got a Dog, name = Rocky
  println(determineType(Cat("Rusty the Cat"))) // Got a Cat (ignoring the name)
  println(determineType(Woodpecker)) // That was a Woodpecker

  case class Person(name: String, letter: Char)
  val a = Person("John", 'c')
  val b = 'c'
  a match {
    //case Person("John", b) => println("One")
    case Person("John", `b`) => println("Two")
    case Person("John", 'b') => println("Three")
  }

}
