package dk.w4.tictactoe.tictactoe

import android.arch.lifecycle.MutableLiveData



class Player(val name: String, val icon: Char)

class TicTacToe : ITicTacToe {
    private var currentPlayer: Player = Player("No one", '-')
    private lateinit var player1: Player
    private lateinit var player2: Player

    var winner = MutableLiveData<Player>()

    var board = arrayListOf(
            arrayListOf(' ', ' ', ' '),
            arrayListOf(' ', ' ', ' '),
            arrayListOf(' ', ' ', ' ')
    )

    override fun startGame(player1: Player, player2: Player) {
        this.player1 = player1
        this.player2 = player2
        this.currentPlayer = player1
        playing = true
    }

    override fun playRound(position: Pair<Int, Int>): Boolean {
        if (!makeMove(currentPlayer, position) || !playing)
            return false
        hasWinner(currentPlayer.icon)
        changePlayer()
        return true
    }

    override fun makeMove(player: Player, position: Pair<Int, Int>): Boolean {
        if (board[position.first][position.second] != ' ') return false
        board[position.first][position.second] = player.icon
        return true
    }

    override fun changePlayer() {
        if (currentPlayer == player1)
            currentPlayer = player2
        else
            currentPlayer = player1
    }

    override fun resetGame(): Boolean {
        board = arrayListOf(
                arrayListOf(' ', ' ', ' '),
                arrayListOf(' ', ' ', ' '),
                arrayListOf(' ', ' ', ' ')
        )
        return true
    }

    override fun hasWinner(symble: Char): Boolean {
        var horizontal: Boolean = false
        board.forEach {
            val row = it.joinToString("")
            if (row == "$symble$symble$symble") horizontal = true
        }

        var vertical = false
        for (i in 0..2) {
            val line = "" + board[0][i] + board[1][i] + board[2][i]
            if (line == "$symble$symble$symble") vertical = true
        }

        var diagonal = false
        if ("" + board[0][0] + board[1][1] + board[2][2] == "$symble$symble$symble" ||
                "" + board[2][0] + board[1][1] + board[0][2] == "$symble$symble$symble")
            diagonal = true

        if (horizontal || vertical || diagonal){
            playing = false
            winner.value = currentPlayer
            return true
        }
        return false
    }

    override fun isGameStared(): Boolean {
        return playing
    }

    override fun getCurrentPlayer(): Player {
        return currentPlayer
    }

    companion object {
        private var playing = false

    }
}

