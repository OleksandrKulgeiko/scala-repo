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




  // ---------------------------------- Set ----------------------------------

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



}
