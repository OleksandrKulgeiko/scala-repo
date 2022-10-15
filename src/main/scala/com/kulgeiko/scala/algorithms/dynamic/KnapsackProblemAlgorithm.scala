package com.kulgeiko.scala.algorithms.dynamic

import com.kulgeiko.scala.algorithms.Utils._


case class Item(value: Int, size: Int)

object KnapsackProblemAlgorithm {

  def main(args: Array[String]): Unit = {

    val capacity = 10000
    // val fileData = List((3,4),(2,3),(4,2),(4,3))
    val fileData = readList2Ints("/stanford/course3/week4_knapsack1.txt")
    // val fileData = readList2Ints("/stanford/course3/week4_knapsack_big.txt")

    val items = fileData.map(f => Item(f._1, f._2))
    val itemsArray = (Item(0,0) :: items).toArray    // 1 based
    val itemsNum: Int = items.size

    val arr = Array.ofDim[Int](itemsNum + 1, capacity + 1)

    for(c <- 0 to capacity) {
      arr(0)(c) = 0
    }

    for(i <- 1 to itemsNum){
      for(c <- 0 to capacity){
        if (itemsArray(i).size > c) {
          arr(i)(c) = arr(i - 1)(c)
        }
        else {
          val case1 = arr(i - 1)(c)
          val case2 = arr(i - 1)(c - itemsArray(i).size) + itemsArray(i).value
          arr(i)(c) = if (case1 > case2) case1 else case2
        }
      }
    }

    println(arr(itemsNum)(capacity)) // 2493893

  }

  /*
  def reconstruction(wisArr: Array[Int], graphArray: Array[Int]): List[Int] = {

    var verticesMwis: List[Int] = List()
    var i = wisArr.length - 1

    while(i >= 2){
      if (wisArr(i - 1) >= wisArr(i - 2) + graphArray(i))
        i = i - 1
      else {
        verticesMwis = verticesMwis :+ i
        i = i - 2
      }
      if (i == 1)
        verticesMwis = verticesMwis :+ i
    }
    verticesMwis
  }
  */


}

