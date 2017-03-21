package com.example.vitor.reserterre;

import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by vitor on 16/03/2017.
 */

public class threadBD extends Thread {

    private String nom = "";

    private void createDialog(String title, String text) {
       /* // Création d'une popup affichant un message
        AlertDialog ad = new AlertDialog.Builder(this)
                .setPositiveButton("Ok", null).setTitle(title).setMessage(text)
                .create();
        ad.show();
*/
    }


    public void run() {

        Log.d("KAPPA", "debut thread");

        Looper.prepare();
        // On se connecte au serveur afin de communiquer avec le PHP
        OkHttpClient client = new OkHttpClient();

        Response response = null;

        try {
            Request request = new Request.Builder()
                    .url("http://172.20.10.5/Reserterre/getNomGymnaseDiderot.php?nom_agent=lamy")
                    .build();
            response = client.newCall(request).execute();
            InputStreamReader in = new InputStreamReader(response.body().byteStream());
            BufferedReader rd = new BufferedReader(in);

            StringBuilder response1 = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response1.append(line);
                response1.append('\r');
            }
            rd.close();
             Log.d("KAppA",response.toString());
          /*  JSONArray jArray = new JSONArray(response);
            Log.d("lol",""+response);
            JSONObject json_data = jArray.getJSONObject(0);
            nom=""+json_data.getString("nom_agent");
            } catch (Exception e) {
                createDialog("Error", "Couldn't establish a connection");
            }
            Log.d("AGENT",""+nom);*/
            Looper.loop();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/*
        OkHttpClient client = new OkHttpClient();


        Request request = new Request.Builder()
                .url("http://www.google.fr")
                .build();
        Log.i("REQUEST", String.valueOf(request));
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Log.i("RESPONSE", response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }*/