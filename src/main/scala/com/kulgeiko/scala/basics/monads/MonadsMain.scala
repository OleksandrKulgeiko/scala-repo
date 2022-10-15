package com.kulgeiko.scala.basics.monads

import scala.util.Try


object MonadsMain extends App {

  val s0: Option[String] = Option("Hi")
  val s1: Option[String] = Some("Hi")
  val s2: Option[String] = None

  val r = s1.flatMap(i => None)

  println(s0)


  val t0 = Try(0/0)
  println(t0)

  val ss = Stream(1, 2, 3)
  println(ss)
}
