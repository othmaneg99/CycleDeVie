package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.myapplication.MainActivity.CYCLEVIEPREFS;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        popUp("onCreate()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        popUp("onRestart()");
    }
    protected void onStart() {
        super.onStart();
        popUp("onStart()");
        SharedPreferences settings = getSharedPreferences(CYCLEVIEPREFS, Context.MODE_PRIVATE);

        final TextView txtView = (TextView) findViewById(R.id.textView1);
        txtView.setText(settings.getString("cle", ""));
    // 2 eme méthode
      Intent intent = getIntent();
        String v= "" ;
        if (intent != null)   v=intent.getStringExtra("clé")+" methode 2" ;
        txtView.append(v);
    }
    @Override
    protected void onResume() {
        super.onResume();
        popUp("onResume()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            popUp("onPause, l'utilisateur à demandé la fermeture via un finish()");
        } else {
            popUp("onPause, l'utilisateur n'a pas demandé la fermeture via un finish()");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        popUp("onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        popUp("onDestroy()");
    }
    public void popUp(String message) {



        Toast.makeText(this, message+" Activité 2", Toast.LENGTH_LONG).show();
    }
}