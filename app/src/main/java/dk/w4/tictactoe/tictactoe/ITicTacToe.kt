package dk.w4.tictactoe.tictactoe

interface ITicTacToe {
    fun startGame(player1: Player, player2: Player)
    fun resetGame():Boolean
    fun hasWinner(symble: Char): Boolean

    fun makeMove(player: Player, position: Pair<Int, Int>): Boolean
    fun playRound(position: Pair<Int, Int>): Boolean

    fun changePlayer()
    fun getCurrentPlayer(): Player
    fun isGameStared(): Boolean
}