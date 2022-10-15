package com.kulgeiko.scala.oop

class Employee{
  var salary: Float = 10000
}

class Programmer extends Employee{
  var bonus: Int = 5000
  println("Salary = " + salary + "; " + "Bonus = " + bonus)
}

class SeniorProgrammer extends Programmer{
  var seniority: Int = 12
  println("Salary = " + salary + "; " + "Bonus = " + bonus + "; " + "Seniority = " + seniority)
}



object InheritanceMain {
  def main(args:Array[String]){


    new Programmer()
    new SeniorProgrammer()

    println("-------------------------------------------------------- Hybrid inheritance")

    trait Base {def op: String}

    trait First extends Base {override def op = "First"}
    trait Second extends Base {override def op = "Second"}

    class A extends First with Second
    class B extends Second with First

    println((new A).op) // Second
    println((new B).op) // First

    println("-------------------------------------------------------- With usage")
    trait T1
    trait T2

    class C1
    class C2

    class O1 extends T1
    class O2 extends T1 with T2
    class O3 extends T2 with T1
    class O4 extends C1 with T1
    //class O5 extends T1 with C1 // ERROR: Class C1 needs to be trait to be mixed in
    //class O6 extends C1 with C2 // ERROR: Class C2 needs to be trait to be mixed in

  }
}