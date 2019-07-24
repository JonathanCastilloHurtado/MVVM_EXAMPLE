package com.example.mvvm_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mvvm_example.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    //El binding correspondiente sera el camel case dela activity misma que tiene las suscripciones.
    ActivityMainBinding binding;
    //creamos un objeto GLOBAL ya que las suscripciones estaran ligadas con la direccion de memoria de este objeto en especifico.
    User usuario = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //iniciamos nuestro binding con la actividad que cuenta con las suscripciones que trabajaremos.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //Le damos un valor a nuestro objeto que esta suscrito nustra vista
        usuario.setName("JOHN2");

        //a nuestros variables (variables a los cuales estan suscritos nuestras vistas) les asiganamos el objeto con el que estos trabajaran (objetos a los cuales se suuscribiran)
        binding.setUser(usuario);
        //En el caso de el evento, le pasaremos la case contenedora de este evento (clase contenedora de eventos a la cual estara susrita)
        binding.setHandler(new EventHandler(this));

        //este boton solo lo utilizaremos para comprobar que la vista esta tomando sus variables directo del objeto y no a partir de algun view.setText()
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //modificamos el objeto inicial al cual nustra vista esta suscrito.
        usuario.setName("Blue eyes white Dragon");
    }
}
