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
        if (game.click(y, x)) game.moveCount++
        game.print()
    }
    val end = System.currentTimeMillis()
    println("time: " + ((end.toDouble() - start.toDouble()) / 1000) + "s")

}