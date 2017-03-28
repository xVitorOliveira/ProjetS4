package com.example.vitor.reserterres4;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by vitor on 22/03/2017.
 */

public class BackgroundWorker extends AsyncTask <String, Void, String> {
    Context context;
    AlertDialog alertDialog;
    String type = "";
    BackgroundWorker(Context ctx){
        context=ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        type = params[0];
        String ip ="192.168.43.221";
        String tUrl ="";
        String post_data ="";
        switch ( type ) {

            case "login" :
                tUrl ="http://"+ip+"/API/login.php";
                String user = params[1];
                String password = params[2];
                try {
                    post_data = URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(user, "UTF-8")+"&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;

            case "selectGymnaseNonRemplis" :
                tUrl ="http://"+ip+"/API/listEquipementsGymnase.php";
                break;

            case "selectGymnaseRemplis" :
                tUrl ="http://"+ip+"/API/listGymnase.php";
                break;
            case "releve" :
                tUrl ="http://"+ip+"/API/releve.php";
                break;

            case "selectInfos" :
                tUrl ="http://"+ip+"/API/selectInfo.php";
                String gym = params[1];
                try {
                    post_data = URLEncoder.encode("gym","UTF-8")+"="+URLEncoder.encode(gym, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;

            case "fillDb" :
                tUrl ="http://"+ip+"/API/insertInfo.php";
                String effF = params[2];
                String effH = params[1];
                String lvl = params[3];
                String retardStr = params[4];
                String observationStr = params[5];
                String idAgent = params[6];
                String gyms = params[7];
                try {
                    post_data = URLEncoder.encode("effF","UTF-8")+"="+URLEncoder.encode(effF, "UTF-8")+"&"+URLEncoder.encode("effH","UTF-8")+"="+URLEncoder.encode(effH, "UTF-8")+"&"+URLEncoder.encode("lvl","UTF-8")+"="+URLEncoder.encode(lvl, "UTF-8")+"&"+URLEncoder.encode("retard","UTF-8")+"="+URLEncoder.encode(retardStr, "UTF-8")+"&"+URLEncoder.encode("obs","UTF-8")+"="+URLEncoder.encode(observationStr, "UTF-8")+"&"+URLEncoder.encode("idAgent","UTF-8")+"="+URLEncoder.encode(idAgent, "UTF-8")+"&"+URLEncoder.encode("gyms","UTF-8")+"="+URLEncoder.encode(gyms, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;

            default :
                Log.i("Erreur du traitre", "fgggt");
                break;
        }
        try {
            URL url = new URL(tUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="";
            String line;
            while((line = bufferedReader.readLine())!=null){
                result+=line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            Log.d("LOGI",result);
            return  result;
        } catch (MalformedURLException e) {
                e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPreExecute(){
    }

    protected void onPostExecute(String result){
    }

    protected void onProgressUpdate(Void... values){
        super.onProgressUpdate();
    }
}
