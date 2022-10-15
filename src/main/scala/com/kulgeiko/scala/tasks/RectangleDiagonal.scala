package com.kulgeiko.scala.tasks

object RectangleDiagonal extends App {

  /*
  val arr1 = Array(1, 2, 3, 4 ,5)
  val arr2 = Array(Array(1, 1), Array(1, 2))


  def outLines(row: Array[Int]) = {
    val line = for {
      e <- row
    } yield e
    println(line.mkString(" "))
  }

  def outLines(row: List[Int]) = {
    val line = for {
      e <- row
    } yield e
    println(line.mkString(" "))
  }

  def rectangleDiagonal(n: Int): List[List[Int]] = {
    val ff = for {
      x <- 0 until n
      row = (0 until n).map(t => num(x, t)).toList
    } yield row
    ff.toList
  }

  def num(row: Int, col: Int): Int = (row, col) match {
    case (0, 0) => 1
    case (_, 0) => num(row - 1, 0) + (row + 1)
    case _      => num(row, col - 1) + col + row
  }

  //arr2 map outLines
  rectangleDiagonal(6) map outLines
*/

  //def xToDiag(x: Int): Seq[(Int, Int)] = for (xs <- x to 0 by -1) yield (xs, x - xs)



  /*
  def ccc(x: Int, y: Int, acc: List[(Int, Int)]): List[(Int, Int)] = (x, y) match {
    case (xs, ys) if xs == ys =>
    case _ =>

  }*/


  def xyToDiag(x: Int, y: Int): Seq[(Int, Int)] = for {
    step <- 0 to x - y
    xs = x - step
    ys = y + step
  } yield (xs, ys)

  def rectangleEdges(x: Int): List[(Int, Int)] = {
    val w = for (xs <- 0 to x) yield (xs, 0)
    val h = for (xs <- 1 to x) yield (x, xs)
    w.toList ::: h.toList
  }

  def rectangleD(x: Int) = {
    rectangleEdges(x).flatMap(f => xyToDiag(f._1,f._2))
  }


  println(xyToDiag(3,3))
  println(rectangleD(4))


}
