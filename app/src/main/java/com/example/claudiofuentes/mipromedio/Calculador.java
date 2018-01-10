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
        asignacionVariables();

            for (int i  = 0;i<10;i++){
                if (nota[i] != 0 && porc[i]!= 0){

                    porcNota[i]=(porc[i]/100)*nota[i];
                }
                else{
                    porcNota[i]=0;
                    //Toast.makeText(getApplicationContext(),""+nota[i],Toast.LENGTH_LONG).show();
                }
            }
            asignacionVariables(true);

            calcularNotaRequerida(calcularBruto());






    }

    private  void asignacionVariables(boolean inversa){
        if (inversa){
            TextView textView=(TextView)findViewById(R.id.lblPromedio1);
            textView.setText(""+porcNota[0]);
            textView=(TextView)findViewById(R.id.lblPromedio2);
            textView.setText(""+porcNota[1]);
            textView=(TextView)findViewById(R.id.lblPromedio3);
            textView.setText(""+porcNota[2]);
            textView=(TextView)findViewById(R.id.lblPromedio4);
            textView.setText(""+porcNota[3]);
            textView=(TextView)findViewById(R.id.lblPromedio5);
            textView.setText(""+porcNota[4]);
            textView=(TextView)findViewById(R.id.lblPromedio6);
            textView.setText(""+porcNota[5]);
            textView=(TextView)findViewById(R.id.lblPromedio7);
            textView.setText(""+porcNota[6]);
            textView=(TextView)findViewById(R.id.lblPromedio8);
            textView.setText(""+porcNota[7]);
            textView=(TextView)findViewById(R.id.lblPromedio9);
            textView.setText(""+porcNota[8]);
            textView=(TextView)findViewById(R.id.lblPromedio10);
            textView.setText(""+porcNota[9]);

        }
    }

    private void asignacionVariables(){

        EditText texto = (EditText) findViewById(R.id.txtNota1);
        //if (!texto.getText().equals("")){nota[0] = Double.parseDouble(texto.getText().toString());}else{nota[0]=0;}
        nota[0]=Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtNota2);
        if (!texto.getText().equals("")){nota[1] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota3);
        if (!texto.getText().equals("")){nota[2] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota4);
        if (!texto.getText().equals("")){nota[3] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota5);
        if (!texto.getText().equals("")){nota[4] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota6);
        if (!texto.getText().equals("")){nota[5] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota7);
        if (!texto.getText().equals("")){nota[6] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota8);
        if (!texto.getText().equals("")){nota[7] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota9);
        if (!texto.getText().equals("")){nota[8] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota10);
        if (!texto.getText().equals("")){nota[9] = Double.parseDouble(texto.getText().toString());}



        texto=(EditText) findViewById(R.id.txtPorc1);
        if (!texto.getText().equals("")){porc[0] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc2);
        if (!texto.getText().equals("")){porc[1] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc3);
        if (!texto.getText().equals("")){porc[2] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc4);
        if (!texto.getText().equals("")){porc[3] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc5);
        if (!texto.getText().equals("")){porc[4] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc6);
        if (!texto.getText().equals("")){porc[5] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc7);
        if (!texto.getText().equals("")){porc[6] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc8);
        if (!texto.getText().equals("")){porc[7] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc9);
        if (!texto.getText().equals("")){porc[8] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc10);
        if (!texto.getText().equals("")){porc[9] = Double.parseDouble(texto.getText().toString());}
    }
    private double calcularBruto(){
        //EditText texto = (EditText) findViewById(R.id.txtNota1);
        //nota[0] = Double.parseDouble(texto.getText().toString());
        double total = 0;
        for (int i =0;i<10;i++){
            total=total + nota[i];
        }
       TextView txt=(TextView)findViewById(R.id.notaBruto);
        txt.setText(""+total);
        return total;
    }
    private void calcularNotaRequerida(double bruto){
        double descontado   =   bruto*0.6;
        double prenecesario =   4-descontado;
        double necesario    =   ((prenecesario/4)*10);
        if (necesario>=1 && necesario<=7){
            Toast.makeText(getApplicationContext(),"Aún te falta para pasar el año",Toast.LENGTH_LONG).show();
        }
        else if(necesario<1){
            Toast.makeText(getApplicationContext(),"Felicidades pasaste el año",Toast.LENGTH_LONG).show();
        }
        else if(necesario>7){
            Toast.makeText(getApplicationContext(),"Mejor suerte el próximo año, no haz pasado",Toast.LENGTH_LONG).show();
        }
        TextView txt=(TextView)findViewById(R.id.necEnExamen);
        txt.setText(""+necesario);
    }
}
