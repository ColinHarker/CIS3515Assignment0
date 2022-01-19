import java.util.*
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {

    var square: Square = Square("Square")
    var circle: Circle = Circle("Circle")
    var triangle: Triangle = Triangle("Triangle")
    var equilateralTriangle: EquilateralTriangle = EquilateralTriangle("EquilateralTriangle")

    val reader = Scanner(System.`in`)

    println("Enter Square dimensions (W H):")

    var width = reader.nextDouble()
    var height = reader.nextDouble()

    square.setDimensions(width, height)

    println("Enter Circle dimensions (R):")

    var radius = reader.nextDouble()

    circle.setDimensions(radius)

    println("Enter Triangle dimensions (A B C):")

    var a = reader.nextDouble()
    var b = reader.nextDouble()
    var c = reader.nextDouble()

    triangle.setDimensions(a, b, c)

    println("Enter EquilateralTriangle dimensions (S):")

    var side = reader.nextDouble()

    equilateralTriangle.setDimensions(side)

    println("${square.name} Height: ${square.height} Width: ${square.length} Area: ${square.getArea()}")
    println("${circle.name} Radius: ${circle.radius} Area: ${circle.getArea()}")
    println("${triangle.name} SideA: ${triangle.side_a} SideB: ${triangle.side_b} SideC: ${triangle.side_c} Area: ${triangle.getArea()}")
    println("${equilateralTriangle.name} Side: ${equilateralTriangle.side} Area: ${equilateralTriangle.getArea()}")
}

abstract class Shape(_name: String){
    var name = _name

    open fun getArea(): Double {
        return 0.0
    }

    open fun printDimensions(){
        println("No dimensions")
    }

}

class Square(_name: String) : Shape(_name){

    var length: Double = 0.0
    var height: Double = 0.0

    fun setDimensions(_length: Double, _height: Double){
        length = _length
        height = _height
    }

    override fun printDimensions(){
        println("Length: $length, Height: $height")
    }

    override fun getArea(): Double {
        return length * height
    }
}

class Circle(_name: String) : Shape(_name){

    var radius: Double = 0.0;

    fun setDimensions(_radius: Double){
        radius = _radius
    }

    override fun printDimensions() {
        println("Radius: $radius")
    }

    override fun getArea(): Double {
        return (PI * radius).pow(2)
    }
}

open class Triangle(_name: String) : Shape(_name){

    var side_a: Double = 0.0;
    var side_b: Double = 0.0;
    var side_c: Double = 0.0;

    fun setDimensions(_side_a: Double, _side_b: Double, _side_c: Double){
        side_a = _side_a
        side_b = _side_b
        side_c = _side_c
    }

    override fun printDimensions() {
        println("Side_a: $side_a, Side_b: $side_b, Side_c: $side_c")
    }

    override fun getArea(): Double {
        val s = (side_a + side_b + side_c) / 2
        return sqrt(s * (s - side_a) * (s - side_b) * (s - side_c))
    }
}

class EquilateralTriangle(_name: String) : Triangle(_name){

    var side: Double = 0.0

    fun setDimensions(_side: Double){
        side = _side
    }

    override fun printDimensions() {
        println("Side: $side")
    }

    override fun getArea(): Double {
        val s = (side * 3) / 2
        return sqrt(s * (s-side).pow(3))
    }
}