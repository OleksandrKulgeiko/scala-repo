package com.kulgeiko.scala.algorithms.dynamic

import com.kulgeiko.scala.algorithms.Utils._




object KnapsackProblemAlgorithmBig {

  def main(args: Array[String]): Unit = {

    val capacity = 2000000
    // val fileData = List((3,4),(2,3),(4,2),(4,3))
    val fileData = readList2Ints("/stanford/course3/week4_knapsack_big.txt")

    val items = fileData.map(f => Item(f._1, f._2))
    val itemsArray = (Item(0,0) :: items).toArray    // 1 based
    val itemsNum: Int = items.size

    // val arr = Array.ofDim[Int](itemsNum + 1, capacity + 1)
    val arr = Array.ofDim[Int](2, capacity + 1)

    for(c <- 0 to capacity) {
      arr(0)(c) = 0
    }

    for(i <- 1 to itemsNum){
      for(c <- 0 to capacity){
        if (itemsArray(i).size > c) {
          arr(1)(c) = arr(0)(c)
        }
        else {
          val case1 = arr(0)(c)
          val case2 = arr(0)(c - itemsArray(i).size) + itemsArray(i).value
          arr(1)(c) = if (case1 > case2) case1 else case2
        }
      }

      for(c <- 0 to capacity) {
        arr(0)(c) = arr(1)(c)
      }

    }

    println(arr(0)(capacity)) // 4243395
    println(arr(1)(capacity)) // 4243395


  }


}

