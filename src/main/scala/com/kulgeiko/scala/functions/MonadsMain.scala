package com.kulgeiko.scala.functions

object MonadsMain extends App{

  def squareFunction(x: Int): Option[Int] = Some(x * x)

  def incrementFunction(x: Int): Option[Int] = Some(x + 1)

  val x = 5
  val monad: Option[Int] = Some(x)
  val result = monad.flatMap(squareFunction) == squareFunction(x)
  println(result)

}
