package com.kulgeiko.scala.functions.caseclases


sealed trait Fruit

case class Apple(variety: String, colour: String) extends Fruit {
  override def toString: String = "This is " + variety + " apple, " + colour + " colour"
}

case class Plum(originCountry: String) extends Fruit {
  override def toString: String = "This is plum from " + originCountry
}


object CaseClasesMain extends App {

  val apple: Fruit = Apple("Semerenko", "green")
  val plum: Fruit = Plum("Ukraine")

  println(apple)
  println(plum)

  println(apple.isInstanceOf[Apple])

}
