package com.kulgeiko.scala.akka.actor

import akka.actor.Props
import akka.actor.ActorSystem

object ActorsMain extends App {

  val system = ActorSystem("greetings")
  val a = system.actorOf(Props[GreetingsActor], name = "greetings-actor")
  a ! Name("Oleksandr")


}
