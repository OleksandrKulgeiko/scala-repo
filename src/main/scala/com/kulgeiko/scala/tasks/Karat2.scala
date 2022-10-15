package com.kulgeiko.scala.tasks

object Karat2 {


  def schIntersect(schedule1: List[(Int,Int)], schedule2: List[(Int,Int)]): Boolean = {
    for(slot1 <- schedule1){
      for(slot2 <- schedule2){
        if(intersect(slot1,slot2))
          return true
      }
    }
    false
  }


  def intersect(p1: (Int,Int), p2: (Int,Int)): Boolean = {
    if ((p2._1 > p1._1 && p2._1 < p1._2 || p2._2 > p1._1 && p2._2 < p1._2)
        || (p1._1 > p2._1 && p1._1 < p2._2 || p1._2 > p2._1 && p1._2 < p2._2))
      true
    else
      false
  }



  def main(args: Array[String]): Unit = {

    val schedule1 = List((1,2), (3,5), (7,8))
    val schedule2 = List((2,3), (4,5), (10,11))

    println(intersect((1,2),(2,3)))
    println(intersect((1,4),(2,3)))
    println(intersect((2,3),(1,4)))
    println(intersect((3,5),(4,5)))

    println(schIntersect(schedule1,schedule2))




  }
}


