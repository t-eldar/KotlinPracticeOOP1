package taskone

import kotlin.math.sqrt

abstract class Shape {
    abstract fun area(): Double
    abstract fun perimeter(): Double
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }

    override fun perimeter(): Double {
        return 2 * Math.PI * radius
    }
}

class Rectangle(
    val width: Double,
    val length: Double
) : Shape() {
    override fun area(): Double {
        return width * length
    }

    override fun perimeter(): Double {
        return 2 * (width + length)
    }
}

class Triangle(
    val firstSide: Double,
    val secondSide: Double,
    val thirdSide: Double
) : Shape() {
    override fun area(): Double {
        val semiPerimeter = perimeter() / 2
        return sqrt(
            semiPerimeter
                    * (semiPerimeter - firstSide)
                    * (semiPerimeter - secondSide)
                    * (semiPerimeter - thirdSide)
        )
    }

    override fun perimeter(): Double {
        return firstSide + secondSide + thirdSide
    }
}