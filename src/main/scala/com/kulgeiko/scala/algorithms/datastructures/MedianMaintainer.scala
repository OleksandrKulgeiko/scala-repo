package com.kulgeiko.scala.algorithms.datastructures


class MedianMaintainer {

  private val maxHeap: MaxHeap = new MaxHeap    // contains left hand numbers
  private val minHeap: MinHeap = new MinHeap     // contains right hand numbers


  def median(): Int = {
    if (maxHeap.size == minHeap.size)
      maxHeap.findMax
    else if (maxHeap.size > minHeap.size)
      maxHeap.findMax
    else
      minHeap.findMin
  }

  def add(n: Int): Unit = {
    if (maxHeap.nonEmpty && n < maxHeap.findMax) {
      println(s"$n to maxHeap")
      maxHeap.insert(n)
    }
    else {
      println(s"$n to minHeap")
      minHeap.insert(n)
    }
    balanceHeaps()
  }

  private def balanceHeaps(): Unit = {
    val diff = maxHeap.size - minHeap.size
    if (diff > 1) {
      println(s"Rebalancing from MAX to MIN")
      minHeap.insert(maxHeap.extractMax)
    }
    else if (diff < -1) {
      println(s"Rebalancing from MIN to MAX")
      maxHeap.insert(minHeap.extractMin)
    }

  }

}
