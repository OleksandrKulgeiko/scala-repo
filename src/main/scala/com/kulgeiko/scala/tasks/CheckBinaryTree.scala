package com.kulgeiko.scala.tasks

sealed trait MyOption[+A]
case class MySome[A](value: A) extends MyOption[A]
case class MyNone() extends MyOption[Nothing]


trait TreeNode {
  def value: Int
}
case class NodeT(value: Int, left: TreeNode, right: TreeNode) extends TreeNode
case class Leaf(value: Int) extends TreeNode
abstract case class Empty() extends TreeNode

/*
     3
    / \
   2   4
  / \
 1   5

*/

object CheckBinaryTree {

  def isOrdered(tree: TreeNode): Boolean = tree match {
    case Leaf(_)                             => true
    case NodeT(root, Leaf(left), Empty())     => if (root > left) true else false
    case NodeT(root, Empty(), Leaf(right))    => if (root <= right) true else false
    case NodeT(root, Leaf(left), Leaf(right)) => if (root > left && root <= right) true else false
    case NodeT(root, leftNode, rightNode)     =>
      if (!(root > leftNode.value && root <= rightNode.value))
        false
      else
        isOrdered(leftNode) && isOrdered(rightNode)
  }

  def main(args: Array[String]): Unit = {

    println(1)

  }
}


