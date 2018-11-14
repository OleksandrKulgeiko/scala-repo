package com.kulgeiko.scala.collections




object CollectionsMain extends App {




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
