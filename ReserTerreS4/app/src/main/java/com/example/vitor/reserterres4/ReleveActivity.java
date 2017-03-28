package com.example.vitor.reserterres4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import static android.R.attr.type;

public class ReleveActivity extends AppCompatActivity {
    private Button bouton_retour;
    private Button bouton_valider;
    private Button bouton_signature;
    private TextView date;
    private TextView gymnase;
    private TextView association;
    private TextView creneau;
    private EditText effectifH;
    private EditText effectifF;
    private EditText observation;
    private RadioButton ras, mineur, majeur;
    private CheckBox retard;
    private String[] infos;
    private String gym;
    private String idAgent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_releve);
        Log.i("GYMERINO", "start");

        Bundle p = getIntent().getExtras();
        idAgent= p.getString("idagent");
        gym= p.getString("gymnase");

        //gym= (String) savedInstanceState.getSerializable("gymnase");
        String type = "selectInfos";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        try {
            String res = backgroundWorker.execute(type,gym).get();
            infos = res.split(",");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        bouton_valider = (Button) findViewById(R.id.button_envoyer);
        bouton_signature = (Button) findViewById(R.id.button_signature);
        bouton_retour = (Button) findViewById(R.id.button_retour);
        date = (TextView) findViewById(R.id.date);
        gymnase = (TextView) findViewById(R.id.nom_gymnase);
        association = (TextView) findViewById(R.id.association);
        creneau = (TextView) findViewById(R.id.creneau);


        effectifF = (EditText) findViewById(R.id.effFemme);
        effectifH = (EditText) findViewById(R.id.effHomme);
        observation = (EditText) findViewById(R.id.input_observation);



        ras = (RadioButton) findViewById(R.id.radioButton_ras);
        mineur = (RadioButton) findViewById(R.id.radioButton_mineur);
        majeur = (RadioButton) findViewById(R.id.radioButton_majeur);

        retard = (CheckBox) findViewById(R.id.retard);
        fillFields();

        bouton_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
            }
        });




        bouton_signature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReleveActivity.this, CaptureSignature.class));

            }
        });

        bouton_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReleveActivity.this, SelectActivity.class);
                intent.putExtra("idagent", idAgent);
                startActivity(intent);
                finish();
            }
        });
    }


    public void fillFields(){
        //remplir formulaire avec BD
        String dateStr = "";
        String gymnaseStr = "";
        String associationStr = "";
        String creneauStr = "";

        // attribuer valeur au string /!\ date format special

        gymnaseStr=gym;
        dateStr=infos[0]+"\n"+infos[1];
        associationStr=infos[2];
        creneauStr=infos[3];

        //remplir form

        date.setText(dateStr);
        gymnase.setText(gymnaseStr);
        association.setText(associationStr);
        creneau.setText(creneauStr);

    }


    public void validation(){
        View focusView = null;
        boolean invalidData= false;

        effectifF.setError(null);
        effectifH.setError(null);
        observation.setError(null);

        String effH, effF, observationStr;
        effF = effectifF.getText().toString();
        effH = effectifH.getText().toString();

        String retardStr="";
        observationStr = observation.getText().toString();
        if(retard.isChecked()){
            retardStr="true";
        }
        else{
            retardStr="false";
        }
        String lvl;

        if(ras.isChecked()){
            lvl=ras.getText().toString();
        }else if(mineur.isChecked()){
            lvl=mineur.getText().toString();
        }else{
            lvl=majeur.getText().toString();
        }

        //verifier les champs requis

        if(TextUtils.isEmpty(effH)){
            effectifH.setError(getString(R.string.field_required));
            focusView = effectifH;
            invalidData=true;

        }
        if(TextUtils.isEmpty(effF)){
            effectifF.setError(getString(R.string.field_required));
            focusView = effectifF;
            invalidData=true;
        }
        if( (lvl.equals("Majeur") || lvl.equals("Mineur")) &&  TextUtils.isEmpty(observationStr)){
            observation.setError(getString(R.string.observation_required));
            focusView = observation;
            invalidData=true;
        }



        //verif donnees des champ


        if (invalidData) {
            // error in data
            focusView.requestFocus();
        } else {
            int nbH, nbF,nbInscrit;
            nbH = Integer.parseInt(effH);
            nbF = Integer.parseInt(effF);
            nbInscrit =Integer.parseInt(infos[4].substring(0,infos[4].length()-1));

            if(nbF+nbH>nbInscrit){
                //envoyer mail
            }
            if(lvl.equals("Majeur")){
                //envoyer mail
            }

            //inserer dans la bd
            background(effH,effF,lvl,retardStr,observationStr);

            //changer d'activite
            startActivity(new Intent(ReleveActivity.this, SelectActivity.class));

            //detruire l'activite
            finish();
        }
    }

    public void background(String effH,String effF,String lvl,String retard,String obs) {
        String type ="fillDb";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        try {
            String res = backgroundWorker.execute(type, effH, effF, lvl, retard, obs,idAgent,gym).get();
            Log.i("KEK", res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}