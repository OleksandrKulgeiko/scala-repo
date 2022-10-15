package com.kulgeiko.scala.coursera.fp

object Week1Main extends App {

/*
  def abs(x:Double) = if (x < 0) -x else x

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double) = ???

  def improve(guess: Double, x: Double) =(guess + x / guess) / 2

  def sqrt(x: Double) = sqrtIter(1.0, x)
*/

  /*
  def balance(chars: List[Char]): Boolean = {
    def loop(open: Int, close: Int, isBalanced: Boolean, chars: List[Char]): Boolean = {
      if (chars.isEmpty) isBalanced
      else {
        if (chars.head == '(') loop(open + 1, close, open + 1 == close, chars.tail)
        if (chars.head == ')') loop(open, close + 1, open == close + 1, chars.tail)
        else loop(open, close, open == close, chars.tail)
      }
    }
    val dd = loop(0, 0, true, chars)
    dd
  }
  println(balance("(".toList))
  */



  /*
  def countChange(money: Int, coins: List[Int]): Int = {
    def count(coins: List[Int], m: Int, money: Int, ): Int = {

      if (money == 0) 1
      if (money < 0) 0
      if (m <= 0 && money >= 1) 0
      count(coins, m - 1, money) + count(coins, m, n - )
    }
  }
  countChange(10, List(1, 2))
  */

  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0) 0
    else if (money >= 1 && coins.isEmpty) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)

    /*
    def count(money: Int, n: Int): Int = {
      if (money == 0) 1
      else if (money < 0) 0
      else if (money >= 1 && n <= 0) 0
      else count(money, n - 1) + count(money - coins(n - 1), n)
    }
    */
    /*
    def count(money: Int, coins: List[Int], n: Int): Int = {
      if (money == 0) 1
      else if (money < 0) 0
      else if (money >= 1 && n <= 0) 0
      else count(money, coins, n - 1) + count(money - coins(n - 1), coins, n)
    }
    */
    /*
    def count(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (money < 0) 0
      else if (money >= 1 && coins.isEmpty) 0
      else count(money, coins.tail) + count(money - coins.head, coins)
    }
    count(money, coins)
    */
  }



  //val money = 2
  val money = 300
  //val coins = List(2,1)
  val coins = List(500,5,50,100,20,200,10)
  println(countChange(money, coins))
  //println(coins(-1))
}
