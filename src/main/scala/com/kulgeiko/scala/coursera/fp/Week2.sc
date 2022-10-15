

// --------------- Higher - order function

def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, f(a) + acc)
  }
  loop(a, 0)
}

def fact(n: Int): Int = {
  if (n == 0) 1
  else n + fact(n-1)
}

def sumInts(a: Int, b: Int) = sum(x => x: Int)(a, b)
def sumCubes(a: Int, b: Int) = sum(x => x*x*x: Int)(a, b)
def sumFactorials(a: Int, b: Int) = sum(fact)(a, b)

sumInts(0,3)
sumCubes(0,3)
sumFactorials(0,3)

// --------------- Currying

def sumCurrying(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  }
  sumF
}

/*
def newSumInts = sumCurrying(x => x)
def newSumCubes = sumCurrying(x => x*x*x)
def newSumFactorials = sumCurrying(fact)

newSumInts(0,3)
newSumCubes(0,3)
newSumFactorials(0,3)
*/

sumCurrying(x => x)(0, 3)
sumCurrying(x => x*x*x)(0, 3)
sumCurrying(fact)(0, 3)


def sumUpdated(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sumUpdated(f)(a + 1, b)


def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1 else f(a) * product(f)(a + 1, b)
product(x => x)(1,3)


def factorial(n: Int) = product(x => x)(1, n)
factorial(5)


def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

mapReduce(x => x, (a, b) => a * b, 1)(1, 5)


// --------------- Rational


class Rational(x: Int, y: Int) {

  require(y != 0, "Denominator should not be zero")
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x // / g
  def denom = y // / g

  override def toString = x / g + "/" + y / g

  def add(that: Rational) =
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom)
  def neg = new Rational(-numer, denom)
  def sub(that: Rational) = add(that.neg)

}

new Rational(1, 2).neg
new Rational(2, 2).sub(new Rational(1, 2))
val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 0)

y.add(y)


