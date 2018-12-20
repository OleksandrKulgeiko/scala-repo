package com.kulgeiko.scala.akka.actor.basic

import akka.actor.{ActorSystem, Props}

object ActorsMain extends App {

  val system = ActorSystem("greetings")
  val a = system.actorOf(Props[GreetingsActor], name = "greetings-actor")
  a ! Name("Oleksandr")
  a ! "Dzylbars"
  a ! Name("Petro")

}
