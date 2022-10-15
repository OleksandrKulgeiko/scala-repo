package com.kulgeiko.scala.basics.variance

abstract class Printer[-A] {
  def print(value: A): Unit
}

// Printers
class AnimalPrinter extends Printer[Animal] {
  def print(animal: Animal): Unit = println("The animal's name is: " + animal.name)
}

class CatPrinter extends Printer[Cat] {
  def print(cat: Cat): Unit = println("The cat's name is: " + cat.name)
}

object ContravarianceTest extends App {
  val myCat: Cat = Cat("Tom")

  val catPrinter: Printer[Cat] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter


  def printMyCat(printer: Printer[Cat]): Unit = {
    printer.print(myCat)
  }

  printMyCat(catPrinter)
  printMyCat(animalPrinter)
}
