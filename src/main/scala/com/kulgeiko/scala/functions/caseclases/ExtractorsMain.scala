package com.kulgeiko.scala.functions.caseclases


object EMail {
  def apply(user: String, domain: String): String = user +"@"+ domain
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}

object ExtractorsMain extends App {

  val myEmail: String = EMail("akulgeiko", "gmail.com")
  val email1: String = "bob@gmail.com"
  val fakeEmail: String = "Non an email"
  println(myEmail)

  email1 match {
    case EMail(user, domain) => println(user, domain)
    case _ => println("???") // output: (bob,gmail.com)
  }

  fakeEmail match {
    case EMail(user, domain) => println(user, domain)
    case _ => println("???") // output: ???
  }




}
