package com.kulgeiko.scala.algorithms.dynamic

import com.kulgeiko.scala.algorithms.Utils._


object WeightedIndependentSetAlgorithm {

  def main(args: Array[String]): Unit = {

    val fileData = readList("/stanford/course3/week3_mwis.txt")
    // val fileData = List(3, 2, 1, 6, 4, 5)

    val graph = fileData
    val graphSize = graph.size
    val graphArray = (0 :: fileData).toArray // 1 based


    val wisArr = new Array[Int](graphSize + 1)
    wisArr(0) = 0
    wisArr(1) = graphArray(1)

    for(i <- 2 to graphSize) {
      val case1 = wisArr(i - 1)
      val case2 = wisArr(i - 2) + graphArray(i)
      wisArr(i) = if (case1 > case2) case1 else case2
    }

    val reconstructed = reconstruction(wisArr, graphArray)
    println("Ku-ku")

  }

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


}

