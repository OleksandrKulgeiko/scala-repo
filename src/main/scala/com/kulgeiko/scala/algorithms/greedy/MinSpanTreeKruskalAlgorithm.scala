package com.kulgeiko.scala.algorithms.greedy

import com.kulgeiko.scala.algorithms.GraphEdgeWeighted
import com.kulgeiko.scala.algorithms.Utils._

object MinSpanTreeKruskalAlgorithm {

  def main(args: Array[String]): Unit = {

    val list = readAdjacencyListWeighted("/stanford/course3/week1_edges.txt")
    val edges = list.map(r => GraphEdgeWeighted(r._1._1, r._1._2, r._2))

    val exploredEdges = scala.collection.mutable.Set[GraphEdgeWeighted]()

    // sort edge by length
    val edgesSorted = edges.sortBy(_.weight)

    for(edge <- edgesSorted){
      // check that it is not cyclic
      if (!areVerticesConnectedBfs(exploredEdges.toList, edge.v1, edge.v2)) {
        exploredEdges.add(edge)
        println(edge.weight)
      }
    }

    println(exploredEdges.toList.map(_.weight).sum) // -3612829
  }
}

