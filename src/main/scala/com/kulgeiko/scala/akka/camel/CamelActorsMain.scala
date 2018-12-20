package com.kulgeiko.scala.akka.camel

// start and expose actor via tcp
import akka.actor.{ ActorSystem, Props }

object CamelActorsMain extends App {

  val system = ActorSystem("some-system")
  val mina = system.actorOf(Props[MyConsumer])

}
