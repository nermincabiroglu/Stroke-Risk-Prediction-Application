package com.example.nmetahmini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Main2Activity extends AppCompatActivity {
    public static float cinsiyet;
    ImageButton erkek;
    ImageButton kadin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        erkek = findViewById(R.id.erkek);
        kadin = findViewById(R.id.kadin);
        erkek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cinsiyet = 1;
                Intent sayfa = new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(sayfa);
                finishActivity(0);
            }
        });
        kadin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cinsiyet = 0;
                Intent sayfa = new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(sayfa);
                finishActivity(0);
            }
        });

    }
}
