package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float variavelAcum = 0, numDisplay = 0;
    int operator = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void limpaTela(View v)
    {
        TextView txtResultado = (TextView) findViewById(R.id.txtDisp);
        TextView txtDispOld = (TextView) findViewById(R.id.txtDispOld);

        txtResultado.setText("");
        txtDispOld.setText("");
    }

    public void getNum(View v)
    {
        Button botao = (Button) findViewById(v.getId());
        TextView txtResultado = (TextView) findViewById(R.id.txtDisp);

        String display = "";

        display = txtResultado.getText().toString() + botao.getText().toString();
        //numDisplay = Float.parseFloat(display);

        txtResultado.setText(display.toString());
        numDisplay = Float.parseFloat(display);
    }

    public void casaDecimal(View v)
    {
        Button botao = (Button) findViewById(v.getId());
        TextView txtResultado = (TextView) findViewById(R.id.txtDisp);

        String display = "";
        display = txtResultado.getText().toString() + botao.getText().toString();
        txtResultado.setText(display.toString());
    }

    public void getOperator(View v)
    {
        String display = "";
        Button botao = (Button) findViewById(v.getId());
        TextView txtDisp = (TextView) findViewById(R.id.txtDisp);
        TextView txtDispOld = (TextView) findViewById(R.id.txtDispOld);

        if(txtDispOld.getText() == "")
        {
            variavelAcum = numDisplay;
        }

        txtDispOld.setText(String.valueOf(numDisplay));
        switch(botao.getText().toString())
        {
            case "+":
                operator = 1;
                break;

            case "-":

                operator = 2;
                break;

            case "X":
                operator = 3;
                break;

            default:
                operator = 4;
                break;

        }

        display = txtDisp.getText().toString() + botao.getText().toString();
        txtDispOld.setText(display);
        txtDisp.setText("");
    }

    public void setResult(View v)
    {
        Button botao = (Button) findViewById(v.getId());
        TextView txtResultado = (TextView) findViewById(R.id.txtDisp);
        TextView txtDispOld = (TextView) findViewById(R.id.txtDispOld);

        try{
            variavelAcum = calculaResult(variavelAcum, numDisplay , operator);
            txtResultado.setText(Float.toString(variavelAcum));
            operator = 0;
        }
        catch (NumberFormatException ex)
        {
            txtResultado.setText("Erro");
        }

    }

    public float calculaResult(float num1, float num2, int op)
    {
        switch (op)
        {
            case 1:
                variavelAcum = (num1 + num2);
                break;

            case 2:
                variavelAcum = (num1 - num2);
                break;

            case 3:
                variavelAcum = (num1 * num2);
                break;

            case 4:
                variavelAcum = (num1 / num2);
                break;

            default:
                variavelAcum = 0;
                break;
        }
        return variavelAcum;
    }

    public void inverteSinal(View v)
    {
        float troca = 0;
        Button botao = (Button) findViewById(v.getId());
        TextView txtResultado = (TextView) findViewById(R.id.txtDisp);
        try {
                troca = (Float.parseFloat(txtResultado.getText().toString()) * -1);
        }
        catch (NumberFormatException ex)
        {
            txtResultado.setText("0");
        }

        String display = "";
        display = String.valueOf(troca);
        txtResultado.setText(display.toString());
        numDisplay = Float.parseFloat(display);
    }
}
