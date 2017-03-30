package com.example.vitor.reserterres4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    EditText user,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        user = (EditText) findViewById(R.id.editText);
        pwd = (EditText) findViewById(R.id.editText2);
    }
    public void OnLogin(View view) throws ExecutionException, InterruptedException {
        user.setError(null);
        pwd.setError(null);
        String username = user.getText().toString();
        String password = pwd.getText().toString();
        boolean cancelLogin = false;
        View focusView = null;
        if (TextUtils.isEmpty(password)) {
            // Log.d("DEBUGLOG", "pwd incorrect");
            pwd.setError(getString(R.string.field_required));
            focusView = pwd;
            cancelLogin = true;
        }
        if (TextUtils.isEmpty(username)) {
            // Log.d("DEBUGLOG", "user incorrect");
            user.setError(getString(R.string.field_required));
            focusView = user;
            cancelLogin = true;
        }
        if (cancelLogin) {
            // error in login
            focusView.requestFocus();
        } else {
            String type = "login";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            String res = backgroundWorker.execute(type, username, password).get();
            String[] result = res.split(",");
            Log.d("LOGIEEEE",res);
            if(result[0].equals("true")){
                Intent intent = new Intent(MainActivity.this, SelectActivity.class);
                intent.putExtra("idagent", result[1]);
                startActivity(intent);
                finish();
            }
            else if(result[0].equals("false")){
                pwd.setError(getString(R.string.errorConnexion));
                focusView = pwd;
               // focusView = user;
                cancelLogin = true;
                focusView.requestFocus();
                pwd.setText("");
                user.setText("");
            }
            else{
               AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Horaire :");
                alertDialog.setMessage("L'application est fermée. Revenez entre 19h et 23h.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                System.exit(0);
                            }
                        });
                alertDialog.show();
                 /*
                Toast toast = Toast.makeText(this, "Revenez entre 19h et 23h.", Toast.LENGTH_SHORT);
                toast.show();*/
            }
        }
    }
}
