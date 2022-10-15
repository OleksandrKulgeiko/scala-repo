package com.kulgeiko.scala.basics.traits

import scala.collection.mutable.ArrayBuffer

trait Pet {
  val name: String
}

class Cat(val name: String) extends Pet
class Dog(val name: String) extends Pet


object TraitMain extends App {

  val dog = new Dog("Harry")
  val cat = new Cat("Sally")



  val animals = ArrayBuffer.empty[Pet]
  animals.append(dog)
  animals.append(cat)
  animals.foreach(pet => println(pet.name))
}