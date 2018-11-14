package com.kulgeiko.scala.basics.constants


import com.kulgeiko.scala.basics.constants.Const2.CountryName1


class Apple {

  val size: Int = 1
  val colour: String = "red"


  def printInfo(): Unit = {
    if (CountryName1 == "Ukraine") {
      print("This is my favourite country")
    }
  }

}
