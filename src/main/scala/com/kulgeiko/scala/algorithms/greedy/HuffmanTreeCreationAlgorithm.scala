package com.kulgeiko.scala.algorithms.greedy

import com.kulgeiko.scala.algorithms.Utils.readList


/**
  * Assignment 4: Huffman coding
  *
  */
object Huffman {

  /**
    * A huffman code is represented by a binary tree.
    *
    * Every `Leaf` node of the tree represents one character of the alphabet that the tree can encode.
    * The weight of a `Leaf` is the frequency of appearance of the character.
    *
    * The branches of the huffman tree, the `Fork` nodes, represent a set containing all the characters
    * present in the leaves below it. The weight of a `Fork` node is the sum of the weights of these
    * leaves.
    */
  abstract class CodeTree
  case class Fork(left: CodeTree, right: CodeTree, chars: List[Short], weight: Long) extends CodeTree
  case class Leaf(char: Short, weight: Long) extends CodeTree


  // Part 1: Basics
  def weight(tree: CodeTree): Long = tree match {
    case Fork(_, _, _, weight) => weight
    case Leaf(_, weight)       => weight
  }

  def chars(tree: CodeTree): List[Short] = tree match {
    case Fork(_, _, chars, _) => chars
    case Leaf(char, _)        => List(char)
  }

  def makeCodeTree(left: CodeTree, right: CodeTree): CodeTree = Fork(left, right, chars(left) ::: chars(right), weight(left) + weight(right))



  // Part 2: Generating Huffman trees

  /**
    * Returns a list of `Leaf` nodes for a given frequency table `freqs`.
    *
    * The returned list should be ordered by ascending weights (i.e. the
    * head of the list should have the smallest weight), where the weight
    * of a leaf is the frequency of the character.
    */
  def makeOrderedLeafList(freqs: List[(Short, Long)]): List[Leaf] = {


    def sortList(list: List[(Short, Long)]): List[(Short, Long)] = list match {
      case List() => List()
      case h :: tail => insert(h, sortList(tail))
    }

    def insert(x: (Short, Long), xs: List[(Short, Long)]): List[(Short, Long)] = xs match {
      case List()    => List(x)
      case h :: tail => if (x._2 >= h._2) x :: xs else h :: insert(x, tail)
    }

    def loop(freqs: List[(Short, Long)], leafs: List[Leaf]): List[Leaf] = freqs match {
      case List()    => leafs
      case h :: tail => loop(tail, Leaf(h._1, h._2) :: leafs)
    }
    loop(sortList(freqs), List())
  }

  /**
    * Checks whether the list `trees` contains only one single code tree.
    */
  /*
  def singleton(trees: List[CodeTree]): Boolean = trees match {
    case List()    => false
    case _ :: tail => !singleton(tail)
  }
*/
  /**
    * The parameter `trees` of this function is a list of code trees ordered
    * by ascending weights.
    *
    * This function takes the first two elements of the list `trees` and combines
    * them into a single `Fork` node. This node is then added back into the
    * remaining elements of `trees` at a position such that the ordering by weights
    * is preserved.
    *
    * If `trees` is a list of less than two elements, that list should be returned
    * unchanged.
    */
  /*
  def combine(trees: List[CodeTree]): List[CodeTree] = trees match {
    case List()           => trees
    case List(x)          => trees
    case x1 :: x2 :: tail => makeCodeTree(x1, x2) :: combine(tail)
  }
*/
  /**
    * This function will be called in the following way:
    *
    *   until(singleton, combine)(trees)
    *
    * where `trees` is of type `List[CodeTree]`, `singleton` and `combine` refer to
    * the two functions defined above.
    *
    * In such an invocation, `until` should call the two functions until the list of
    * code trees contains only one single tree, and then return that singleton list.
    *
    * Hint: before writing the implementation,
    *  - start by defining the parameter types such that the above example invocation
    *    is valid. The parameter types of `until` should match the argument types of
    *    the example invocation. Also define the return type of the `until` function.
    *  - try to find sensible parameter names for `xxx`, `yyy` and `zzz`.
    */
  // def until(xxx: ???, yyy: ???)(zzz: ???): ??? = ???
  /*
  def until(isSing: List[CodeTree] => Boolean,
            combine: List[CodeTree] => List[CodeTree])(nodes: List[CodeTree]): CodeTree =
    if (isSing(nodes)) nodes.head
    else until(isSing, combine)(combine(nodes))
*/

  /**
    * This function creates a code tree which is optimal to encode the text `chars`.
    *
    * The parameter `chars` is an arbitrary text. This function extracts the character
    * frequencies from that text and creates a code tree based on them.
    */
/*
  def createCodeTree(count: List[(Short, Long)]): CodeTree = {
    val leafs: List[CodeTree] =  makeOrderedLeafList(count)
    val leafNodes: List[CodeTree] = combine(leafs)
    val tree: CodeTree = until(singleton, combine)(leafNodes)
    tree
  }
*/

  def createCodeTree2(count: List[(Short, Long)]): CodeTree = {
    // all leafs
    var trees: List[CodeTree] =  makeOrderedLeafList(count)

    while(trees.size > 1){
      val treesSorted = trees.sortBy(f => weight(f))
      trees = treesSorted match {
        case n1 :: n2 :: tail => makeCodeTree(n1, n2) :: tail
      }
    }
    trees.head
  }


  def maxDepth(tree: CodeTree, count: Int): Int = tree match {
    case Fork(left, right, chars, _) => {
      val lNum = left match {
        case Fork(_, _, chars, _) => chars.size
        case Leaf(_, _)           => 1
      }
      val rNum = right match {
        case Fork(_, _, chars, _) => chars.size
        case Leaf(_, _)           => 1
      }
      if (lNum >= rNum) maxDepth(left, count + 1) else maxDepth(right, count + 1)
    }
    case Leaf(_, _)                  => count
  }

  def minDepth(tree: CodeTree, count: Int): Int = tree match {
    case Fork(left, right, chars, _) => {
      val lNum = left match {
        case Fork(_, _, chars, _) => chars.size
        case Leaf(_, _)           => 1
      }
      val rNum = right match {
        case Fork(_, _, chars, _) => chars.size
        case Leaf(_, _)           => 1
      }
      if (lNum <= rNum) minDepth(left, count + 1) else minDepth(right, count + 1)
    }
    case Leaf(_, _)                  => count
  }

}

object HuffmanTreeCreationAlgorithm {

  def main(args: Array[String]): Unit = {

    val fileData = readList("/stanford/course3/week3_huffman.txt")
    val fileDataIndexed = fileData.zipWithIndex.map(s => (s._2.toShort, s._1.toLong))


    //val tree = Huffman.createCodeTree(List((1,10),(2,8),(3,3),(4,2)))
    val tree2 = Huffman.createCodeTree2(fileDataIndexed)
    //val tree3 = Huffman.createCodeTree(List((1,10),(2,8),(3,3),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2)))


    println(Huffman.maxDepth(tree2, 0))
    println(Huffman.minDepth(tree2, 0))
  }
}


