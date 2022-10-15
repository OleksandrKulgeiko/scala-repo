package com.kulgeiko.scala.functions

object FunctionsMain extends App {




  println("------------------------------- Function literals (first-class functions)")
  val someNumbers: List[Int] = List(1,2,3,4,5,6,7,8,9)

  // (x > 5) - anonymous function literal
  val filtered1 = someNumbers.filter(x => x > 5)
  println(filtered1)

  // with placeholder syntax
  val filtered2 = someNumbers.filter(_ > 5)
  println(filtered2)

  // functional literal binded to variable
  val add = (a: Int) => a > 5
  val filtered3 = someNumbers.filter(add)
  println(filtered3)



  println("------------------------------- Partly applied function")
  def sum (a: Int, b: Int, c:Int) = a + b + c
  val a = sum _
  val b = a(1, 2, 3)


  println("------------------------------- Higher-order functions")
  val salaries = Seq(20000, 70000, 40000)
  val doubleSalary = (x: Int) => x * 2
  val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
  println(newSalaries)


  val fruits = Seq("apple", "banana", "orange")
  val fruits2 =fruits.map(_.toUpperCase)
  println(fruits2)
  val fruits3 =fruits.flatMap(_.toUpperCase)
  println(fruits3)


  println("------------------------------- Currying Functions")

  def finalPriceCurried(vat: Double)
                       (serviceCharge: Double)
                       (productPrice: Double): Double =
    productPrice + productPrice*serviceCharge/100 + productPrice*vat/100

  val vatApplied = finalPriceCurried(20)_
  val serviceChargeApplied = vatApplied(12.5)
  val finalProductPrice = serviceChargeApplied(120)
  println(finalProductPrice)

  println("------------------------------- Closure")

  val more: Int = 3
  val cl = (x: Int) => x + more


  println("------------------------------- Lazy Evaluations")

  val x1: Int = {print ("foo "); 10}
  print("bar ")
  print(x1)
  println() // foo bar 10

  lazy val x2: Int = {print ("foo "); 10}
  print("bar ")
  print(x2)
  println() // bar foo 10

  println("------------------------------- Implicit conversions")


  implicit def doubleToInt(x: Double) = x.toInt
  val i: Int = 3.5

  def doubleToInt2(d: Double) = d.toInt
  val x: Int = doubleToInt2(42.0)

  println(" ------------------------------- Implicit conversions (different methods on class)")
  class ClassOne[T](val input: T)

  class ClassOneStr(val one: ClassOne[String]) {
    def duplicatedString() = one.input + one.input
  }
  class ClassOneInt(val one: ClassOne[Int]) {
    def duplicatedInt() = one.input.toString + one.input.toString
  }
  implicit def toStrMethods(one: ClassOne[String]) = new ClassOneStr(one)
  implicit def toIntMethods(one: ClassOne[Int]) = new ClassOneInt(one)

  val oneStrTest = new ClassOne("test")
  val oneIntTest = new ClassOne(123)

  println(oneStrTest.duplicatedString())
  println(oneIntTest.duplicatedInt())




  println("------------------------------- Implicit parameters")

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












  println("------------------------------- Yield example")

  val y = for (i <- 1 to 5) yield i * 2
  println(y)

  val myList1 = List(1, 2, 3, 4, 5, 6)
  val myList2: List[String] = List()

  //val outputList = for (l <- myList2) yield l*3

  val outputList = myList2.map(f => f + "TTTT")

  //val outputList = myList2 match {
  //  case Nil => Nil
  //  case _ =>
  //}

  println(outputList)






}
