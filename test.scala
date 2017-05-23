
object Main extends App {
  	var capital = Map("US" -> "Washington", "France" -> "Paris", "China" -> "Beijing")
	capital += ("Japan" -> "Tokyo")
	//println(capital("France"))

	val up = new Upper
	//println(up.upper("A", "First", "Scala", "Program"))
	println(up.sum(x => x * x, 3, 5))
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


}
