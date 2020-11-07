package com.example.nmetahmini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import static com.example.nmetahmini.Main2Activity.cinsiyet;
import static com.example.nmetahmini.Main3Activity.boy1;
import static com.example.nmetahmini.Main3Activity.evlilik1;
import static com.example.nmetahmini.Main3Activity.glikoz1;
import static com.example.nmetahmini.Main3Activity.kalp1;
import static com.example.nmetahmini.Main3Activity.kilo1;
import static com.example.nmetahmini.Main3Activity.tansiyon1;
import static com.example.nmetahmini.Main3Activity.yas1;
import static com.example.nmetahmini.Main4Activity.calisma;
import static com.example.nmetahmini.Main4Activity.sigara;
import static com.example.nmetahmini.Main4Activity.yasayis;



public class Main5Activity extends AppCompatActivity {
    TextView sonuc;
    ImageView sonLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        sonuc = findViewById(R.id.sonuc);
        sonLogo = findViewById(R.id.sonLogo);
        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
        Python py = Python.getInstance();
        PyObject objModule = py.getModule("test");
        PyObject obj2 = objModule.callAttr("prediction",cinsiyet,yas1,tansiyon1,kalp1,evlilik1,calisma,yasayis,glikoz1,sigara,boy1,kilo1);
        int res = Integer.parseInt(obj2.toString());
        if (res==1){
            sonuc.setText("Risk Grubundasınız");
            sonuc.setTextColor(Color.RED);
            sonLogo.setImageResource(R.drawable.cancel1);
        } else if (res==0){
            sonuc.setText("Risk Grubunda Değilsiniz");
            sonuc.setTextColor(Color.BLUE);
            sonLogo.setImageResource(R.drawable.bluetick);
        }
    }
}
