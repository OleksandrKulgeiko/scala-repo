package com.kulgeiko.scala.functions.forrevisited





object ForRevisited extends App {

  case class Person(name: String, isMale: Boolean, children: Person*)

  val lara = Person("Lara", false)
  val bob = Person("Bob", true)
  val julie = Person("Julie", false, lara, bob)
  val persons = List(lara, bob, julie)

  val mothersAndKids = for {
    p <- persons
    if !p.isMale
    c <- p.children
  } yield (p.name, c.name)

  println(mothersAndKids)


  println("------------------------------------------- N-Queens")

  def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
    queens forall (q => !inCheck(queen, q))
  def inCheck(q1: (Int, Int), q2: (Int, Int)) =
    q1._1 == q2._1 || // same row
      q1._2 == q2._2 || // same column
      (q1._1 - q2._1).abs == (q1._2 - q2._2).abs // on diagonal

  def queens(n: Int): List[List[(Int, Int)]] = {
    def placeQueens(k: Int): List[List[(Int, Int)]] =
      if (k == 0)
        List(List())
      else
        for {
          queens <- placeQueens(k - 1)
          column <- 1 to n
          queen = (k, column)
          if isSafe(queen, queens)
        } yield queen :: queens
    placeQueens(n)
  }

}
