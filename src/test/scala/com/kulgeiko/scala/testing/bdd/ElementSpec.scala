package com.kulgeiko.scala.testing.bdd

import org.scalatest.{FlatSpec, MustMatchers}

class ElementSpec extends FlatSpec with MustMatchers {
  "a object" should "be equal to 5" in {
    val a = 5
    a mustBe 5
  }

  it should "be 6 now" in {
    val a = 6
    a mustBe 6
  }
  /*
  it should "throw an IAE" in {
    evaluating {
      elem('x', 2, 3)
    } should produce [IllegalArgumentException]
  }*/
}
