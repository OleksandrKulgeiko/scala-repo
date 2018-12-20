package com.kulgeiko.scala.akka.actor.basic

import akka.actor.Actor


case class Name(name: String)

class GreetingsActor extends Actor {
  def receive = {
    case Name(n) => println("Hello " + n)
    case _       => println("Unknown stuff received")
  }
}

