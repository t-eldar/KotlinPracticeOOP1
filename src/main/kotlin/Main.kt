import taskone.*
import tasktwo.*
import taskthree.*

fun main(args: Array<String>) {
    // task one
    println("---------------------------------------------------------------------")
    val circle = Circle(3.0)
    val rectangle = Rectangle(2.0, 4.0)
    val triangle = Triangle(1.0, 1.0, 1.0)

    val shapes = listOf(circle, rectangle, triangle)

    for (shape in shapes) {
        println(
            """Shape ${shape.toString().takeWhile { it != '@' } }
            |Area: ${shape.area()}
            |Perimeter: ${shape.perimeter()}
            |""".trimMargin()
        )
    }

    // task two
    println("---------------------------------------------------------------------")
    val logger1 = Logger.getInstance()
    val logger2 = Logger.getInstance()

    println("Are loggers equal: ${logger1 == logger2}")

    logger1.log("Logger check", LogLevel.INFO)

    // task three
    println("---------------------------------------------------------------------")
    class Person(val name: String, val age: Int) {
        override fun toString(): String {
            return """
                {
                    name: $name,
                    age: $age
                }
            """.trimIndent()
        }
    }
    val data = Person("Knud", 24)
    val success = Result.Success(data)
    val error = Result.Error<Person>("Error mock")

    processResult(success)
    processResult(error)
}