package com.kulgeiko.scala.algorithms.datastructures

import scala.collection.mutable.ArrayBuffer


trait Heap {

  type Index = Int

  val arr: ArrayBuffer[Int] = new ArrayBuffer
  arr += 0


  def size: Int = arr.length - 1
  def root: Int = arr(1)
  def lastIndex: Index = arr.length - 1
  def lastLeaf: Int = arr(lastIndex)
  def nonEmpty: Boolean = size > 0

  def hasParent(c: Index): Boolean = c >= 2
  def hasLeftChild(p: Index): Boolean = size >= 2 * p
  def hasTwoChilds(p: Index): Boolean = size >= 2 * p + 1


  def parentIndex(c: Index): Index = if (hasParent(c)) (c / 2).floor.toInt else -1
  def lChildIndex(p: Index): Index = if (hasLeftChild(p)) 2 * p else -1
  def rChildIndex(p: Index): Index = if (hasTwoChilds(p)) 2 * p + 1 else -1

  //def parent(c: Index) = arr(parentIndex(c))
  def lChild(p: Index) = arr(lChildIndex(p))
  def rChild(p: Index) = arr(rChildIndex(p))


  private def swap(pIndex: Int, cIndex: Int): Unit = {
    val parent: Int = arr(pIndex)
    arr(pIndex) = arr(cIndex)
    arr(cIndex) = parent
  }
  private def swapWithParent(cIndex: Int): Unit = swap(parentIndex(cIndex), cIndex)
  private def swapWithLChild(pIndex: Int): Unit = swap(pIndex, lChildIndex(pIndex))
  private def swapWithRChild(pIndex: Int): Unit = swap(pIndex, rChildIndex(pIndex))


  /**
  Insert operation (log(n))
   */
  def insert(element: Int): Unit = {
    arr += element
    insertSubRoutine(lastIndex)
  }

  def insertSubRoutine(c: Index): Unit =
    if (hasParent(c) && needToSwapWithParent(c)){
      swapWithParent(c)
      insertSubRoutine(parentIndex(c))
    }


  /**
  Extract root operation (log(n))
    */
  def extractRoot: Int = {
    val rootValue = root
    arr(1) = lastLeaf
    arr.remove(lastIndex)
    extractRootSubRoutine(1)
    rootValue
  }

  def extractRootSubRoutine(p: Index): Unit = {
    if (hasTwoChilds(p)) {
      if (needToSwapParentChild(p, minOrMaxChilIndex(lChildIndex(p), rChildIndex(p)))) {
        val childIndex = minOrMaxChilIndex(lChildIndex(p), rChildIndex(p))
        swapWithParent(childIndex)
        extractRootSubRoutine(childIndex)
      }
    }
    else if (hasLeftChild(p)) {
      if (needToSwapParentChild(p, lChildIndex(p))){
        val childIndex = lChildIndex(p)
        swapWithParent(childIndex)
        extractRootSubRoutine(childIndex)
      }
    }
  }
  /*
    if (needToSwapWithChilds(p)) {
      val childIndex = minOrMaxChilIndex(lChildIndex(p), rChildIndex(p))
      swapWithParent(childIndex)
      extractRootSubRoutine(childIndex)
    }
    */




  def needToSwapWithParent(c: Index): Boolean = needToSwapParentChild(parentIndex(c), c)

  /*
  def needToSwapWithChilds(p: Index): Boolean =
    if (hasTwoChilds(p)) {
      if (needToSwapParentChild(p, minOrMaxChilIndex(lChildIndex(p), rChildIndex(p)))) true
      else false
    }
    else if (hasLeftChild(p)) {
      if (needToSwapParentChild(p, lChildIndex(p))) true
      else false
    }
    else
      false
*/

  /**
  To be implemented in child classes
    */
  def needToSwapParentChild(parent: Int, child: Int): Boolean
  def minOrMaxChilIndex(l: Index, r: Index): Index


}

class MinHeap extends Heap {

  def findMin: Int = root
  def extractMin: Int = extractRoot
  //def delete(e: Int): Unit = ???
  override def needToSwapParentChild(p: Index, c: Index): Boolean = arr(p) > arr(c)
  override def minOrMaxChilIndex(l: Index, r: Index): Index = if (arr(l) < arr(r)) l else r

}

class MaxHeap extends Heap {

  def findMax: Int = root
  def extractMax: Int = extractRoot
  //def delete(e: Int): Unit = ???
  override def needToSwapParentChild(p: Int, c: Int): Boolean = arr(p) < arr(c)
  override def minOrMaxChilIndex(l: Index, r: Index): Index = if (arr(l) > arr(r)) l else r
}

/*
def switchWithChild(parentInx: Int): Int = {

  // if both childs exist

  val parent = parent(childIndex)
  arr(parentIndex(childIndex)) = arr(childIndex)
  arr(childIndex) = parent
  parentIndex(childIndex)
}
*/

/*
def switchWithParent(childIndex: Int): Int = {
  val parent = parent(childIndex)
  arr(parentIndex(childIndex)) = arr(childIndex)
  arr(childIndex) = parent
  parentIndex(childIndex)
}
*/