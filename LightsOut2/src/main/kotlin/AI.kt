class AI {
    fun play() {
        val game = Game()
        game.randomize()
        for (i in game.field) {
            for (j in i) {
                if (j) print("⬛ ") else print("⬜ ")
            }
            println()
        }

        moveDown(game)
        if (game.isWon()) {
            println("AI won in ${game.moveCount} moves")
            return
        } else {
            if (game.field[4][0] && game.field[4][1] && game.field[4][2] && !game.field[4][3] && !game.field[4][4]) { //11100
                game.click(0, 1)
                println("case 11100: clicked 0, 1")
            } else if (!game.field[4][0] && !game.field[4][1] && game.field[4][2] && game.field[4][3] && game.field[4][4]) { //00111
                game.click(0, 3)
                println("case 00111: clicked 0, 3")
            } else if (game.field[4][0] && game.field[4][1] && !game.field[4][2] && game.field[4][3] && game.field[4][4]) { //11011
                game.click(0, 2)
                println("case 11011: clicked 0, 2")
            } else if (!game.field[4][0] && game.field[4][1] && game.field[4][2] && !game.field[4][3] && game.field[4][4]) { //01101
                game.click(0, 2)
                game.click(0, 4)
                println("case 01101: clicked 0, 2 and 0, 4")
            } else if (game.field[4][0] && !game.field[4][1] && game.field[4][2] && game.field[4][3] && !game.field[4][4]) { //10110
                game.click(0, 0)
                game.click(0, 2)
                println("case 10110: clicked 0, 0 and 0, 2")
            } else if (game.field[4][0] && !game.field[4][1] && !game.field[4][2] && !game.field[4][3] && game.field[4][4]) { //10001
                game.click(0, 0)
                game.click(0, 1)
                println("case 10001: clicked 0, 0 and 0, 1")
            } else if (!game.field[4][0] && game.field[4][1] && !game.field[4][2] && game.field[4][3] && !game.field[4][4]) { //01010
                game.click(0, 0)
                game.click(0, 1)
                game.click(0, 2)
                println("case 01010: clicked 0, 0 and 0, 1 and 0, 2")
            } else println("this will never happen")
            moveDown(game)
            if (game.isWon()) {
                println("AI won in ${game.moveCount} moves")
            } else println("this shouldn't happen")

        }
    }

    private fun moveDown(game: Game) {
        for (i in 0..3) {
            for (j in 0..4) {
                if (game.field[i][j]) {
                    game.click(i + 1, j)
                    println("clicked $i, $j")
                }
            }
        }
    }
}