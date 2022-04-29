fun main() {
    val game = Game()
    game.randomize()
    game.print()
    val start = System.currentTimeMillis()

    while (!game.checkWin()) {
        println("enter y")
        val y = readLine()!!.toInt()
        println("enter x")
        val x = readLine()!!.toInt()
        if (game.click(y, x)) { //only happens if the click was in bounds
            game.moveCount++
            println("out of bounds")
            game.print()
        }
    }
    val end = System.currentTimeMillis()
    println("you won!")
    println("moves: ${game.moveCount}")
    println("time: " + ((end.toDouble() - start.toDouble()) / 1000) + "s")

}
