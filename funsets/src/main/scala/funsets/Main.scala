package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
}

object wk2 {
  /*
  Tail recursion of function sum
   */
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if(a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }

  def product(f: Int => Int, a: Int, b: Int): Int = {
    if(a > b) 1 else product(f, a+1, b) * f(a)
  }

  def factorial(n: Int): Int = product(x => x, 1, n)

  def mapReduce(f: Int => Int)(combine: (Int, Int) => Int)(base: Int)(a: Int, b: Int): Int = {
    if(a > b) base
    else combine(mapReduce(f)(combine)(base)(a + 1, b), f(a))
  }
}
