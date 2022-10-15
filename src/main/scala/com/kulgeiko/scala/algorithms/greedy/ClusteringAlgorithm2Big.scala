package com.kulgeiko.scala.algorithms.greedy

import com.kulgeiko.scala.algorithms.Utils._
import edu.princeton.cs.algs4._


case class Node(vertex: Vertex, bits: String)

case class HammingDistances(m: Map[Int, Set[String]])


object ClusteringAlgorithm2Big {

  def main(args: Array[String]): Unit = {

    val fileData = readListStrings("/stanford/course3/week2_clustering_big.txt")

    // calculations
    val graphNodes = {
      val distinctBits = fileData.distinct
      var count = 0
      for(bits <- distinctBits)
        yield {
          count = count + 1
          Node(count, bits.replaceAll("\\s", ""))
        }
    }

    val bitsToVertexMap = graphNodes.map(n => n.bits -> n.vertex).toMap
    val clustersUF = new UF(graphNodes.size)

    // one unit distance
    for(graphNode <- graphNodes){
      val oneUnitAdjacentBits = Hamming.oneUnitDistBits(graphNode.bits)
      for(adjBits <- oneUnitAdjacentBits){
        val adjVertex = bitsToVertexMap.get(adjBits)
        if (adjVertex.isDefined)
          clustersUF.union(graphNode.vertex, adjVertex.get)
      }
    }

    println(clustersUF.count())


    // two unit distance
    for(graphNode <- graphNodes){
      val twoUnitAdjacentBits = Hamming.twoUnitDistBits(graphNode.bits)
      for(adjBits <- twoUnitAdjacentBits){
        val adjVertex = bitsToVertexMap.get(adjBits)
        if (adjVertex.isDefined)
          clustersUF.union(graphNode.vertex, adjVertex.get)
      }
    }

    println(clustersUF.count())

  }
}


object Hamming {

  def compute(s1: String, s2: String): Int = {
    if (s1.length != s2.length)
      throw new IllegalArgumentException()
    s1.toList.zip(s2.toList).count(current => current._1 != current._2)
  }

  def oneUnitDistBits(bits: String): List[String] = {
    var newBitsList = List[String]()
    for (i <- 0 until bits.length)
      newBitsList = bitsWithInversedChar(bits, i) :: newBitsList
    newBitsList
  }

  def twoUnitDistBits(bits: String): List[String] = {
    var newBitsList = List[String]()
    for (i <- 0 until bits.length; j <- 1 until bits.length if i != j)
      newBitsList = bitsWithInversedChar(bits, i, j) :: newBitsList
    newBitsList.distinct
  }


  def inverseCharBit(c: Char): Char = if (c == '1') '0' else '1'

  def bitsWithInversedChar(bits: String, i: Int): String = {
    val bitsChars: Array[Char] = bits.toCharArray
    bitsChars(i) = inverseCharBit(bitsChars(i))
    String.valueOf(bitsChars)
  }

  def bitsWithInversedChar(bits: String, i: Int, j: Int): String = {
    val bitsChars: Array[Char] = bits.toCharArray
    bitsChars(i) = inverseCharBit(bitsChars(i))
    bitsChars(j) = inverseCharBit(bitsChars(j))
    String.valueOf(bitsChars)
  }

}

