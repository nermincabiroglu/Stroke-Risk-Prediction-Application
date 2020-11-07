package com.example.nmetahmini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Main4Activity extends AppCompatActivity {
    RadioButton kirsal;
    RadioButton kentsel;
    RadioButton cocuk;
    RadioButton politika;
    RadioButton issiz;
    RadioButton ozel;
    RadioButton esnaf;
    RadioButton icmemis;
    RadioButton icen;
    RadioButton birakan;
    Button button;
    public static float yasayis,sigara,calisma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        kirsal = findViewById(R.id.kirsal);
        kentsel = findViewById(R.id.kentsel);
        cocuk = findViewById(R.id.cocuk);
        politika = findViewById(R.id.politika);
        issiz = findViewById(R.id.issiz);
        ozel = findViewById(R.id.ozel);
        esnaf = findViewById(R.id.esnaf);
        icmemis = findViewById(R.id.icmemis);
        icen = findViewById(R.id.icen);
        birakan = findViewById(R.id.birakan);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kirsal.isChecked()){
                    yasayis = 0;
                }
                if (kentsel.isChecked()){
                    yasayis = 1;
                }
                if (cocuk.isChecked()){
                    calisma = 0;
                }
                if (politika.isChecked()){
                    calisma = 1;
                }
                if (issiz.isChecked()){
                    calisma = 2;
                }
                if (ozel.isChecked()){
                    calisma = 3;
                }
                if (esnaf.isChecked()){
                    calisma = 4;
                }
                if (icmemis.isChecked()){
                    sigara = 1;
                }
                if (icen.isChecked()){
                    sigara = 2;
                }
                if (birakan.isChecked()){
                    sigara = 0;
                }
                Intent sayfa = new Intent(getApplicationContext(),Main5Activity.class);
                startActivity(sayfa);
                finishActivity(0);




            }
        });

    }
}
