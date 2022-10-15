package com.kulgeiko.scala.algorithms.graphs

import java.lang
import java.math.BigInteger

import com.kulgeiko.scala.algorithms.Utils._
import com.kulgeiko.scala.algorithms.datastructures.MedianMaintainer


object Heaps {


  def main(args: Array[String]): Unit = {


    val qq = new java.lang.String("111")

    val sssss = "Hi there, today we are going to sdf ds afsdf dsfsdfsd afsda"

    val hh = sssss.hashCode

    val fff: BigInteger = new BigInteger("-10000000000000000000000000")
    val fff1: BigInteger = new BigInteger("10000000000000000000000000")
    val fff2 = fff.add(new BigInteger("1"))

    //val rrrr = fff.multiply() * fff1

    val v0 = -551586160
    val v1 = -1258750277
    val v2 = 70357
    val v3 = 69026
    val v4 = -1775428430
    val v5 = 1092967616
    val v6 = 66
    val v7 = -522786539
    val v8 = 2124068110
    val v9 = 2237

    var r: Int = 17
    print(s"31*$r + $v0 = ")
    r = 31*r + v0
    println(r)
    print(s"31*$r + $v1 = ")
    r = 31*r + v1
    println(r)
    print(s"31*$r + $v2 = ")
    r = 31*r + v2
    println(r)
    print(s"31*$r + $v3 = ")
    r = 31*r + v3
    println(r)
    print(s"31*$r + $v4 = ")
    r = 31*r + v4
    println(r)
    print(s"31*$r + $v5 = ")
    r = 31*r + v5
    println(r)
    print(s"31*$r + $v0 = ")
    r = 31*r + v6
    println(r)
    print(s"31*$r + $v0 = ")
    r = 31*r + v7
    println(r)
    print(s"31*$r + $v0 = ")
    r = 31*r + v8
    println(r)

    r = 31*r + v9
    print(r)









    val numbers1 = List(1,2,3)
    val numbers2 = readList("/stanford/course2/Median.txt")

    var mediansSum = 0
    val medianMaintainer = new MedianMaintainer

    for (n <- numbers2){
      medianMaintainer.add(n)
      val median = medianMaintainer.median()
      mediansSum = mediansSum + median
    }

    println(mediansSum)
    println(mediansSum % 10000)

  }

}
