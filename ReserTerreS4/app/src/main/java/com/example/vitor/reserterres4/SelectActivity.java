package com.example.vitor.reserterres4;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 * Created by vitor on 23/03/2017.
 */

public class SelectActivity extends AppCompatActivity {
    private LinearLayout liste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        liste = (LinearLayout) findViewById(R.id.container);
        String res="";
        String res2="";
        ArrayList<String> lesEquipementsRemplis;// = new ArrayList<String>();
        ArrayList<String> lesEquipementsNonRemplis;// = new ArrayList<String>();

        //donnee de test (a supprimer)
      /*  lesEquipementsRemplis.add("jean moulin");
        lesEquipementsRemplis.add("complexe sportif machin truc terrain de foot");
        lesEquipementsRemplis.add("complexe sportif machin truc terrain multisport");
        lesEquipementsRemplis.add("judo intel truc patata");

        lesEquipementsNonRemplis.add("gymnase 1");
        lesEquipementsNonRemplis.add("gymnase 2");
        lesEquipementsNonRemplis.add("gymnase 3");
        lesEquipementsNonRemplis.add("gymnase 4");
        lesEquipementsNonRemplis.add("gymnase 5");
        lesEquipementsNonRemplis.add("gymnase 6");
        lesEquipementsNonRemplis.add("gymnase 7");
        lesEquipementsNonRemplis.add("gymnase 8");
        lesEquipementsNonRemplis.add("gymnase 9");
        lesEquipementsNonRemplis.add("gymnase 10");
        lesEquipementsNonRemplis.add("gymnase 11");
        lesEquipementsNonRemplis.add("gymnase 12");*/


        // recuperer la liste des equipements dans un arrayList
        String type = "selectGymnaseNonRemplis";
        String type2 = "selectGymnaseRemplis";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        BackgroundWorker backgroundWorker2 = new BackgroundWorker(this);
        try {
            res = backgroundWorker.execute(type).get();
            res2 = backgroundWorker2.execute(type2).get();
            if(!res.equals(" ") || !res2.equals(" ")){
                lesEquipementsNonRemplis = new ArrayList<>(Arrays.asList(res.split(",")));
                lesEquipementsNonRemplis.remove(lesEquipementsNonRemplis.size() - 1);
                for (final String e : lesEquipementsNonRemplis) {
                    final Button b = new Button(this);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.setMargins(0, 5, 0, 5);
                    b.setLayoutParams(params);
                    b.setText(e);
                    b.setBackgroundColor(ContextCompat.getColor(this, R.color.rouge));
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            selection(e);
                        }
                    });
                    liste.addView(b);
                }
                lesEquipementsRemplis = new ArrayList<>(Arrays.asList(res2.split(",")));
                lesEquipementsRemplis.remove(lesEquipementsRemplis.size()-1);
                for (final String e : lesEquipementsRemplis) {
                    final TextView b = new TextView(this);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.setMargins(0, 5, 0, 5);
                    b.setPadding(0, 25, 0, 25);
                    b.setLayoutParams(params);
                    b.setGravity(Gravity.CENTER);
                    b.setAllCaps(true);
                    b.setText(e);
                    b.setTextSize(14);
                    b.setBackgroundColor(ContextCompat.getColor(this, R.color.vert));
                    // b.setEnabled(false);
                    b.setTypeface(null, Typeface.BOLD);
                    liste.addView(b);
                }
            }
            else{
                final TextView b = new TextView(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(0, 5, 0, 5);
                b.setPadding(0, 25, 0, 25);
                b.setLayoutParams(params);
                b.setGravity(Gravity.CENTER);
                b.setAllCaps(true);
                b.setText("Aucun gymnase n'est reservé pour ce creaneau");
                b.setTextSize(14);
                b.setBackgroundColor(ContextCompat.getColor(this, R.color.blanc));
                // b.setEnabled(false);
                b.setTypeface(null, Typeface.BOLD);
                liste.addView(b);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public void selection(String gymnase){
        Bundle p = getIntent().getExtras();
        String idAgent= p.getString("idagent");
        // trouver un moyen de passser le gymnase a la vue suivante
        Intent intent = new Intent(this, ReleveActivity.class);
        intent.putExtra("gymnase", gymnase);
        intent.putExtra("idagent", idAgent);
        startActivity(intent);
        finish();
    }
}