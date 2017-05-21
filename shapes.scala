package shapes{
	class Point(val x: Double, val y: Double) {
		override def toString() = "Point( " + x + " , " + y + " )"
	}

	abstract class Shape(){
		def draw(): Unit
	}

	class Circle(center: Point, radius: Double) extends Shape {
		def draw() = println("Circle.draw: " + this)
		override def toString() = "Circle( " + center + "," + radius + ")"
	}

	class Rectangle(lowerLeft: Point, height: Double, width: Double) extends Shape {
		
	}
}