package com.kulgeiko.scala.algorithms.graphs

import scala.util.Random


object MinCutKargers {

  type AdjacencyMap = Map[Int, List[Int]]
  type Edge = (Int, Int)


  def main(args: Array[String]): Unit = {

    val graph1: AdjacencyMap = Map(
      1 -> List(2, 2, 3, 4),
      2 -> List(1, 1, 4),
      3 -> List(1, 4, 5),
      4 -> List(2, 1, 3, 5),
      5 -> List(4, 3))

    val graph2 = readFile("D:/0_My_coding/7_Coursera/Algorithms/Stanford/kargerMinCut.txt")


    val graph = graph2


    for (i <- 1 to 1000) {
      val newGraph = contractEdgesUntilTwoVertex(graph)
      println(edgesNumber(newGraph))
    }
  }


  def contractEdgesUntilTwoVertex(map: AdjacencyMap): AdjacencyMap = {
    if (map.size > 2)
      contractEdgesUntilTwoVertex(contractEdge(map, randomEdge(map)))
    else
      map
  }

  def contractEdge(graph: AdjacencyMap, edge: Edge): AdjacencyMap = {
    if (graph.size <= 2)
      graph
    else {
      val v1 = edge._1
      val v2 = edge._2

      // New adjacent vertexes for v1
      val v1Nodes = (graph(v1) ::: graph(v2)).filter(p => p != v1 && p != v2)

      // ???
      val newGraph = graph.-(v2) + (v1 -> v1Nodes)

      // Update all references from v2 to v1
      val cleanGraph = for {
        (k, v) <- newGraph
      } yield (k, v.map(p => if (p != v2) p else v1))

      cleanGraph
    }
  }

  def randomEdge(map: AdjacencyMap): Edge = {
    val random = new Random
    val vertex1 = randomElementFromSeq(map.keySet.toSeq, random)
    val vertex2 = randomElementFromSeq(map(vertex1), random)
    (vertex1, vertex2)
  }

  def randomElementFromSeq[A](seq: Seq[A], random: Random): A = seq(random.nextInt(seq.length))

  def edgesNumber(m: AdjacencyMap): Integer = {
    val edges = for ((v1, list) <- m.toList; v2 <- list) yield (v1, v2)
    edges.size / 2
  }

  def readFile(path: String): AdjacencyMap = {
    val bufferedSource = io.Source.fromFile(path)
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close

    val mapTuple = lines map (t => {
      val l = t.split('\t').map(_.toString).toList
      val h = l.head.toInt
      val tail = l.tail.map(_.toInt).toList
      (h, tail)
    })
    val mm = Map(mapTuple map {t => t._1 -> t._2} : _*)
    mm

  }
}
