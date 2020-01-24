package com.example.mvvm_example

import android.util.Log
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.example.mvvm_example.Model.Model.OnResult


class UserVM(val btnText:ObservableInt = ObservableInt(R.string.btn_text)) : ViewModel() {

    fun onButtonClick() {
        Log.e("JOHN","CLIKC");
    }

}