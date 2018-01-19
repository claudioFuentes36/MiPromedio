package com.example.claudiofuentes.mipromedio;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
    double notaMinima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculador);
        calcular = (Button) findViewById(R.id.btnCalcular);
        nota[0]=1;
        porc[0]=100;
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

        notaMinima = Double.parseDouble(pref.getString("prefNotaMinima","1"));

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
                    nota[i]=nota[i];
                    if (nota[i]>0)
                    {
                        porcNota[i]=((porc[i]/100)*nota[i]);
                    }
                    else
                    {
                        porcNota[i]=notaMinima;
                    }

                }
                else{
                    porcNota[i]=0;
                }
            }
            asignacionVariables(true);

            calcularNotaRequerida(calcularBruto());
            calcularPromedioFinal(calcularBruto());






    }

    private void asignacionVariables(){

        EditText texto = (EditText) findViewById(R.id.txtNota1);
        if (!texto.getText().toString().isEmpty()){nota[0] = Double.parseDouble(texto.getText().toString());}else{nota[0]=1;}
        //nota[0]=Double.parseDouble(texto.getText().toString());
        texto=(EditText) findViewById(R.id.txtNota2);
        if (!texto.getText().toString().isEmpty()){nota[1] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota3);
        if (!texto.getText().toString().isEmpty()){nota[2] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota4);
        if (!texto.getText().toString().isEmpty()){nota[3] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota5);
        if (!texto.getText().toString().isEmpty()){nota[4] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota6);
        if (!texto.getText().toString().isEmpty()){nota[5] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota7);
        if (!texto.getText().toString().isEmpty()){nota[6] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota8);
        if (!texto.getText().toString().isEmpty()){nota[7] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota9);
        if (!texto.getText().toString().isEmpty()){nota[8] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtNota10);
        if (!texto.getText().toString().isEmpty()){nota[9] = Double.parseDouble(texto.getText().toString());}



        texto=(EditText) findViewById(R.id.txtPorc1);
        if (!texto.getText().toString().isEmpty()){porc[0] = Double.parseDouble(texto.getText().toString());}else{porc[0]=100;}
        texto=(EditText) findViewById(R.id.txtPorc2);
        if (!texto.getText().toString().isEmpty()){porc[1] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc3);
        if (!texto.getText().toString().isEmpty()){porc[2] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc4);
        if (!texto.getText().toString().isEmpty()){porc[3] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc5);
        if (!texto.getText().toString().isEmpty()){porc[4] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc6);
        if (!texto.getText().toString().isEmpty()){porc[5] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc7);
        if (!texto.getText().toString().isEmpty()){porc[6] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc8);
        if (!texto.getText().toString().isEmpty()){porc[7] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc9);
        if (!texto.getText().toString().isEmpty()){porc[8] = Double.parseDouble(texto.getText().toString());}
        texto=(EditText) findViewById(R.id.txtPorc10);
        if (!texto.getText().toString().isEmpty()){porc[9] = Double.parseDouble(texto.getText().toString());}
    }

    private  void asignacionVariables(boolean inversa){
        if (inversa){
            TextView textView=(TextView)findViewById(R.id.lblPromedio1);
            textView.setText(""+porcNota[0]);
            if (textView.getText().toString().length()>3){textView.setText(textView.getText().toString().substring(0,3));}
            textView=(TextView)findViewById(R.id.lblPromedio2);
            textView.setText(""+porcNota[1]);
            if (textView.getText().toString().length()>3){textView.setText(textView.getText().toString().substring(0,3));}
            textView=(TextView)findViewById(R.id.lblPromedio3);
            textView.setText(""+porcNota[2]);
            if (textView.getText().toString().length()>3){textView.setText(textView.getText().toString().substring(0,3));}
            textView=(TextView)findViewById(R.id.lblPromedio4);
            textView.setText(""+porcNota[3]);
            if (textView.getText().toString().length()>3){textView.setText(textView.getText().toString().substring(0,3));}
            textView=(TextView)findViewById(R.id.lblPromedio5);
            textView.setText(""+porcNota[4]);
            if (textView.getText().toString().length()>3){textView.setText(textView.getText().toString().substring(0,3));}
            textView=(TextView)findViewById(R.id.lblPromedio6);
            textView.setText(""+porcNota[5]);
            if (textView.getText().toString().length()>3){textView.setText(textView.getText().toString().substring(0,3));}
            textView=(TextView)findViewById(R.id.lblPromedio7);
            textView.setText(""+porcNota[6]);
            if (textView.getText().toString().length()>3){textView.setText(textView.getText().toString().substring(0,3));}
            textView=(TextView)findViewById(R.id.lblPromedio8);
            textView.setText(""+porcNota[7]);
            if (textView.getText().toString().length()>3){textView.setText(textView.getText().toString().substring(0,3));}
            textView=(TextView)findViewById(R.id.lblPromedio9);
            textView.setText(""+porcNota[8]);
            if (textView.getText().toString().length()>3){textView.setText(textView.getText().toString().substring(0,3));}
            textView=(TextView)findViewById(R.id.lblPromedio10);
            textView.setText(""+porcNota[9]);
            if (textView.getText().toString().length()>3){textView.setText(textView.getText().toString().substring(0,3));}

        }
    }

    private double calcularBruto(){

        double total = 0;
        for (int i =0;i<10;i++){
            total=total + porcNota[i];
        }
       TextView txt=(TextView)findViewById(R.id.notaBruto);
        txt.setText(""+total);
        if (txt.getText().toString().length()>3)
        {
            txt.setText(txt.getText().toString().substring(0,3));
        }
        return total;
    }

    private void calcularNotaRequerida(double bruto){
        double descontado   =   bruto*0.6;
        double prenecesario =   4-descontado;
        double necesario    =   (prenecesario/0.4);

        TextView txt=(TextView)findViewById(R.id.necEnExamen);
        txt.setText(""+necesario);
        if (txt.getText().toString().length()>3){
            txt.setText(txt.getText().toString().substring(0,3));
        }
        if (necesario<=0)
        {
            txt.setText("0");
        }
    }

    private void calcularPromedioFinal(double promBruto){
        double examen=1;
        promBruto=(promBruto*0.6);
        EditText texam = (EditText)findViewById(R.id.examen);
        if (!texam.getText().toString().isEmpty()){examen=Double.parseDouble(texam.getText().toString());}else {examen=notaMinima;}
        examen=(examen*0.4);
        double promFinal = promBruto+examen;
        TextView pFinal = (TextView)findViewById(R.id.promedioFinal);
        pFinal.setText(""+promFinal);
        if (pFinal.getText().toString().length()>3){
            pFinal.setText(pFinal.getText().toString().substring(0,3));
        }

        if (texam.getText().toString().isEmpty()) {
            TextView tvNecesario = (TextView)findViewById(R.id.necEnExamen);
            double necesario = Double.parseDouble(tvNecesario.getText().toString());
            if (necesario >= 1 && necesario <= 7) {
                Toast.makeText(getApplicationContext(), "Aún te puedes salvar con el exámen", Toast.LENGTH_LONG).show();
            } else if (necesario < 1) {
                Toast.makeText(getApplicationContext(), "Felicidades pasaste el semestre", Toast.LENGTH_LONG).show();
            } else if (necesario > 7) {
                Toast.makeText(getApplicationContext(), "Si el semestre se cierra hoy, no pasarías", Toast.LENGTH_LONG).show();
            }
        }
        else{
            if (promFinal >= 4 && promFinal <= 7) {
                Toast.makeText(getApplicationContext(), "Felicitaciones!, haz pasado de este ramo", Toast.LENGTH_LONG).show();
            } else if (promFinal < 4) {
                Toast.makeText(getApplicationContext(), "Lo siento, el otro semestre será mejor", Toast.LENGTH_LONG).show();
            }
        }
    }

}
