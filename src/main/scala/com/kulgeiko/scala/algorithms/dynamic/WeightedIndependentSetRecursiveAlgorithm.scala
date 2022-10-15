package com.kulgeiko.scala.algorithms.dynamic

import com.kulgeiko.scala.algorithms.Utils._


object WeightedIndependentSetRecursiveAlgorithm {

  def main(args: Array[String]): Unit = {

    // val fileData = readList("/stanford/course3/week3_mwis.txt")
    val fileData = List(3, 2, 1, 6, 4, 5)
    val graph = fileData


    val wis  = calculation(graph)
    //val reconstructed = reconstruction(wisArr, graphArray)
    println(wis)

  }

  def calculation(graph: List[Int]): Int = {
    if (graph.isEmpty)
      0
    else if (graph.size == 1)
      graph.head
    else
      graph match {
        case n1 :: n2 :: tail =>
          println(tail.size)
          val case1wis = calculation(n2 :: tail) // case 1: not include last nod
          val case2wis = calculation(tail) + n1  // case 2: include last node
          println(case1wis + ", " + case2wis)
          if (case1wis >= case2wis) case1wis else case2wis
      }
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

