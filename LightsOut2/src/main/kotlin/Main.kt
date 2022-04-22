fun main() {
    val game = Game()
    game.randomize()
    game.print()

    while (!game.checkWin()) {
        println("enter y")
        val y = readLine()!!.toInt()
        println("enter x")
        val x = readLine()!!.toInt()
        if (game.click(y, x)) game.moveCount++
        game.print()
    }

}