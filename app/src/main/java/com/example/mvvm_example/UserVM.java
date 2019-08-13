package com.example.mvvm_example;

import android.view.View;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

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
        //url = http://cardfindercdmx.com/personal/get_book.php
        new Model().execute(BuildConfig.url, new Model.OnResult() {

            @Override
            public void onSuccess(String result) {
                response.set(result);
                isVisible.set(View.GONE);
            }

            @Override
            public void onError(String error) {
                response.set(error);
                isVisible.set(View.GONE);
            }
        });
    }

}
