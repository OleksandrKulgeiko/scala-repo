package com.kulgeiko.scala.algorithms

import java.util
import com.kulgeiko.scala.algorithms.Utils._



object TwoSumProblemHashTables {

  def main(args: Array[String]): Unit = {


    // val list = List(1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l)
    val list = readToListLong("/stanford/course2/2sum.txt")

    val lBound = -10000
    val rBound = 10000
    var counter = 0

    val hashtable = new util.HashSet[Long]()
    list.foreach(n => hashtable.add(n))

    for(t <- lBound to rBound) {
      //println(s"$t")
      if (sumPairs(list, t))
        counter = counter + 1
    }

    def sumPairs(list: List[Long], t: Long): Boolean = {
      for (x <- list) {
        val y = t - x
        if (hashtable.contains(y) && x != y)
          return true
      }
      false
    }
    println(counter)
  }
}

