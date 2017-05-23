
object Main extends App {
  	var capital = Map("US" -> "Washington", "France" -> "Paris", "China" -> "Beijing")
	capital += ("Japan" -> "Tokyo")
	//println(capital("France"))

	val up = new Upper
	//println(up.upper("A", "First", "Scala", "Program"))
	println(up.sum(x => x * x, 3, 5))
	println(up.sum2(x => x * x)(3,5))
	println(up.sum3(x => x * x)(3,5))
	println(up.product(x => x * x)(3,4))
}

class Upper{
	def upper(strings: String*) = strings.map(_.toUpperCase())


	def add(int1: Int, int2: Int): Int = int1 + int2

	def sum(f: Int => Int, a: Int, b: Int) = {
		def loop(a: Int, acc: Int): Int ={
			if(a > b) acc
			else loop(a+1, f(a) + acc)
		}
		loop(a, 0)
	}

	def sum2(f: Int => Int): (Int, Int) => Int = {
		def loop(a: Int, b: Int): Int ={
			if(a > b) 0
			else f(a) + loop(a + 1, b)
		}
		loop
	}

	def sum3(f: Int => Int)(a: Int, b: Int): Int = {
		if(a > b) 0
		else f(a) + sum3(f)(a+1, b)
	}

	def product(f: Int => Int)(a: Int, b: Int): Int = {
		if(a > b) 1
		else f(a) * product(f)(a+1, b)
	}


}
