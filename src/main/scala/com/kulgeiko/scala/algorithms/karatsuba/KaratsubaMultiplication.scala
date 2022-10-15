package com.kulgeiko.scala.algorithms.karatsuba

import java.math.BigInteger
import scala.math._

object KaratsubaMultiplication {

  def main(args: Array[String]): Unit = {

    /*
    3141592653589793238462643383279502884197169399375105820974944592
    2718281828459045235360287471352662497757247093699959574966967627
     */

    val x: BigInteger = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592")
    val y: BigInteger = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627")
    println(x)
    println(y)
    val z = x.multiply(y)
    println(z)
  }


  def karatsubaMult(x: Integer, y: Integer): Integer = {

    val len = (n: Integer) => n.toString.length

    if (x < 10 || y < 10) {
      x * y
    } else {
      // Calculate the size of the numbers
      val s1 = if (len(x) < len(y)) x else y
      val s2: Integer = ceil(s1/2).toInt

    2}

  }
}
