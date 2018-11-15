package com.kulgeiko.scala.akka.actor

import akka.actor.Actor


case class Name(name: String)

class GreetingsActor extends Actor {
  def receive = {
    case Name(n) => println("Hello " + n)
  }
}

