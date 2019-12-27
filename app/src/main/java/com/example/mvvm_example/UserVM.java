package com.example.mvvm_example;

import android.view.View;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.example.mvvm_example.Model.Model;

import java.util.Observable;

public class UserVM extends Observable {

    public ObservableField<String> response;
    public ObservableInt isVisible;
    public ObservableInt btnText;

    public UserVM() {
        isVisible = new ObservableInt();
        response = new ObservableField<String>();
        //btn_text = Consume Api
        btnText= new ObservableInt(R.string.btn_text);
    }

    public void onButtonClick() {
        isVisible.set(View.VISIBLE);
        final String urlEndpoint = "apis/get_book.php";
        //url = http://johncastle.com.mx/
        new Model().execute(BuildConfig.url+urlEndpoint, new Model.OnResult() {
            @Override
            public void onSuccess(String result) {
                response.set(result);
                isVisible.set(View.GONE);
            }
            @Override
            public void onError(Exception error) {
               prepareError(error);
            }
        });
    }

    public void prepareError(Exception error){
        response.set(error.toString());
        isVisible.set(View.GONE);
    }
}
