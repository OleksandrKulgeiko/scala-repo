
val wordList = List("1my", "2tyt", "3rrr", "4ww")
val wordList2 = wordList.flatten.length



val initAcc: List[List[String]] = for {
  word1 <- wordList
  word2 <- wordList
} yield List(word1, word2)





List("1my", "2tyt", "3rrr", "4ww").combinations(2).toList


type Occurrences = List[(Char, Int)]

def wordOccurrences(w: String): Occurrences =
  w.toLowerCase.groupBy(identity).mapValues(_.size).toList.sortBy(_._1)

/** Converts a sentence into its character occurrence list. */
def sentenceOccurrences(s: List[String]): Occurrences = {
  val oneWord = s.reduce((x, y) => x + y)
  wordOccurrences(oneWord)
}

sentenceOccurrences(List("my", "Sean"))
sentenceOccurrences(List("say", "men"))
sentenceOccurrences(List("yes", "man"))


List("my", "Sean")
List("say", "men")


val ff = List(List("sdfsd", "sdf"), List("a", "akk"))

ff.map(_.flatten.length)

def minLen(sentences: List[List[String]]): Int = sentences.map(_.flatten.length).min
minLen(ff)


val myList = List(
  "a1", "b2", "c3",
  "a1", "b2", "c3",
  "a1", "b2", "c3",
  "a1", "b2", "c3",
  "a1", "b2", "c3",
  "a1", "b2", "c3",
  "a1", "b2", "c3",
  "a1", "b2", "c3",
  "a1", "b2", "c3",
  "a1", "b2", "c3",
  "a1", "b2", "c3",
  "a1", "b2", "c3",
  "a1", "b2", "c3",
  "a1", "b2", "c3"
)
val courseList = List("nu", "run", "urn", "Zulu", "null", "ill", "in", "Uzi", "Uri", "Unix", "ruin", "Lin", "nil", "rill", "Liz", "Linux", "en", "re", "ex", "rue", "Rex", "Zen", "Len", "Nell", "lure", "rule", "rulez", "Eli", "lie", "ire", "rein", "urine", "lien", "line", "Neil", "Nile", "lieu", "liner")

def combine(in: List[String]): Seq[String] =
  for {
    len <- 1 to in.length
    combinations <- in.combinations(len)
    if combinations.mkString.length <= 10
  } yield combinations.mkString

myList.combinations(1).mkString
myList.combinations(2).mkString
myList.combinations(3).mkString

//combine(myList)

combine(courseList)


// ------- Combinatorial issue
// 1 <= j < i < n == 5
/*
val n = 5
for {
  i <- 2 to n
  j <- 1 to i
} yield i + j


type Occurrences = List[(Char, Int)]
val y = ('a', 3)
val c = List(('a', 2), ('b', 2))


def descOccs(occs: Occurrences): List[Occurrences] = {
  def descOcc(occ: (Char, Int)): Occurrences = {
    val c = for {
      n <- 1 to occ._2
    } yield (occ._1, n)
    c.toList
  }
  occs map descOcc
}

val toBeCross: List[Occurrences] = descOccs(c) //  List(List((a,1), (a,2)), List((b,1), (b,2)))
def cross(x: List[Occurrences], y: Occurrences): List[Occurrences] =
  for {
    xs <- x
    ys <- y
  } yield  xs :+ ys

val ff: List[Occurrences] = List(
  List(('a',1), ('b',2)),
  List(('f',1), ('f',2))
)
ff.reduceLeft(cross(_, _))
*/










