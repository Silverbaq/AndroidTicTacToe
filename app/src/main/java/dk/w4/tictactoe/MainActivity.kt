package dk.w4.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dk.w4.tictactoe.mvvmdemo.MVVMDemoActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this,  MVVMDemoActivity::class.java)
        startActivity(intent)
    }
}
