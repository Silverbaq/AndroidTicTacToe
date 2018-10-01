package dk.w4.tictactoe.tictactoe

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.LiveData
import android.view.View


class TicTacToeViewModel : ViewModel() {
    val ticTacToe = TicTacToe()
    var board: MutableLiveData<ArrayList<ArrayList<String>>>

    init {
        val p1 = Player("Player1", 'X')
        val p2 = Player("Player2", 'O')
        ticTacToe.startGame(p1,p2)

        board = MutableLiveData()
        makeBoard()
    }

    fun onClickedCellAt(row: Int, column: Int) {
        val player = ticTacToe.getCurrentPlayer()

        if(ticTacToe.playRound(Pair(row, column))){
            //TODO: Improve this
            board.value?.get(row)?.set(column, ""+player.icon)
            board.postValue(board.value)
        }
    }

    fun getWinner(): LiveData<Player> {
        return ticTacToe.winner
    }

    fun resetGame(){
        ticTacToe.resetGame()
        makeBoard()
    }

    fun makeBoard(){
        board.value =  arrayListOf(
                arrayListOf(" ", " ", " "),
                arrayListOf(" ", " ", " "),
                arrayListOf(" ", " ", " ")
        )
    }

}