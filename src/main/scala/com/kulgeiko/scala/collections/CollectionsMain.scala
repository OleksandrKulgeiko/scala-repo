package com.kulgeiko.scala.collections


class Fruit(name: String)
class Vegetable(name: String)

object CollectionsMain extends App {


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

  val mySet3 = Set(1, 2)
  val mySet4 = Set(3, 4, 5, 1)
  var mySet5 = Set.empty

  val mySet6 = mySet3 ++ mySet4 ++ mySet5
  println(mySet6)


}
