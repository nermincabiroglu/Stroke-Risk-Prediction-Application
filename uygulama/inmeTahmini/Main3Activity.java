package com.example.nmetahmini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Main3Activity extends AppCompatActivity {
    EditText yas;
    EditText kilo;
    EditText boy;
    EditText glikoz;
    RadioButton tansiyon;
    RadioButton kalp;
    RadioButton evlilik;
    Button button;
    public static float yas1,kilo1,boy1,glikoz1,tansiyon1,kalp1,evlilik1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        yas = findViewById(R.id.yas);
        kilo = findViewById(R.id.kilo);
        boy = findViewById(R.id.boy);
        glikoz = findViewById(R.id.glikoz);
        tansiyon = findViewById(R.id.tansiyon);
        kalp = findViewById(R.id.kalp);
        evlilik = findViewById(R.id.evlilik);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yas1 = Float.parseFloat(yas.getText().toString());
                kilo1 = Float.parseFloat(kilo.getText().toString());
                boy1 = Float.parseFloat(boy.getText().toString());
                glikoz1 = Float.parseFloat(glikoz.getText().toString());
                tansiyon1 = 0;
                kalp1 = 0;
                evlilik1 = 0;
                if(tansiyon.isChecked()){
                    tansiyon1 = 1;
                }
                if (kalp.isChecked()){
                    kalp1 = 1;
                }
                if (evlilik.isChecked()){
                    evlilik1 = 1;
                }
                Intent sayfa = new Intent(getApplicationContext(),Main4Activity.class);
                startActivity(sayfa);
                finishActivity(0);

            }
        });
    }
}
