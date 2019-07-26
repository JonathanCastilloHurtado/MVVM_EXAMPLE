package com.example.mvvm_example;

import androidx.databinding.ObservableField;

import java.util.Observable;

public class User extends Observable {

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {

        this.name = name;
    }

    public ObservableField<String> name;
}
