package com.kulgeiko.scala.tasks

import com.kulgeiko.scala.Node


object ReverseLinkedList {


  def main(args: Array[String]): Unit = {

    val node4 = new Node(4, null)
    val node3 = new Node(3, node4)
    val node2 = new Node(2, node3)
    val node1 = new Node(1, node2)

    printLinkedList(node1)
    println()
    reverseLinkedList(node1)
    printLinkedList(node4)
  }

  def printLinkedList(node: Node) = {
    var currentNode = node
    while (currentNode.next != null) {
      print(currentNode.value + " -> ")
      currentNode = currentNode.next
    }
    print(currentNode.value + " -> null")
  }

  def reverseLinkedList(head: Node): Unit = {

    reverse(null, head)

    def reverse(node1: Node, node2: Node): Unit = {
      val node3 = node2.next
      swap(node1, node2)
      if (node3 != null)
        reverse(node2, node3)
      else
        println("Finished reversal")
    }

    def swap(node: Node, next: Node): Unit = next.next = node
  }
}


