package com.example.claudiofuentes.mipromedio;

import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Configuracion extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_configuracion);
        addPreferencesFromResource(R.xml.preferencias);
    }
}
