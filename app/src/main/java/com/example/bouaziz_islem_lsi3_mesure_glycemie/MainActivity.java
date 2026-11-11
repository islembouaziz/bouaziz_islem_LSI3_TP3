package com.example.bouaziz_islem_lsi3_mesure_glycemie;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnConsulter;

    private TextView msg;

    private SeekBar sbAge;
    private RadioButton rboui,rbnon;
    private EditText etValeur;
    private TextView textAge;
    private int age=0;
    private void init(){
        btnConsulter=findViewById(R.id.btnConsulter);
        msg=findViewById(R.id.msg);
        sbAge=findViewById(R.id.sbAge);
        rbnon=findViewById(R.id.rbnon);
        rboui=findViewById(R.id.rboui);
        etValeur=findViewById(R.id.etValeur);
        textAge=findViewById(R.id.textAge);



    }
    private void consulterGlycemie(){
        String valeurstring = etValeur.getText().toString().trim();
        if(valeurstring.isEmpty()){
            Toast.makeText(this, "veulliez entre le valeur mesuree", Toast.LENGTH_SHORT).show();
            return;
        }
        double valeur = Double.parseDouble(valeurstring);
        boolean aJeune = rboui.isChecked();
        String resultat;
        double min,max;
        if(aJeune){
            if(age>13){
                min=5.0;
                max=7.2;

            } else if (age>=6) {
                min= 5.0;
                max=10.0;


            }
            else{
                min =5.5;
                max=10.0;

            }
        }else {
            min=0.0;
            max=10.5;
        }
        if (valeur < min) {

            resultat ="le niveau de glycemie est trop bas";

        } else if (valeur>max) {
            resultat="le niveau de glycemie est trop eleve";

        }else{
            resultat="le niveau de glycemie est normal ";
        }
        msg.setText(resultat);

    }


    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_main);
      init();
      sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
              Log.i("Information","onProgressChanged"+progress);
              textAge.setText("Votre age:"+progress+"ans");

          }

          @Override
          public void onStartTrackingTouch(SeekBar seekBar) {

          }

          @Override
          public void onStopTrackingTouch(SeekBar seekBar) {

          }

      });

       btnConsulter.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View view){
             consulterGlycemie();
            }
        });
}


    public void calculer(View view){
        Toast.makeText(this,"le bouton consulter a ete clique", Toast.LENGTH_SHORT).show();
    }}
