package com.kulgeiko.scala.testing.tdd

import org.scalatest.{BeforeAndAfter, FunSuite}

class MyFirstSuite extends FunSuite with BeforeAndAfter {

  var a = 1
  before {
    a = 2
  }

  test("should be 2") {
    assert(a == 2)
  }

  // mark that you want a test here in the future
  test ("a type") (pending)
}