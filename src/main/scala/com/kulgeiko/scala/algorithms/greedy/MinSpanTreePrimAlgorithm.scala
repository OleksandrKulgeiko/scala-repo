package com.kulgeiko.scala.algorithms.greedy

import com.kulgeiko.scala.algorithms.Utils._


object MinSpanTreePrimAlgorithm {

  def main(args: Array[String]): Unit = {

    val list = readAdjacencyListWithLen("/stanford/course3/week1_edges.txt")

    /*
    val list = List(
      ((1, 2), 6),
      ((1, 4), 5),
      ((1, 5), 4),
      ((2, 4), 1),
      ((2, 5), 2),
      ((2, 3), 5),
      ((2, 6), 3),
      ((3, 6), 4),
      ((4, 5), 2),
      ((5, 6), 4)
    )
    */

    val exploredVert = scala.collection.mutable.Set(1)
    val exploredEdges = scala.collection.mutable.Set[EdgeWithLen]()
    var crossFrontierEdges = list.filter(e =>
      (exploredVert.contains(e._1._1) && !exploredVert.contains(e._1._2)) ||
        (!exploredVert.contains(e._1._1) && exploredVert.contains(e._1._2))
    )


    while(crossFrontierEdges.nonEmpty){

      val newEdge = crossFrontierEdges.minBy(_._2)
      val newVert = if (exploredVert.contains(newEdge._1._1)) newEdge._1._2 else newEdge._1._1

      println(crossFrontierEdges.size)
      exploredEdges.add(newEdge)
      exploredVert.add(newVert)

      crossFrontierEdges = list.filter(e =>
        (exploredVert.contains(e._1._1) && !exploredVert.contains(e._1._2)) || (!exploredVert.contains(e._1._1) && exploredVert.contains(e._1._2)))
    }

    println("cost is = " + exploredEdges.toList.map(_._2).sum) // -3612829
  }
}

