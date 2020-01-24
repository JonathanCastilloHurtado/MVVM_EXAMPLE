package com.example.mvvm_example

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel

class UserVM(val btnText:ObservableInt = ObservableInt(R.string.btn_text)) : ViewModel() {


}