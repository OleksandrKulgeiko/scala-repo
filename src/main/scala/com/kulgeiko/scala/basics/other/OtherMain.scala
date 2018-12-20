package com.kulgeiko.scala.basics.other

import java.io.File
import java.nio.file.{Files, Paths}


object OtherMain extends App {


  val b1: Boolean = true
  val b2: Boolean = true
  val b3: Boolean = true

  //val result1 = !(b1 && b2 && b3)
  val result2 = b1 & b2 & b3

  println(result2)

  //var b4: Boolean = _
  //println(b4)
  val s1: String = "Apple"
  val s2: String = s1 + (if(1>1) " from California" else " from Ukraine")

  println(s2)
  if (1==1) println("1==1"); println("1==1")

  println(System.currentTimeMillis())
  println(System.currentTimeMillis())
  println(System.currentTimeMillis())

  //Files.createDirectory(Paths.get("/test/111111"))

  new File("/test1/directory").mkdir()

  val ss = "MyString.csv"

  //val (first, second) = ss.splitAt(3,-1)split(".csv")
  //println(first + "_0000" + second)

}