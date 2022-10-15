package com.kulgeiko.scala.algorithms.graphs

import scala.collection.mutable.{MutableList => MList, Queue => MQueue, Set => MSet, Stack => MStack}
import com.kulgeiko.scala.algorithms.Utils._

/**
 Graph search problem - is to identify all vertices V reachable from start vertex s in graph G
 */
object Graphs {


  def main(args: Array[String]): Unit = {


    val arrr = Array(1,1,1,2,2,2,3)

    val rrtt = arrr.groupBy(identity).mapValues(_.size).values

    val rrtt2 = rrtt.toList.sortWith(_ > _)
    // Arbitrary graph
    val graph1: Graph = List((1,2),(1,9),(1,3),(2,4),(3,4),(4,5),(5,6),(6,7))

    // Graph with three Connected Components
    val graph2: Graph = List((1,3),(1,5),(3,5),(5,7),(5,9),(2,4),(8,6),(6,10))
    val graph3: Graph = List((1,3),(1,5),(3,5),(5,7),(5,9),(2,4),(8,6),(6,10),(9,11))

    // Graph for topological sort
    val graph4: Graph = List((1,2),(1,3),(2,4),(3,4),(4,6),(4,5),(6,7),(5,7))

    // Graph for Strongly Connected Components (SCC)
    val graph5: Graph = List((1,3),(3,5),(5,1),(3,11),(5,9),(5,7),(11,6),(11,8),(6,10),(10,8),(8,6),
      (9,8),(2,10),(9,2),(9,4),(2,4),(4,7),(7,9),(6,12),(10,12))
    val graph6: Graph = readAdjacencyList("/stanford/course2/StronglyConnectedComponents.txt")

    // Graph for Single Source Shortest Path
    val graph7: AdjacencyArrayWithLen = readAdjacencyArrayWithLen("/stanford/course2/DijkstraData.txt")


    println("\n----- BFS algorithm and Shortest Path")
    breathFirstSearch(graph2, 2)

    println("\n----- Undirected Connected Components")
    undirectedConnectedComponentsBfs(graph2)

    println("\n----- DFS recursive")
    depthFirstSearchRecursive(graph3, 1)

    println("\n----- DFS iterative")
    println(depthFirstSearchIterative(graph3, 1))

    println("\n----- Topological Ordering Recursive")
    val topoSortRec = topologicalSortRecursive(graph4)
    for(i <- topoSortRec.indices) println(s"$i -> " + topoSortRec(i))

    println("\n----- Topological Ordering Iterative")
    val topoSortIter = topologicalSortIterative(graph4)
    for(i <- topoSortIter.indices) println(s"$i -> " + topoSortIter(i))

    println("\n----- Strongly Connected Components")
    //stronglyConnectedComponents(graph5)

    println("\n----- Single Source Shortest Path, Dijkstra Algorithm")
    singleSourceShortestPath(1, graph7)

  }






  // Generic Search algorithm
  def genericGraphSearch(graph: List[(Int, Int)], start: Int): Set[Int] = {

    var explored = Set(start)
    def isExplored(v: Int) = explored.contains(v)

    def getUnexplored(graph: List[(Int, Int)]): Option[(Int, Int)] = graph match {
      case Nil       => None
      case h :: tail =>
        if ((isExplored(h._1) && !isExplored(h._2)) || (!isExplored(h._1) && isExplored(h._2))) Some(h)
        else getUnexplored(tail)
    }

    while(getUnexplored(graph).isDefined) {
      val (v, w) = getUnexplored(graph).get
      if (!isExplored(v)) explored += v
      else explored += w
    }
    explored
  }



  /**
  This method contains functionality for:
    - Breath First Search
    - Shortest Path calculation
   */
  def breathFirstSearch(graph: Graph, start: Vertex): Unit = {

    val queue = MQueue(start)
    val maxVertex = getMaxVertex(graph)

    // To maintain explored vertices
    val explored = new Array[Boolean](maxVertex + 1)
    explored(start) = true

    // To maintain shortest path values
    val shortestPath = new Array[Int](maxVertex + 1)
    for (i <- shortestPath.indices) shortestPath(i) = if (i == start) 0 else -9999

    while(queue.nonEmpty) {

      val vertex = queue.dequeue()
      val adjVertices = adjacentVertices(graph, vertex)

      for (v <- adjVertices if !explored(v)) {
        explored(v) = true
        shortestPath(v) = shortestPath(vertex) + 1 // related to shortest path calculation
        queue.enqueue(v)
      }
    }

    for (i <- shortestPath.indices) println(s"SP [$start -> $i]: " + shortestPath(i))
  }

  /**
  Calculation of Undirected Connected Components based on BFS algorithm
    */
  def undirectedConnectedComponentsBfs(graph: Graph): Unit = {

    val queue = MQueue[Vertex]()
    val maxVertex = getMaxVertex(graph)

    val explored = new Array[Boolean](maxVertex + 1)       // To maintain explored vertices
    val connectedComponent = new Array[Int](maxVertex + 1) // To maintain connected component identifier
    var ccId = 0

    for (v <- 1 to maxVertex if !explored(v)) {
      ccId = ccId + 1
      queue.enqueue(v)

      while(queue.nonEmpty) {

        val vertex = queue.dequeue()
        val adjVertices = adjacentVertices(graph, vertex)

        for (av <- adjVertices if !explored(av)) {
          explored(av) = true
          connectedComponent(av) = ccId // related to shortest path calculation
          queue.enqueue(av)
        }
      }

    }
    for (i <- 1 to maxVertex) println(s"$i -> " + connectedComponent(i) + " cc")
  }

  /**
  DFS algorithm, recursive algorithm
    */
  def depthFirstSearchRecursive(graph: Graph, start: Vertex): Unit = {

    val maxVertex = getMaxVertex(graph)
    val explored = new Array[Boolean](maxVertex + 1) // To maintain explored vertices

    dfsRecursive(graph, start)

    def dfsRecursive(graph: Graph, start: Vertex): Unit = {
      explored(start) = true
      val adjVertices = adjacentVertices(graph, start)
      for (v <- adjVertices if !explored(v)) {
        println(s"explored: $start to -> $v")
        dfsRecursive(graph, v)
      }
    }
  }

  /**
  DFS algorithm, iterative algorithm
    */
  def depthFirstSearchIterative(graph: Graph, start: Vertex): List[Vertex] = {

    val maxVertex = getMaxVertex(graph)
    val explored = new Array[Boolean](maxVertex + 1) // To maintain explored vertices
    val exploredList = MList[Int]()
    val stack = MStack(start)

    while (stack.nonEmpty) {
      val v = stack.pop()

      if (!explored(v)) {
        explored(v) = true
        exploredList += v
        val adjVertices = adjacentVertices(graph, v)
        adjVertices.foreach(av => stack.push(av))
      }
    }
    exploredList.toList
  }




  /**
  Topological Sort Recursive Algorithm
    */
  def topologicalSortRecursive(graph: Graph): Array[Int] = {

    val maxVertex = getMaxVertex(graph)
    var currLable = maxVertex
    val explored = new Array[Boolean](maxVertex + 1) // To maintain explored vertices
    val topoSort = new Array[Int](maxVertex + 1)     // To maintain Topological Ordering

    for(v <- 1 to maxVertex if !explored(v))
      dfsTopoRec(graph, v)

    def dfsTopoRec(graph: Graph, start: Vertex): Unit = {
      explored(start) = true
      val adjVertices = adjacentVerticesDirected(graph, start)
      for (av <- adjVertices if !explored(av))
        dfsTopoRec(graph, av)
      topoSort(start) = currLable
      currLable = currLable - 1
    }
    topoSort
  }

  /**
  Topological Sort Iterative Algorithm
    */
  def topologicalSortIterative(graph: Graph): Array[Int] = {

    val graphInAdjArray = adjacencyListToAdjacencyArray(graph)

    val maxVertex = getMaxVertex(graph)
    val explored = new Array[Boolean](maxVertex + 1) // To maintain explored vertices
    val topoSort = new Array[Int](maxVertex + 1)     // To maintain Topological Ordering
    var currLable = maxVertex

    for(v <- 1 to maxVertex if !explored(v))
      dfsTopoIter(graph, v)

    def dfsTopoIter(graph: Graph, start: Vertex): Unit = {

      val stack = MStack(start)

      while (stack.nonEmpty) {
        val v = stack.head
        if (!explored(v)) {
          explored(v) = true
          val adjVertices = graphInAdjArray(v)
          adjVertices.foreach(av => stack.push(av))
        } else {
          val w = stack.pop()
          if (topoSort(w) == 0) {
            topoSort(w) = currLable
            currLable = currLable - 1
          }
        }
      }
    }
    topoSort
  }


  /**
  Strongly Connected Components For Directed Graph
    */

  def stronglyConnectedComponents(graph: Graph): Unit = {

    // Holders for SCC, explored etc...
    val maxVertex = getMaxVertex(graph)
    val scc = new Array[Int](maxVertex + 1)
    val explored = new Array[Boolean](maxVertex + 1)
    var numScc = 0

    // Adjacent vertices
    val adjacent = adjacencyListToAdjacencyArray(graph)

    // Reversed graph and its topological ordering
    val graphRev = reversed(graph)
    val topoSort = topologicalSortIterative(graphRev)
    val topoSortInv = inverseIndexVsValue(topoSort)


    for (i <- 1 until topoSortInv.length if !explored(topoSortInv(i))) {
      val v = topoSortInv(i)
      numScc = numScc + 1
      dfsScc(graph, v)
    }

    def dfsScc(graph: Graph, start: Vertex): Unit = {

      val stack = MStack(start)

      while (stack.nonEmpty) {
        val v = stack.pop()

        if (!explored(v)) {
          explored(v) = true
          scc(v) = numScc
          adjacent(v).foreach(av => stack.push(av))
        }
      }
    }

    /*
    def dfsScc(graph: Graph, start: Vertex): Unit = {
      scc(start) = numScc
      explored(start) = true
      for (w <- adjacent(start) if !explored(w)) dfsScc(graph, w)
    }
    */

    /*
    def depthFirstSearchIterative(graph: Graph, start: Vertex): Vertices = {

      val maxVertex = getMaxVertex(graph)
      val explored = new Array[Boolean](maxVertex + 1) // To maintain explored vertices
      val exploredList = MList[Int]()
      val stack = MStack(start)

      while (stack.nonEmpty) {
        val v = stack.pop()

        if (!explored(v)) {
          explored(v) = true
          exploredList += v
          val adjVertices = adjacentVertices(graph, v)
          adjVertices.foreach(av => stack.push(av))
        }
      }
      exploredList.toList
    }
    */

    //val arrr = Array(1,1,1,2,2,2,3)

    //val rrtt = arrr.groupBy(identity).mapValues(_.size).values

    //val rrtt2 = rrtt.toList.sortWith(_ > _)



    val rr = scc.groupBy(identity).mapValues(_.size).values.toList.sortWith(_ > _)
    val e  = 3
  }


  /**
  Single Source Shortest Path problem (Dijkstra Algorithm)
    */
  def singleSourceShortestPath(start: Vertex, graph: GraphWithLen ): Unit = {

    val explored: MSet[Vertex] = MSet(start)
    var crossingEdges: List[Edge] = Nil
    val len: Array[Len] = new Array[Len](graph.length)
    len(start) = 0

    // Auxilary functions
    def edgeLen(e: Edge): Len = {
      println(s"Searching edge ${e._1}, ${e._2}")
      graph(e._1)(e._2)
    }
    def getOutgoingEdges(v: Vertex): List[Edge] = graph(v).toList.filter(e => !explored.contains(e._1)).map(e => (v, e._1))
    def getMinScoreEdge(edges: List[Edge]): Edge = {
      val edgesScores = edges.map(f => (f, len(f._1) + edgeLen(f)))
      val minScore = edgesScores.map(_._2).min
      edgesScores.filter(_._2 == minScore).head._1
    }

    // Initial initialization of edges which are crossing the frontier
    crossingEdges = getOutgoingEdges(start)

    while (crossingEdges.nonEmpty) {

      // Edge with minimum Dijkstra score
      val minScoreEdge = getMinScoreEdge(crossingEdges)
      val beg = minScoreEdge._1
      val end = minScoreEdge._2

      // Adding new vertex to explored, updating crossing edges and Len function
      explored.add(end)

      len(end) = len(beg) + edgeLen(minScoreEdge)

      val newEdges = getOutgoingEdges(end)
      val oldEdges = crossingEdges.filter(_._2 != end)
      crossingEdges = oldEdges ::: newEdges


      println(s"Explored $end, len to it ${len(end)}")
      println("Crossing edges size: " + crossingEdges.size)
      println(s"Crossing edges $crossingEdges")
    }


    val vert = List(7,37,59,82,99,115,133,165,188,197)

    vert.foreach(f => print(len(f) + ","))

    //1000000,1000000,1000000,1000000,1000000,1000000,1000000,1000000,4122,8164

    println("stophere")









  }



}
