package com.kulgeiko.scala.algorithms

object Dynamic extends App {

  def fibonacci(n: Int): Int = {
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    println("Called...")
    if (n == 0)
      0
    else if (n == 1)
      1
    else
      fibonacci(n - 1) + fibonacci(n - 2)
  }
  println(fibonacci(8))





  val cache: scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map.empty
  def fibonacciDynamic(n: Int): Int = {
    println("Called dynamic...")
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    if (n == 0)
      0
    else if (n == 1)
      1
    else if (cache.isDefinedAt(n)) cache(n)
    else {
      cache.put(n, fibonacciDynamic(n - 1) + fibonacciDynamic(n - 2))
      cache(n)
    }
  }
  println(fibonacciDynamic(8))
}
