package com.example.claudiofuentes.mipromedio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button botonAcceso;
    ImageButton imagenInfo;
    Button auxiliar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referencia al botón mediante la carpeta Recursos (R), id (no visible en carpeta).
        botonAcceso = (Button) findViewById(R.id.btnAcceso);
        imagenInfo  = (ImageButton)findViewById(R.id.logoCorporativo);
        auxiliar    = (Button)findViewById(R.id.botonAuxiliar);

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
                Intent vistaInfo = new Intent(MainActivity.this,Informacion.class);

                startActivity(vistaInfo);
            }
        }));
        auxiliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accederContacto();
            }
        });

    }
   @Override
    public boolean onCreateOptionsMenu(Menu menu){
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.configuracion,menu);
       return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_config:
                accederConfiguracion();
                return true;
           // case R.id.action_contacto:
             //   accederContacto();
               // return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void accederConfiguracion(){
        Intent config =   new Intent(MainActivity.this,Configuracion.class);
        //ejecutar la actividad recien creada
        startActivity(config);
    }
    public void accederContacto(){
        Intent contact = new Intent(MainActivity.this,Contacto.class);
        startActivity(contact);
    }
}
