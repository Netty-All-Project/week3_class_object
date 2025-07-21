package example.myapp

/*Parent Class จะใช้ open ในการสืบทอด
* ใส่ตรง Class , property , parameter
* */
open class Aquarium(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {

    open val shape = "rectangle"

    /*init*/
    /*init {
        println("aquarium initializing")
    }

    init {
        println("Volume: ${width * length * height/1000} liters")
    }

     */

    //secondary Constructors
    /*
    constructor(numberOfFish:Int) :this(){
        val tank = numberOfFish * 2000 * 1.1
        val height = (tank / (length * width)).toInt()
    }
    */


    /*property*/
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open var water: Double = 0.0
        get() = volume * 0.9


    fun printSize() {
        println(shape)
        println(
            "Width: $width cm " +
                    "Length: $length cm " +
                    "Height: $height cm "
        )
        // 1 l = 1000 cm^3
        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")
    }

}

/*SubClass*/
class TowerTank(
    override var height: Int,
    var diameter: Int
) : Aquarium(height = height, width = diameter, length = diameter) {
    /*Override ใช้ในกรณีที่ต้องการเขียนทับ property หรือ function ของ parents class*/
    override var volume: Int
        // ellipse area = π * r1 * r2
        get() = (width / 2 * length / 2 * height / 1000 * Math.PI).toInt()
        set(value) {
            height = ((value * 1000 / Math.PI) / (width / 2 * length / 2)).toInt()
        }

    override var water = volume * 0.8

    override val shape = "cylinder"
}

