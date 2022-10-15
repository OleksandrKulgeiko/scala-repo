package com.kulgeiko.scala.algorithms.greedy

import com.kulgeiko.scala.algorithms.{Cluster, GraphEdgeWeighted}
import com.kulgeiko.scala.algorithms.Utils._
object ClusteringAlgorithm1 {

  def main(args: Array[String]): Unit = {


    // input parameters and data
    val clustersExpected = 4
    val fileData = readAdjacencyListWeighted("/stanford/course3/week2_clustering1.txt")
    /*
    val fileData = List(
      ((1, 2), 1),
      ((1, 3), 44),
      ((1, 4), 77),
      ((1, 5), 35),
      ((2, 3), 100),
      ((2, 4), 99),
      ((2, 5), 86),
      ((3, 4), 10),
      ((3, 5), 10),
      ((4,5), 10)
    )*/

    // graph
    val edges = fileData.map(r => GraphEdgeWeighted(r._1._1, r._1._2, r._2))
    val vertices = edges.flatMap(e => List(e.v1, e.v2)).distinct

    // clusters
    var clusters = vertices.map(v => Cluster("c" + v, List(v)))
    var clustersDistance: List[((String,String), Int)] = edges.map(e => (("c" + e.v1, "c" + e.v2),e.weight))

    while(clusters.size != clustersExpected) {

      println(clusters.size)
      
      // min distance between clusters
      val clustersToMerge = clustersDistance.minBy(_._2)

      // to be clashed
      val clusterId1 = clustersToMerge._1._1
      val clusterId2 = clustersToMerge._1._2

      // Merging clusters
      val cluster1 = clusters.filter(c => c.id == clusterId1).head
      val cluster2 = clusters.filter(c => c.id == clusterId2).head
      val newCluster = mergeClusters(cluster1, cluster2)

      // updating clusters list
      clusters = clusters.filterNot(c => c.id == clusterId1 || c.id == clusterId2)
      clusters = newCluster :: clusters

      // Updating clusters distances
      clustersDistance = clustersDistance.filterNot(d => d._1 == (clusterId1, clusterId2))
      clustersDistance = updateReferencesToNewCluster(clusterId1, clusterId2, clustersDistance)

      var dupsDist = clustersDistance.filter(d => d._1._1 == clusterId1 || d._1._2 == clusterId1)
      dupsDist = dupsDist.map(d => if (d._1._2 == clusterId1) ((d._1._2, d._1._1),d._2) else d)
      val newToAdd = uniqueMinDist(dupsDist)

      clustersDistance = clustersDistance.filterNot(d => d._1._1 == clusterId1 || d._1._2 == clusterId1)
      clustersDistance = newToAdd ::: clustersDistance
      //println("sdf")
    }

    println("sdf")


    def mergeClusters(c1: Cluster, c2: Cluster): Cluster = Cluster(c1.id, c1.vertices ::: c2.vertices)

    def updateReferencesToNewCluster(cId1: String, cId2: String, dist: List[((String,String), Int)]): List[((String,String), Int)] ={
      dist.map(d =>
        if (d._1._1 == cId2)
          ((cId1,d._1._2), d._2)
        else if (d._1._2 == cId2)
          ((d._1._1,cId1), d._2)
        else
          d
      )
    }

    def uniqueMinDist(dist: List[((String,String), Int)]): List[((String,String), Int)] = {

      var outList: List[((String,String), Int)] = Nil
      val distGroups = dist.map(_._1).distinct

      for(group <- distGroups){
        val groupMembers = dist.filter(d => d._1 == group)
        val toAdd = groupMembers.minBy(_._2)
        outList = toAdd :: outList
      }
      outList

    }

  }
}

