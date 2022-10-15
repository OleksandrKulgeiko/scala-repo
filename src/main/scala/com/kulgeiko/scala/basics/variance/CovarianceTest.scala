package com.kulgeiko.scala.basics.variance

abstract class Animal {
  def name: String
}
case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal



object CovarianceTest extends App {
  // List - has this signature List[+A]
  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  val cats: List[Cat] = List(Cat("Tom"), Cat("Mash"))
  val dogs: List[Dog] = List(Dog("Rex"), Dog("Beth"))

  printAnimalNames(cats) // Tom, Mash
  printAnimalNames(dogs) // Rex, Beth

  /*
  It does mean that List[Cat]/List[Dog] ia List[Animal]
   */


}