package com.example.mvvm_example;

import android.os.Handler;

import java.util.Random;

public class model {

	///https://proandroiddev.com/mvvm-architecture-viewmodel-and-livedata-part-1-604f50cda1

	// Manda a llamar tu petición y lo regresas con un callback, si usas como en el ejemplo
	// Retrofit entonces cuando haces la petición hay un callback de respuesta
	public void getBook(final OnResult callback) {

	new Handler().postDelayed(new Runnable() {

			public void run() {
				//una vez que realmente encontro el resultado
				callback.onSuccess(getRandomText());
			}
		}, 5000);

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
