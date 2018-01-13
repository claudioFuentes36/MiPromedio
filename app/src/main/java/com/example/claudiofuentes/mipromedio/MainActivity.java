package com.example.claudiofuentes.mipromedio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button botonAcceso;
    ImageButton imagenInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referencia al botón mediante la carpeta Recursos (R), id (no visible en carpeta).
        botonAcceso = (Button) findViewById(R.id.btnAcceso);
        imagenInfo  = (ImageButton)findViewById(R.id.logoCorporativo);

        //Agregar un listener, es decir la accion.
        botonAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //es un intento de acceso, es como un link, un hiperVinculo
                //Parametros de ingreso, donde estoy, hacia donde voy.
                Intent pantalla =   new Intent(MainActivity.this,Calculador.class);
                //ejecutar la actividad recien creada
                startActivity(pantalla);
                //finalizar la actividad actual para reducir consumo.
                //finish();
            }
        });

        imagenInfo.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vistaInfo = new Intent(MainActivity.this,Calculador.class);

                startActivity(vistaInfo);
            }
        }));
    }
}
