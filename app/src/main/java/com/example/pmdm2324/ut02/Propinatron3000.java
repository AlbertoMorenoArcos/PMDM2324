package com.example.pmdm2324.ut02;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class Propinatron3000 extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btBorrarUno, btBorrarTodo, btGenerarPropina;
    TextView tvCuenta, tvCuentaPropina, tvError;
    RadioButton rbMala, rbBuena, rbExcelente;

    View.OnClickListener manejador;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propinatron3000);

        bt1 = findViewById(R.id.u2a2idbtN1);
        bt2 = findViewById(R.id.u2a2idbtN2);
        bt3 = findViewById(R.id.u2a2idbtN3);
        bt4 = findViewById(R.id.u2a2idbtN4);
        bt5 = findViewById(R.id.u2a2idbtN5);
        bt6 = findViewById(R.id.u2a2idbtN6);
        bt7 = findViewById(R.id.u2a2idbtN7);
        bt8 = findViewById(R.id.u2a2idbtN8);
        bt9 = findViewById(R.id.u2a2idbtN9);
        bt0 = findViewById(R.id.u2a2idbtN0);
        btBorrarUno = findViewById(R.id.u2a2idbtBorrarUno);
        btBorrarTodo = findViewById(R.id.u2a2idbtBorrarTodo);
        btGenerarPropina = findViewById(R.id.u2a2idbtGenerarPropina);
        tvCuenta = findViewById(R.id.u2a2idtvCuenta);
        tvCuentaPropina = findViewById(R.id.u2a2idtvCuentaPropina);
        tvError = findViewById(R.id.u2a2idtvError);
        rbMala = findViewById(R.id.u2a2idrbMala);
        rbBuena = findViewById(R.id.u2a2idrbBuena);
        rbExcelente = findViewById(R.id.u2a2idrbExcelente);



        manejador = (View botonPulsado)->{
            try{
                tvError.setText("");
                Button btPulsado = (Button) botonPulsado;
                if(btPulsado == btBorrarTodo){
                    tvCuenta.setText("");
                    tvCuentaPropina.setText("");
                }else if(btPulsado == btBorrarUno){
                    String cuenta = tvCuenta.getText().toString();
                    String cFinal = cuenta.substring(0, (cuenta.length() - 1));
                    tvCuenta.setText(cFinal);
                } else {
                    tvCuenta.append(btPulsado.getText().toString());
                }
            }catch(NumberFormatException e1) {
                tvError.setText("ERROR: No has añadido datos para borrar.");
            }catch(StringIndexOutOfBoundsException e2){
                tvError.setText("ERROR: No has añadido datos para borrar.");
            }catch (Exception e){
                tvError.setText("ERROR DESCONOCIDO");
            }

        };

        bt1.setOnClickListener(manejador);
        bt2.setOnClickListener(manejador);
        bt3.setOnClickListener(manejador);
        bt4.setOnClickListener(manejador);
        bt5.setOnClickListener(manejador);
        bt6.setOnClickListener(manejador);
        bt7.setOnClickListener(manejador);
        bt8.setOnClickListener(manejador);
        bt9.setOnClickListener(manejador);
        bt0.setOnClickListener(manejador);
        btBorrarTodo.setOnClickListener(manejador);
        btBorrarUno.setOnClickListener(manejador);

        btGenerarPropina.setOnClickListener((View v) -> {
            try {
                double pBuena = 0.10;
                double pExcelente = 0.20;
                double Cuenta = 0;
                double cuentaFinal = 0;
                if (rbBuena.isChecked()) {
                    Cuenta = Double.parseDouble(tvCuenta.getText().toString());
                    cuentaFinal = (Cuenta * pBuena) + Cuenta;
                    String cFinalString = Double.toString(cuentaFinal);
                    tvCuentaPropina.setText(cFinalString + "€");
                } else if (rbExcelente.isChecked()) {
                    Cuenta = Double.parseDouble(tvCuenta.getText().toString());
                    cuentaFinal = (Cuenta * pExcelente) + Cuenta;
                    String cFinalString = Double.toString(cuentaFinal);
                    tvCuentaPropina.setText(cFinalString + "€");
                } else if (rbMala.isChecked()) {
                    tvCuentaPropina.setText(tvCuenta.getText().toString() + "€");
                }
            }catch(NumberFormatException e1) {
                tvError.setText("ERROR: No has puesto la cuenta, para añadir la propina.");
            }catch(StringIndexOutOfBoundsException e2){
                tvError.setText("ERROR: No has añadido datos para borrar.");
            }catch (Exception e){
                tvError.setText("ERROR DESCONOCIDO");
            }

        });


    }
}