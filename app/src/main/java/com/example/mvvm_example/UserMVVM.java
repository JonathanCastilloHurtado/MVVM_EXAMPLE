package com.example.mvvm_example;

import androidx.databinding.ObservableField;

import java.util.Observable;

public class UserMVVM extends Observable {

    public ObservableField<String> name;

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {

        this.name = name;
    }

    public void onButtonClick() {
        //aqui es el problema ya que pasa lo mismo que cuando se implemente mal el MVP
        Boolean isStock=new model().getBook("");
        if(isStock){
            name.set("HI");
        }
    }
}
