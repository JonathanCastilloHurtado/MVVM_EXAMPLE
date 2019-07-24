package com.example.mvvm_example;

import android.content.Context;
import android.widget.Toast;

public class EventHandler {
    Context mContext;


    public EventHandler(Context mContext) {
        this.mContext = mContext;
    }
//El parametro name es la variable del objeto a la cual esta suscrita nuestra vista.
    public void onButtonClick(String name) {
        Toast.makeText(mContext, "Now you are following " + name, Toast.LENGTH_SHORT).show();
    }
}
