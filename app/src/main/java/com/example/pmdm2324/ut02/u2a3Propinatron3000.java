package com.example.pmdm2324.ut02;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u2a3Propinatron3000 extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btBorrarUno, btBorrarTodo, btGenerarPropina;
    TextView tvCuenta, tvCuentaPropina, tvError;
    RadioButton rbMala, rbBuena, rbExcelente;

    View.OnClickListener manejador;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propinatron3000);

        bt1 = findViewById(R.id.u2a3idbtN1);
        bt2 = findViewById(R.id.u2a3idbtN2);
        bt3 = findViewById(R.id.u2a3idbtN3);
        bt4 = findViewById(R.id.u2a3idbtN4);
        bt5 = findViewById(R.id.u2a3idbtN5);
        bt6 = findViewById(R.id.u2a3idbtN6);
        bt7 = findViewById(R.id.u2a3idbtN7);
        bt8 = findViewById(R.id.u2a3idbtN8);
        bt9 = findViewById(R.id.u2a3idbtN9);
        bt0 = findViewById(R.id.u2a3idbtN0);
        btBorrarUno = findViewById(R.id.u2a3idbtBorrarUno);
        btBorrarTodo = findViewById(R.id.u2a3idbtBorrarTodo);
        btGenerarPropina = findViewById(R.id.u2a3idbtGenerarPropina);
        tvCuenta = findViewById(R.id.u2a3idtvCuenta);
        tvCuentaPropina = findViewById(R.id.u2a3idtvCuentaPropina);
        tvError = findViewById(R.id.u2a3idtvError);
        rbMala = findViewById(R.id.u2a3idrbMala);
        rbBuena = findViewById(R.id.u2a3idrbBuena);
        rbExcelente = findViewById(R.id.u2a3idrbExcelente);



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