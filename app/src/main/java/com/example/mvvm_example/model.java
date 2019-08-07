package com.example.mvvm_example;

import android.os.AsyncTask;
import android.os.Handler;

import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Random;

public class model  extends AsyncTask<Object, String, String> {

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

	@Override
	protected String doInBackground(Object... objects) {
		reqURL=objects[0].toString();
		callback=(OnResult)objects[1];
		makeServiceCall();
		return null;
	}

	public interface OnResult {

		void onSuccess(String result);

		void onError(String error);
	}
	String reqURL;
	OnResult callback;
	public void makeServiceCall() {
		String response = null;
		try {
			URL url = new URL(reqURL);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			//read the response
			InputStream in = new BufferedInputStream(urlConnection.getInputStream());
			response = convertStreamToString(in);
			callback.onSuccess(response);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			callback.onError(e+"");
		} catch (ProtocolException e) {
			e.printStackTrace();
			callback.onError(e+"");
		} catch (IOException e) {
			e.printStackTrace();
			callback.onError(e+"");
		}
	}

	public String convertStreamToString(InputStream in) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line).append('\n');
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return stringBuilder.toString();
	}
}
