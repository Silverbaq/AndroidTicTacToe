package dk.w4.tictactoe.mvvmdemo

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.view.View

class MainViewModel: ViewModel() {
    var name = MutableLiveData<String>()

    fun onClick(view: View) {
        name.value = "something else"
    }
}
