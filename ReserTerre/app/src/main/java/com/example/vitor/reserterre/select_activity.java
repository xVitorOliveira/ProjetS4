package com.example.vitor.reserterre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.voliveira.reserterre.R;

import java.util.ArrayList;

public class select_activity extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_select_activity);

       /* bdManager = new BDmanager();

        ArrayList <Gymnases> gymnases=bdManager.getlistGymnases();

        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);

        for(int i=0;i<gymnases.size();i++) {
            Button btnTag = new Button(this);
            btnTag.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            btnTag.setText(gymnases.get(i).getNom());
            btnTag.setId(i);
            linearLayout1.addView(btnTag);
            btnTag.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                }
            });
        }*/
    }

}
