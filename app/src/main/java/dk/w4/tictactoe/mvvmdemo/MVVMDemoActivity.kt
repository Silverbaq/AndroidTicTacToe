package dk.w4.tictactoe.mvvmdemo

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil.setContentView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dk.w4.tictactoe.R
import dk.w4.tictactoe.databinding.ActivityMvvmdemoBinding

class MVVMDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = setContentView<ActivityMvvmdemoBinding>(this, R.layout.activity_mvvmdemo)
        binding.viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.setLifecycleOwner(this)
    }
}
