package com.example.mvvm_example;

import androidx.databinding.ObservableField;

import java.util.Observable;

public class UserVM extends Observable {

    public ObservableField<String> name;

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {

        this.name = name;
    }

    public void onButtonClick() {
        //aqui es el problema ya que pasa lo mismo que cuando se implemente mal el MVP
        Boolean isStock=new model().getBook();
        if(isStock){
            //TODO aqui es donde te digo que yo creeria que el VM deberia hacer referencia a la variable observable del Model a la cual esta suscrito
            //TODO algo asi como model.setisStock(isStock);
            //TODO y asi cuando el model termine su chamba cambie el estado de su variable y el VM lo note ya que esta suscrito al model
            name.set("HI");
        }
    }
}
