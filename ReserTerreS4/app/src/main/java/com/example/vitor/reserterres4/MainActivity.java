package com.example.vitor.reserterres4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    EditText user,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            else{
                pwd.setError(getString(R.string.errorConnexion));
                focusView = pwd;
                cancelLogin = true;
                focusView.requestFocus();
                pwd.setText("");

            }
        }
    }
}
