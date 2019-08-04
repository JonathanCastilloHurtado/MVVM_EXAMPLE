package com.example.mvvm_example;

import android.os.Handler;

import java.util.Random;

public class model {

    /*
    //Al este metodo se un return y no estar conectado con el VM de manera correcta,
    //durante el tiempo de jecucion, el SO de android no espera a contar los 5 segundos,
    //apresurando al sistema a dar la respuesta inicial de la variable boleana mediante el return.
    //TODO wee aqui es donde een lugar de manejar la respueta como return boolean, creemos una
    //TODO variable observable la cual el VM observara su cambio de estado
    public boolean getBook() {
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
    */


	///https://proandroiddev.com/mvvm-architecture-viewmodel-and-livedata-part-1-604f50cda1

	// Manda a llamar tu petición y lo regresas con un callback, si usas como en el ejemplo
	// Retrofit entonces cuando haces la petición hay un callback de respuesta
	public void getBook(final OnResult callback) {
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {

			public void run() {
				//una vez que realmente encontro el resultado
				callback.onSuccess(getRandomText());
			}
		}, 200);
	}

	private String getRandomText() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	public interface OnResult {

		void onSuccess(String result);

		void onError();
	}
}
