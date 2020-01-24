package com.example.mvvm_example

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.example.mvvm_example.Model.Model
import com.example.mvvm_example.Model.Model.OnResult


class UserVM(val btnText:ObservableInt = ObservableInt(R.string.btn_text)) : ViewModel() {

    var response = ObservableField<String>()
    fun onButtonClick() {
        //isVisible.set(View.VISIBLE)
        val urlEndpoint = "apis/get_book.php"
        //url = http://johncastle.com.mx/
        Model().execute(BuildConfig.url + urlEndpoint, object : OnResult {
            override fun onSuccess(result: String?) {
                response.set(result)
               // isVisible.set(View.GONE)
            }

            override fun onError(error: Exception) {
                prepareError(error)
            }
        })
    }

    fun prepareError(error: Exception) {
        response.set(error.toString())
        //isVisible.set(View.GONE)
    }
}