package dk.w4.tictactoe.tictactoetests

import dk.w4.tictactoe.tictactoe.Player
import dk.w4.tictactoe.tictactoe.TicTacToe
import org.junit.Assert.*
import org.junit.Test

class TicTacToeTest {
    val ticTacToe = TicTacToe()

    @Test
    fun testStartGame() {
        val status = ticTacToe.isGameStared()
        assertFalse(status)

        val p1 = Player("Player1", 'X')
        val p2 = Player("Player2", 'O')

        ticTacToe.startGame(p1, p2)

        val status2 = ticTacToe.isGameStared()
        assertTrue(status2)
    }

    @Test
    fun testPlayRound() {

    }


    @Test
    fun testGetCurrentPlayer() {
        val player = ticTacToe.getCurrentPlayer()
        assertNotNull(player)
    }

    @Test
    fun testMakeMove() {
        ticTacToe.resetGame()
        val p1 = Player("test1", 'X')

        // Can do a move
        val result1 = ticTacToe.makeMove(p1, Pair(1, 1))
        assertTrue(result1)

        // Cannot do the same move
        val result2 = ticTacToe.makeMove(p1, Pair(1, 1))
        assertEquals(false, result2)
    }

    @Test
    fun testHasWinner() {
        ticTacToe.resetGame()
        val player1: Player = Player("player1", 'X')

        // Horizontal
        ticTacToe.makeMove(player1, Pair(0, 0))
        ticTacToe.makeMove(player1, Pair(0, 1))
        ticTacToe.makeMove(player1, Pair(0, 2))

        val result = ticTacToe.hasWinner('X')
        assertTrue(result)

        // Vertical
        ticTacToe.resetGame()

        ticTacToe.makeMove(player1, Pair(0, 0))
        ticTacToe.makeMove(player1, Pair(1, 0))
        ticTacToe.makeMove(player1, Pair(2, 0))

        val result2 = ticTacToe.hasWinner('X')
        assertTrue(result2)

        // Diagonal
        ticTacToe.resetGame()

        ticTacToe.makeMove(player1, Pair(0, 0))
        ticTacToe.makeMove(player1, Pair(1, 1))
        ticTacToe.makeMove(player1, Pair(2, 2))

        val result3 = ticTacToe.hasWinner('X')
        assertTrue(result3)
    }

    @Test
    fun testResetGame(): Unit {
        val ttt = TicTacToe()

        val result: Boolean = ttt.resetGame()
        assertTrue(result)
    }

    @Test
    fun testPlayAGame(){
        ticTacToe.resetGame()

        val p1 = Player("test1", 'X')
        val p2 = Player("test2", 'O')

        ticTacToe.startGame(p1,p2)
        ticTacToe.playRound(Pair(1,1))
        ticTacToe.playRound(Pair(0,0))

        assertTrue(ticTacToe.isGameStared())

        ticTacToe.playRound(Pair(1,0))
        ticTacToe.playRound(Pair(0,1))

        assertTrue(ticTacToe.isGameStared())

        ticTacToe.playRound(Pair(2,0))
        ticTacToe.playRound(Pair(0,2))

        assertFalse(ticTacToe.isGameStared())

    }
}