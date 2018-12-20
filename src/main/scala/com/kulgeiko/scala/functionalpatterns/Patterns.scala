package com.kulgeiko.scala.functionalpatterns

object Patterns extends App {







  def lift3[A,B,C,D](f: Function3[A,B,C,D]) = {
    (oa: Option[A], ob: Option[B], oc: Option[C]) =>
      for(a <- oa; b <- ob; c <- oc) yield f(a,b,c)
  }


}
