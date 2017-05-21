
object Main extends App {
  	var capital = Map("US" -> "Washington", "France" -> "Paris", "China" -> "Beijing")
	capital += ("Japan" -> "Tokyo")
	//println(capital("France"))

	val up = new Upper
	println(up.upper("A", "First", "Scala", "Program"))
	println(up.add(1,2))
}

class Upper{
	def upper(strings: String*) = strings.map(_.toUpperCase())


	def add(int1: Int, int2: Int): Int = int1 + int2
}
