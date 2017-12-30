package com.example.claudiofuentes.mipromedio;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculador extends AppCompatActivity {

    Button calcular;
    double porcNota[]=new double[10];
    double porc[]=new double[10];
    double nota[]=new double[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculador);
        calcular = (Button) findViewById(R.id.btnCalcular);


        calcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                calcularPromedio();
            }
        });
    }
    private void calcularPromedio(){
        //if (nota[1] !=  0   && porc[1] != 0)
        {
            for (int i  =   0;i<10;i++){
                if (nota[i] != 0 && porc[i]!= 0){

                    porcNota[i]=(porc[i]/100)*nota[i];
                }
                else{
                    porcNota[i]=0;
                }
            }
            asignacionVariables(true);
        }
        /*else
        {
            Toast.makeText(getApplicationContext(),"debe ingresar por lo menos una nota",Toast.LENGTH_LONG).show();
        }
        */


    }

    private  void asignacionVariables(boolean inversa){
        if (inversa){
            TextView textView=(TextView)findViewById(R.id.lblPromedio1);
            textView.setText(""+porcNota[1]);
            textView=(TextView)findViewById(R.id.lblPromedio2);
            textView.setText(""+porcNota[2]);
            textView=(TextView)findViewById(R.id.lblPromedio3);
            textView.setText(""+porcNota[3]);
            textView=(TextView)findViewById(R.id.lblPromedio4);
            textView.setText(""+porcNota[4]);
            /*textView=(TextView)findViewById(R.id.lblPromedio5);
            textView.setText(""+porcNota[5]);
            textView=(TextView)findViewById(R.id.lblPromedio6);
            textView.setText(""+porcNota[6]);
            textView=(TextView)findViewById(R.id.lblPromedio7);
            textView.setText(""+porcNota[7]);
            textView=(TextView)findViewById(R.id.lblPromedio8);
            textView.setText(""+porcNota[8]);
            textView=(TextView)findViewById(R.id.lblPromedio9);
            textView.setText(""+porcNota[9]);
            textView=(TextView)findViewById(R.id.lblPromedio10);
            textView.setText(""+porcNota[10]);
            */
        }
    }

    private void asignacionVariables(){
        EditText texto=(EditText) findViewById(R.id.txtNota1);
        nota[1] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtNota2);
        nota[2] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtNota3);
        nota[3] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtNota4);
        nota[4] = Double.parseDouble(texto.getText().toString());
       /*
        texto=(EditText) findViewById(R.id.txtNota5);
        nota[5] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtNota6);
        nota[6] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtNota7);
        nota[7] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtNota8);
        nota[8] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtNota9);
        nota[9] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtNota10);
        nota[10] = Double.parseDouble(texto.getText().toString());
        */


        texto=(EditText) findViewById(R.id.txtPorc1);
        porc[1] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtPorc2);
        porc[2] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtPorc3);
        porc[3] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtPorc4);
        porc[4] = Double.parseDouble(texto.getText().toString());
        /*
        texto=(EditText) findViewById(R.id.txtPorc5);
        porc[5] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtPorc6);
        porc[6] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtPorc7);
        porc[7] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtPorc8);
        porc[8] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtPorc9);
        porc[9] = Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtPorc10);
        porc[10] = Double.parseDouble(texto.getText().toString());
        */
    }
}
