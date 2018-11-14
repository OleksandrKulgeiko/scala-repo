package com.kulgeiko.scala.functions

object FunctionsMain extends App {


  // ------------------------------- Function literals
  val someNumbers: List[Int] = List(1,2,3,4,5,6,7,8,9)

  // (x > 5) - anonymous function literal
  val filtered1 = someNumbers.filter(x => x > 5)
  println(filtered1)

  // functional literal binded to variable
  val add = (a: Int) => a > 5
  val filtered2 = someNumbers.filter(add)
  println(filtered2)


  // ------------------------------- Implicit conversions

  implicit def doubleToInt(x: Double) = x.toInt
  val i: Int = 3.5

  def doubleToInt2(d: Double) = d.toInt
  val x: Int = doubleToInt2(42.0)

  // ------------------------------- Implicit parameters

  class PreferredPrompt(val preference: String)

  object Greeter {
    def greet(name: String)(implicit prompt: PreferredPrompt) {
      println("Welcome, "+ name +". The system is ready.")
      println(prompt.preference)
    }
  }

  val bobsPrompt = new PreferredPrompt("relax man> ")
  Greeter.greet("Oleksandr")(bobsPrompt)

  implicit val prompt = new PreferredPrompt("Yes, master> ")
  Greeter.greet("Oleksandr")


  // ------------------------------- Yield example

  val y = for (i <- 1 to 5) yield i * 2
  println(y)





}
