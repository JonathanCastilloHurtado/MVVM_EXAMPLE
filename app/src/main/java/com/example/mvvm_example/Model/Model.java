package com.example.mvvm_example.Model;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Model extends AsyncTask<Object, String, NetworkResponse> {

    private String reqURL;
    private final String urlEndpoint = "personal/get_book.php";
    private OnResult callback;

    @Override
    protected NetworkResponse doInBackground(Object... objects) {
        reqURL = objects[0].toString() + urlEndpoint;
        callback = (OnResult) objects[1];

        return makeServiceCall();
    }

    @Override
    protected void onPostExecute(NetworkResponse response) {
        super.onPostExecute(response);
        if (response != null && response.isSuccess()) {
            if (callback != null) {
                callback.onSuccess(response.getMessage());
            }
        } else {
            if (callback != null) {
                callback.onError(response.getException());
            }
        }
    }

    public NetworkResponse makeServiceCall() {
        NetworkResponse response = new NetworkResponse();
        try {
            URL url = new URL(reqURL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
                response.setException(e);
                response.setSuccess(false);
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    response.setException(e);
                    response.setSuccess(false);
                }
            }
            response.setSuccess(true);
            response.setMessage(stringBuilder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setException(e);
        } catch (ProtocolException e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setException(e);
        } catch (IOException e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setException(e);
        }
        return response;
    }

    public interface OnResult {
        void onSuccess(String result);
        void onError(Exception error);
    }
}
