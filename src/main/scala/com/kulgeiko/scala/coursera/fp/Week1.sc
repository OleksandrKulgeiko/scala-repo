def abs(x: Double) = if (x < 0) -x else x

def sqrt(x: Double) = {

  def sqrtIter(guess: Double, x: Double): Double = {
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess), x)
  }

  def isGoodEnough(guess: Double) = abs(guess*guess - x) / x < 0.001
  def improve(guess: Double) = (guess + x / guess) / 2
  sqrtIter(1e60, x)
}

sqrt(4)
sqrt(1e-20)
sqrt(1e60)

//---------------------------- Tail recursion

def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b)

gcd(14,21)

def factorial(x: Int): Long =
  if (x == 0) 1
  else x * factorial(x - 1)

def factorialTailRec(n: Int): Long = {
  def loop(acc: Int, n: Int): Long =
    if (n == 0) acc
    else loop(acc * n, n - 1)
  loop(1, n)
}

factorialTailRec(4)

val myList = List(1, 2, 3, 4, 5)

myList.head
myList.tail

//---------------------------- Balancing
/*
def balance(chars: List[Char]): Boolean = {
  def loop(open: Int, close: Int, chars: List[Char]): Boolean = {
    if (chars.isEmpty) open == close
    else if (close > open) false
    else {
      val openNum = if (chars.head == '(') open + 1 else open
      val closeNum = if (chars.head == ')') close + 1 else close
      loop(openNum, closeNum, chars.tail)
    }
  }
  loop(0, 0, chars)
}
balance("())(".toList)
*/

//---------------------------- Change


def countChange(money: Int, coins: List[Int]): Int = {

  def loop(money: Int, count: Int, coins: List[Int]): Int = {
    if (coins.isEmpty) count
    else {
      val chnageNum = if (money % coins.head == 0) count + 1 else count
      loop(money, chnageNum, coins.tail)
    }
  }

  loop(money, 0, coins)
}

countChange(9, List(1, 2, 3))