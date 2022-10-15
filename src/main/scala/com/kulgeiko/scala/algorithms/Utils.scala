package com.kulgeiko.scala.algorithms

import scala.collection.mutable.{Map => MMap}
import com.kulgeiko.scala.algorithms.graphs.Graphs._

abstract class GraphEdge {
  def v1: Int // vertex1
  def v2: Int // vertex2
}

case class GraphEdgeSimple(v1: Int, v2: Int) extends GraphEdge
case class GraphEdgeWeighted(v1: Int, v2: Int, weight: Int) extends GraphEdge

case class Cluster(id: String, vertices: List[Int])


//case class VertexWeighted()



object Utils {

  type Len = Int
  type Vertex = Int
  type Score = Int
  type Edge = (Vertex, Vertex)
  type EdgeWithLen = (Edge, Len)
  type EdgeWithScore = (Edge, Score)
  type Vertices = List[Vertex]
  type AdjacencyList = List[Edge]
  type AdjacencyListWithLen = List[EdgeWithLen]
  type Graph = AdjacencyList
  type AdjacencyArray = Array[Vertices]                  // Array index represents a vertex
  type AdjacencyMap = Map[Vertex, Vertices]
  type AdjacencyArrayWithLen = Array[Map[Vertex, Len]]   // Array index represents a vertex
  type GraphWithLen = AdjacencyArrayWithLen


  def getMaxVertex(graph: Graph, max: Vertex = 0): Vertex = graph match {
    case Nil => max
    case h :: tail =>
      val iMax = if (h._1 > h._2) h._1 else h._2
      val absMax = if (iMax > max) iMax else max
      getMaxVertex(tail, absMax)
  }



  def readList(path: String): List[Int] = {

    val inputStream = getClass.getResourceAsStream(path)
    val bufferedSource = io.Source.fromInputStream(inputStream)
    val rows: List[String] = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close

    val intList = rows.map(_.toInt)
    intList
  }

  def readListStrings(path: String): List[String] = {

    val inputStream = getClass.getResourceAsStream(path)
    val bufferedSource = io.Source.fromInputStream(inputStream)
    val rows: List[String] = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    rows
  }


  def readToListLong(path: String): List[Long] = {

    val inputStream = getClass.getResourceAsStream(path)
    val bufferedSource = io.Source.fromInputStream(inputStream)
    val rows: List[String] = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close

    val intList = rows.map(_.toLong)
    intList
  }


  def readAdjacencyList(path: String): AdjacencyList = {

    val inputStream = getClass.getResourceAsStream(path)
    val bufferedSource = io.Source.fromInputStream(inputStream)
    val rows: List[String] = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close

    val adjacencyList = rows map (t => {
      val arr = t.split(' ')
      val beg = arr(0).toInt
      val end = arr(1).toInt
      (beg, end)
    })
    adjacencyList
  }


  def readList2Ints(path: String): List[(Int, Int)] = {

    val inputStream = getClass.getResourceAsStream(path)
    val bufferedSource = io.Source.fromInputStream(inputStream)
    val rows: List[String] = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close

    val adjacencyList = rows map (t => {
      val arr = t.split(' ')
      val beg = arr(0).toInt
      val end = arr(1).toInt
      (beg, end)
    })
    adjacencyList
  }

  def readAdjacencyListWithLen(path: String): AdjacencyListWithLen = {

    val inputStream = getClass.getResourceAsStream(path)
    val bufferedSource = io.Source.fromInputStream(inputStream)
    val rows: List[String] = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close

    val adjacencyList = rows map (t => {
      val arr = t.split(' ')
      val beg = arr(0).toInt
      val end = arr(1).toInt
      val len = arr(2).toInt
      ((beg, end), len)
    })
    adjacencyList
  }

  def readAdjacencyListWeighted(path: String): List[((Int, Int),Int)] = {

    val inputStream = getClass.getResourceAsStream(path)
    val bufferedSource = io.Source.fromInputStream(inputStream)
    val rows: List[String] = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close

    val adjacencyList = rows map (t => {
      val arr = t.split(' ')
      val beg = arr(0).toInt
      val end = arr(1).toInt
      val len = arr(2).toInt
      ((beg, end), len)
    })
    adjacencyList
  }


  def readListNumPairs(path: String): List[(Int, Int)] = {

    val inputStream = getClass.getResourceAsStream(path)
    val bufferedSource = io.Source.fromInputStream(inputStream)
    val rows: List[String] = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close

    val adjacencyList = rows map (t => {
      val arr = t.split(' ')
      val beg = arr(0).toInt
      val end = arr(1).toInt
      (beg, end)
    })
    adjacencyList
  }



  def readAdjacencyMap(path: String): AdjacencyMap = {

    val inputStream = getClass.getResourceAsStream(path)
    val bufferedSource = io.Source.fromInputStream(inputStream)
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

  def readAdjacencyArrayWithLen(path: String): AdjacencyArrayWithLen = {

    val inputStream = getClass.getResourceAsStream(path)
    val bufferedSource = io.Source.fromInputStream(inputStream)
    val rows: List[String] = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close

    val adjacencyList = rows map (t => {
      val arr = t.split('\t')
      val beg = arr(0).toInt
      val map: MMap[Vertex, Len] = MMap[Vertex, Len]()

      for(i <- 1 until arr.length){
        val arrKeyVal = arr(i).split(',')
        val k = arrKeyVal(0).toInt
        val v = arrKeyVal(1).toInt
        map.put(k, v)
      }
      (beg, map)
    })

    val outArr = new AdjacencyArrayWithLen(rows.length + 1)

    adjacencyList.foreach(r => outArr(r._1) = r._2.toMap)

    outArr
  }


  def adjacencyListToAdjacencyArray(graph: AdjacencyList): AdjacencyArray = {
    val max = getMaxVertex(graph)
    val array = new Array[Vertices](max + 1)
    for(i <- array.indices) array(i) = Nil
    graph.foreach(f => {
      val i = f._1
      val v = f._2
      val lis = array(i)
      array(i) = v :: lis

    })
    array
  }

  def adjacentVertices(graph: Graph, v: Vertex, acc: Vertices = Nil): Vertices = graph match {
    case Nil => acc
    case h :: tail => v match {
      case h._1 => adjacentVertices(tail, v, h._2 :: acc)
      case h._2 => adjacentVertices(tail, v, h._1 :: acc)
      case _    => adjacentVertices(tail, v, acc)
    }
  }


  def adjacentVerticesDirected(graph: Graph, v: Vertex, acc: Vertices = Nil): Vertices = graph match {
    case Nil => acc
    case h :: tail => v match {
      case h._1 => adjacentVerticesDirected(tail, v, h._2 :: acc)
      case _    => adjacentVerticesDirected(tail, v, acc)
    }
  }



  def reversed(graph: Graph, acc: Graph = Nil): Graph = graph match {
    case Nil => acc
    case h :: tail => reversed(tail, (h._2, h._1) :: acc)
  }

  def inverseIndexVsValue(arr: Array[Int]): Array[Int] = {
    val out = new Array[Int](arr.length)
    for (i <- arr.indices) out(arr(i)) = i
    out
  }

  def areVerticesConnectedBfs(graph: List[GraphEdge], v1: Int, v2: Int): Boolean = {
    if (graph.isEmpty)
      false
    else {
      val vertices = graph.flatMap(e => List(e.v1, e.v2)).toSet
      if (vertices.contains(v1) && vertices.contains(v2)){
        val foundVertices = depthFirstSearchIterative(graph.map(r => (r.v1, r.v2)),v1)
        if (foundVertices.contains(v2)){
          println("Vertices connected")
          true
        }
        else
          false
      }
      else
        false
    }
  }


}
