package com.example.mvvm_example;

import android.os.Handler;

public class model {

    //Al este metodo se un return y no estar conectado con el VM de manera correcta,
    //durante el tiempo de jecucion, el SO de android no espera a contar los 5 segundos,
    //apresurando al sistema a dar la respuesta inicial de la variable boleana mediante el return.
    public boolean getBook(String query) {
        final Boolean[] isStock = {false};
        //este handler simulara el tiempo de respuesta de la busqueda en la base de datos
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                //una vez que realmente encontro el resultado
               isStock[0] =true;
            }
        }, 5000);

        return isStock[0];
    }

}
