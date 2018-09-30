package dk.w4.tictactoe.tictactoe

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.LiveData



class TicTacToeViewModel : ViewModel() {
    val ticTacToe = TicTacToe()
    var board: MutableLiveData<ArrayList<ArrayList<String>>>

    init {
        val p1 = Player("Player1", 'X')
        val p2 = Player("Player2", 'O')
        ticTacToe.startGame(p1,p2)

        board = MutableLiveData()
        board.value =  arrayListOf(
                arrayListOf(" ", " ", " "),
                arrayListOf(" ", " ", " "),
                arrayListOf(" ", " ", " ")
        )
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

}