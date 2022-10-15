package com.kulgeiko.scala.coursera.fp


object Week6Main extends App {

  type Occurrences = List[(Char, Int)]
  val c = List(('a', 2), ('b', 2), ('c', 2) /*, ('d', 2)*/)


  def descOccs(occs: Occurrences): List[List[Occurrences]] = {
    def descOcc(occ: (Char, Int)): List[Occurrences] = {
      val c = for {
        n <- 1 to occ._2
      } yield List((occ._1, n))
      c.toList
    }
    occs map descOcc
  }

  val descOccurances = descOccs(c)
  println(descOccurances)

  def doesNotHave(x: Occurrences, y: Occurrences) = x.toMap.get(y.head._1) match {
    case None => true
    case _ => false
  }

  def initialCombine(roll: List[List[Occurrences]], acc: List[Occurrences]): List[Occurrences] = roll match {
    case Nil => Nil :: acc
    case rollHead :: rollTail =>
      val portion: List[Occurrences] =
        for {
          head <- rollHead
          subList <- descOccurances
          es <- subList
          if doesNotHave(head, es)
        } yield (head ::: es).sortBy(_._1)
      initialCombine(rollTail, (acc ::: portion).distinct)
  }

  val initialCombination = initialCombine(descOccurances, Nil)

  def secondCombine(roll: List[List[Occurrences]], acc: List[Occurrences]): List[Occurrences] = roll match {
    case Nil => acc
    case rollHead :: rollTail =>
      val portion: List[Occurrences] =
        for {
          a <- acc
          subList <- descOccurances
          es <- subList
          if doesNotHave(a, es)
        } yield (a ::: es).sortBy(_._1)
      secondCombine(rollTail, (acc ::: portion).distinct)
  }

  val rrr = secondCombine(descOccurances, initialCombination)
  println(rrr)



}
