fun main() {
    val game = Game()
    game.randomize()
    print(game)
    val start = System.currentTimeMillis()

    while (!game.checkWin()) {
        println("enter y")
        val y = readLine()!!.toInt()
        println("enter x")
        val x = readLine()!!.toInt()
        if (game.click(y, x)) { //only happens if the click was in bounds
            game.moveCount++
            print(game)
        } else println("out of bounds")
    }
    val end = System.currentTimeMillis()
    println("you won!")
    println("moves: ${game.moveCount}")
    println("time: " + ((end.toDouble() - start.toDouble()) / 1000) + "s")

}

fun print(game: Game) {
    for (i in game.field) {
        for (j in i) {
            if (j) print("⬛ ") else print("⬜ ")
        }
        println()
    }
    println("moves: ${game.moveCount}")
    println()
}
