package com.example.mvvm_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mvvm_example.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCambiaVariable;
    //El binding correspondiente sera el camel case dela activity misma que tiene las suscripciones.
    ActivityMainBinding binding;
    //creamos un objeto GLOBAL ya que las suscripciones estaran ligadas con la direccion de memoria de este objeto en especifico.
    User usuario = new User();
    //creamos la variable String observable la cual mandaremos a travez del setter para modificar activamente la vista.
    ObservableField<String> name=new ObservableField<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //iniciamos nuestro binding con la actividad que cuenta con las suscripciones que trabajaremos.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //Le damos un valor a nuestro objeto que esta suscrito nustra vista
        //la variablee observable debe de ser inicialiada desde un inicio ya que para que la vista pueda observar activamente,
        //el objeto que modificamos debe contener la misma direccion de memoria del String observable.
        //por lo cual si cambiamos el seteo por .set(new ObservableField<>("ALGO")); en cada ocacion, el observador
        //solo vera la primera direccion de memoria del objeto seteado.
        name.set("JOHN2");
        usuario.setName(name);

        //a nuestros variables (variables a los cuales estan suscritos nuestras vistas) les asiganamos el objeto con el que estos trabajaran (objetos a los cuales se suuscribiran)
        binding.setUser(usuario);
        //En el caso de el evento, le pasaremos la case contenedora de este evento (clase contenedora de eventos a la cual estara susrita)
        binding.setHandler(new EventHandler(this));

        //este boton solo lo utilizaremos para comprobar que la vista esta tomando sus variables directo del objeto y no a partir de algun view.setText()
        btnCambiaVariable = findViewById(R.id.button);
        btnCambiaVariable.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //modificamos el objeto inicial al cual nustra vista esta suscrito.
        name.set("HI");
        usuario.setName(name);
    }
}
