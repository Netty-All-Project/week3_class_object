package example.myapp

/*Abstract Class
* จะใช้ผ่าน : ตามด้วยชื่อ Class*/
abstract class AquariumFish : FishAction {
    abstract val color: String
    override fun eat() = println("yum")

}

class Shark: FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus (fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

/*Interface*/
interface FishAction  {
    fun eat()
}

interface FishColor {
    val color: String
}

/*singleton class*/
object GoldColor : FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

object GoldColor : FishColor {
    override val color = "gold"
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}

enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

