package com.kulgeiko.scala.collections

import scala.collection.JavaConversions.asScalaBuffer

case class Chair(){
  var colour: String = _
}

case class Table(colour: String)


class Fruit(name: String)
class Vegetable(name: String)

object CollectionsMain extends App {


  println("---------------------------------- Buffer ----------------------------------")

  //var fruits = new ListBuffer[String]()



  // ---------------------------------- Tuples ----------------------------------

  val pair = (99, "Home", new Fruit("apple"), new Vegetable("cucumber"))
  println(pair._1)
  println(pair._2)
  println(pair._3)
  println(pair._4)

  println("---------------------------------- List ----------------------------------")

  var myList: Seq[String] = Nil
  myList + "Audi"
  myList + "Mitsubishi"
  println(myList)

  val oneTwoThree = 1 :: 2 :: 3 :: Nil
  println(oneTwoThree)
  println(oneTwoThree.size)
  println(oneTwoThree.length)


  println("---------------------------------- Set ----------------------------------")

  var mySet = Set("apple", "pear", "", null, "plum")
  var mySet2 = Set("apple", "pear", "", null, "plum") - (null, "")
  var mySetClean = mySet - (null, "")
  println(mySet)
  println(mySetClean)
  println(mySet2)
  println(mySetClean.mkString("; "))
  println(mySetClean.map(f => "Some: " + f).mkString("; "))

  var nilSet = Nil
  println(nilSet.size)
  println(nilSet.isEmpty)

  var mySet3 = Set(1, 2)
  val mySet4 = Set(3, 4, 5, 1)
  var mySet5 = Set.empty
  var javaList = new java.util.ArrayList[Int]
  javaList.add(8)
  javaList.add(9)
   mySet3 = mySet3 ++ javaList
  println(mySet3)

  val chair1: Chair = Chair()
  val chair2: Chair = Chair()
  chair1.colour = "Black"
  chair2.colour = "Grey"

  val table1: Table = Table("Black")
  val table2: Table = Table("Grey")
0
  val a = chair1 == chair2
  val b = table1 == table2
  val a1 = chair1.equals(chair2)



}
