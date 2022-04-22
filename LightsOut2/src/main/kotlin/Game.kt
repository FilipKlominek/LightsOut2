import kotlin.random.Random

class Game {
    private val field = Array(5) { arrayOf(true, true, true, true, true) }

    fun randomize() {
        for (i in 0..4) for (j in 0..4) {
            if (Random.nextBoolean()) click(i, j)
        }
        if (isWon()) randomize()
    }

    fun click(y: Int, x: Int): Boolean {
        if (y > 4 || y < 0 || x > 4 || x < 0) {
            println("out of bounds")
            return false
        } else {
            field[y][x] = !field[y][x]
            if (y > 0) field[y - 1][x] = !field[y - 1][x]
            if (y < 4) field[y + 1][x] = !field[y + 1][x]
            if (x > 0) field[y][x - 1] = !field[y][x - 1]
            if (x < 4) field[y][x + 1] = !field[y][x + 1]
        }
        return true
    }

    var moveCount = 0

    private fun isWon(): Boolean {
        for (i in field) for (j in i) {
            if (j) return false
        }
        return true
    }


    fun checkWin(): Boolean {
        return if (!isWon()) false
        else {

            println("you won!")
            println("moves: $moveCount")

            true
        }
    }

    fun print() {
        for (i in field) {
            for (j in i) {
                if (j) print("⬛ ") else print("⬜ ")
            }
            println()
        }
        println("moves: $moveCount")
        println()
    }
}