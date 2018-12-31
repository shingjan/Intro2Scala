package recfun

object Main {
  def main1(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  def main(args: Array[String]): Unit ={
    val x1 = "(if (zero? x) max (/ 1 x))"
    val x2 = "I told him (that it’s not (yet) done). (But he wasn’t listening)"
    val x3 = ":-)"
    println(balance(x1.toList))
    println(balance(x2.toList))
    println(balance(x3.toList))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      c match {
        case 0 => 1
        case `r` => 1
        case _ => pascal(c, r - 1) + pascal(c - 1, r - 1)
      }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balance_aux(cs: List[Char], acc: Int): Boolean =
        if(acc > 0) false else
        cs match {
          case Nil => if(acc == 0) true else false
          case x :: xs =>
            x match {
              case '(' => balance_aux(xs, acc - 1)
              case ')' => balance_aux(xs, acc + 1)
              case _ => balance_aux(xs, acc)
            }
        }
      balance_aux(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def countChangeOnce(money: Int, coins: List[Int]): Int =
        coins match {
          case Nil => 0
          case x :: xs =>
            val res = money - x
            if(res < 0)
              countChange(money, xs)
            else if(res > 0)
              countChange(res, coins) + countChangeOnce(money, xs)
            else
              1
          }
      if(money == 0) 0
      else countChangeOnce(money, coins.sorted)
    }

  }
