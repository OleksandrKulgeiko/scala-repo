package com.kulgeiko.scala.akka.camel

import akka.camel.{ CamelMessage, Consumer }

class MyConsumer extends Consumer {
  def endpointUri = "file:data/input/actor"

  def receive = {
    case msg: CamelMessage => println("received %s" format msg.bodyAs[String])
  }
}
