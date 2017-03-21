package com.example.vitor.reserterre;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.voliveira.reserterre.R.id.bt_launch_activity;
import static com.example.voliveira.reserterre.R.id.input_password;
import static com.example.voliveira.reserterre.R.id.input_user;
import static com.example.voliveira.reserterre.R.layout.layout_login_activity;

public class login_activity extends AppCompatActivity {

    private Button buttonCo;
    private EditText inputUser;
    private EditText inputPassword;
    public ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout_login_activity);

        buttonCo = (Button) findViewById(bt_launch_activity);
        inputUser = (EditText) findViewById(input_user);
        inputPassword = (EditText) findViewById(input_password);


        buttonCo.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {

                int usersize = inputUser.getText().length();

                int passsize = inputPassword.getText().length();
                // si les deux champs sont remplis
                if (usersize > 0 && passsize > 0)
                {

                   // progressDialog.show();

                    String user = inputUser.getText().toString();

                    String pass = inputPassword.getText().toString();
                    // On appelle la fonction doLogin qui va communiquer avec le PHP
                    Log.d("KAPPA","avant dologin");

                    doLogin(user, pass);

                }
                else
                    createDialog("Error", "Please enter Username and Password");

            }

        });
    }







    private void createDialog(String title, String text)
    {
        // Création d'une popup affichant un message
        AlertDialog ad = new AlertDialog.Builder(this)
                .setPositiveButton("Ok", null).setTitle(title).setMessage(text)
                .create();
        ad.show();

    }

    private void doLogin(final String login, final String pw) {
        Log.d("KAPPA","debut dologin");


        // Création d'un thread
        threadBD t = new threadBD();
        Log.d("KAPPA","thread cree");
        t.start();

    }
}
    /*    String result = "";
        URLConnection yc = null;
        URL yahoo = null;
        BufferedReader in = null;
        try {
            yahoo = new URL("http://localhost/Reserterre/getNomGymnaseDiderot.php");
            yc = yahoo.openConnection();
            in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = in.readLine()) != null) {
                sb.append(line + "\n");
            }
            in.close();
            result=sb.toString();
        } catch (IOException e) {
            Log.e("log_tag", "Error converting result "+e.toString());
        }
        try{
            JSONArray jArray = new JSONArray(result);
            for(int i=0;i<jArray.length();i++){
                JSONObject json_data = jArray.getJSONObject(i);
                Log.i("log_tag","nom: "+json_data.getInt("nom_gymnase")+
                        ", adresse: "+json_data.getString("adresse")+
                        ", equipements: "+json_data.getInt("equipements")
                );
            }
        }catch(JSONException e){
            Log.e("log_tag", "Error parsing data "+e.toString());
        }
        InputStream is = null;
        try {
            String host = "http://localhost/Reserterre/getNomGymnaseDiderot.php";
            Socket socket = new Socket(host, 80);
            String request = "GET / HTTP/1.0\r\n\r\n";
            OutputStream os = socket.getOutputStream();
            os.write(request.getBytes());
            os.flush();
            is = socket.getInputStream();
            int ch;
            while( (ch=is.read())!= -1)
                System.out.print((char)ch);
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
     }
        final TextView mTextView = (TextView) findViewById(R.id.text);
// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }*/