package com.example.claudiofuentes.mipromedio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculador extends AppCompatActivity {

    Button calcular;
    double nota1;
    double porc1;
    double final1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculador);
        calcular = (Button) findViewById(R.id.btnCalcular);


        calcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                EditText texto=(EditText) findViewById(R.id.txtNota1);
                nota1 = Double.parseDouble(texto.getText().toString());
                EditText  texto2=(EditText)findViewById(R.id.txtPorc1);
                porc1 = Double.parseDouble(texto2.getText().toString());
                final1=(porc1/100)*nota1;
                TextView textView=(TextView)findViewById(R.id.lblPromedio1);
                textView.setText(""+final1);
            }
        });
    }
}
