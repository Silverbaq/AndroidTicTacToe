package dk.w4.tictactoe

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dk.w4.tictactoe.databinding.ActivityMainBinding
import dk.w4.tictactoe.tictactoe.TicTacToeViewModel
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var gameViewModel: TicTacToeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBinding()
        setUpOnGameEndListener()
    }

    private fun setBinding() {
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        gameViewModel = ViewModelProviders.of(this).get(TicTacToeViewModel::class.java)
        binding.gameViewModel = gameViewModel
        binding.setLifecycleOwner(this)
    }


    private fun setUpOnGameEndListener() {
        gameViewModel.getWinner().observe(this, Observer { player -> Toast.makeText(this, player?.name + " wins!", Toast.LENGTH_SHORT).show() })
    }

}
