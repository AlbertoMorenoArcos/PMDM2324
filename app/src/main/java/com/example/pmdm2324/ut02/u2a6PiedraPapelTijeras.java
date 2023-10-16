package com.example.pmdm2324.ut02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pmdm2324.R;

import java.util.Random;

public class u2a6PiedraPapelTijeras extends AppCompatActivity {

    TextView u2a6idtvMaquina, u2a6idtvJugador, u2a6tvidmarcadorJugador, u2a6tvidmarcadorMaquina, u2a6tvidmaqEleccion, u2a6tvidresEleccion,
            u2a6idtvGanador, u2a6idtvPerdedor;
    ImageButton u2a6idimbtPiedra,u2a6idimbtTijeras, u2a6idimbtPapel;
    Button u2a6idbtReiniciar;
    ImageView u2a6idimgWin,u2a6idimgLose;
    View.OnClickListener manejador;
    String eJugador;
    int contadorJugador = 0;
    int contadorMaquina = 0;
    int contadorAcumulado = 0;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a6_piedra_papel_tijeras);


        u2a6idtvJugador = findViewById(R.id.u2a6idtvJugador);
        u2a6idtvMaquina = findViewById(R.id.u2a6idtvMaquina);
        u2a6tvidmarcadorJugador = findViewById(R.id.u2a6tvidmarJugador);
        u2a6tvidmarcadorMaquina = findViewById(R.id.u2a6idtvmarMaquina);
        u2a6tvidmaqEleccion = findViewById(R.id.u2a6idtvmaqEleccion);
        u2a6tvidresEleccion = findViewById(R.id.u2a6idtvresEleccion);
        u2a6idimbtPiedra = findViewById(R.id.u2a6idimbtPiedra);
        u2a6idimbtTijeras = findViewById(R.id.u2a6idimbtTijeras);
        u2a6idimbtPapel = findViewById(R.id.u2a6idimbtPapel);
        u2a6idbtReiniciar = findViewById(R.id.u2a6idbtReiniciar);
        u2a6idtvGanador = findViewById(R.id.u2a6idtvGanador);
        u2a6idtvPerdedor = findViewById(R.id.u2a6idtvPerdedor);
        u2a6idimgWin = findViewById(R.id.u2a6idimgWin);
        u2a6idimgLose = findViewById(R.id.u2a6idimgLose);

        u2a6idtvGanador.setVisibility(View.GONE);
        u2a6idtvPerdedor.setVisibility(View.GONE);
        u2a6idimgWin.setVisibility(View.GONE);
        u2a6idimgLose.setVisibility(View.GONE);

        manejador = (View botonPulsado)-> {
            ImageButton btPulsado = (ImageButton) botonPulsado;
            String eMaquina = EleccionMaquina();
            u2a6tvidmaqEleccion.setText("La maquina ha elegido " + eMaquina);
            if (btPulsado == u2a6idimbtPiedra) {
                eJugador = "Piedra";
            }
            if (btPulsado == u2a6idimbtPapel) {
                eJugador = "Papel";
            }
            if (btPulsado == u2a6idimbtTijeras) {
                eJugador = "Tijeras";
            }

            String cJugador;
            if (eMaquina.equals(eJugador)) {
                u2a6tvidresEleccion.setText("Empate");
                contadorAcumulado = 1;
            } else if (eJugador.equals("Piedra") && eMaquina.equals("Tijeras")) {
                u2a6tvidresEleccion.setText("Has ganado.");
                ++contadorJugador;
                contadorJugador += contadorAcumulado;
                cJugador = String.valueOf(contadorJugador);
                u2a6tvidmarcadorJugador.setText(cJugador);
                contadorAcumulado = 0;
            } else if (eJugador.equals("Papel") && eMaquina.equals("Piedra")) {
                u2a6tvidresEleccion.setText("Has ganado.");
                ++contadorJugador;
                contadorJugador += contadorAcumulado;
                cJugador = String.valueOf(contadorJugador);
                u2a6tvidmarcadorJugador.setText(cJugador);
                contadorAcumulado = 0;
            } else if (eJugador.equals("Tijeras") && eMaquina.equals("Papel")) {
                u2a6tvidresEleccion.setText("Has ganado.");
                ++contadorJugador;
                contadorJugador += contadorAcumulado;
                cJugador = String.valueOf(contadorJugador);
                u2a6tvidmarcadorJugador.setText(cJugador);
                contadorAcumulado = 0;
            } else {
                u2a6tvidresEleccion.setText("Has perdido");
                ++contadorMaquina;
                contadorMaquina += contadorAcumulado;
                String nMaquina = String.valueOf(contadorMaquina);
                u2a6tvidmarcadorMaquina.setText(nMaquina);
                contadorAcumulado = 0;
            }
            if (contadorMaquina >= 7) {
                u2a6idtvJugador.setVisibility(View.GONE);
                u2a6idtvMaquina.setVisibility(View.GONE);
                u2a6tvidmarcadorJugador.setVisibility(View.GONE);
                u2a6tvidmarcadorMaquina.setVisibility(View.GONE);
                u2a6tvidmaqEleccion.setVisibility(View.GONE);
                u2a6tvidresEleccion.setVisibility(View.GONE);
                u2a6idimbtPiedra.setVisibility(View.GONE);
                u2a6idimbtTijeras.setVisibility(View.GONE);
                u2a6idimbtPapel.setVisibility(View.GONE);
                u2a6idtvPerdedor.setVisibility(View.VISIBLE);
                u2a6idimgLose.setVisibility(View.VISIBLE);
                Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                v.vibrate(3000);
            } else if (contadorJugador >= 7) {
                u2a6idtvJugador.setVisibility(View.GONE);
                u2a6idtvMaquina.setVisibility(View.GONE);
                u2a6tvidmarcadorJugador.setVisibility(View.GONE);
                u2a6tvidmarcadorMaquina.setVisibility(View.GONE);
                u2a6tvidmaqEleccion.setVisibility(View.GONE);
                u2a6tvidresEleccion.setVisibility(View.GONE);
                u2a6idimbtPiedra.setVisibility(View.GONE);
                u2a6idimbtTijeras.setVisibility(View.GONE);
                u2a6idimbtPapel.setVisibility(View.GONE);
                u2a6idtvGanador.setVisibility(View.VISIBLE);
                u2a6idimgWin.setVisibility(View.VISIBLE);
                Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                v.vibrate(3000);
            }
        };




        u2a6idbtReiniciar.setOnClickListener((View v) -> {
            onBackPressed();
        });
        u2a6idimbtPiedra.setOnClickListener(manejador);
        u2a6idimbtPapel.setOnClickListener(manejador);
        u2a6idimbtTijeras.setOnClickListener(manejador);




    }
    // Declare the onBackPressed method when the back button is pressed this method will call
    @Override
    public void onBackPressed() {
        // Create the object of AlertDialog Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(u2a6PiedraPapelTijeras.this);

        // Set the message show for the Alert time
        builder.setMessage("¿Seguro que quieres reiniciar?");

        // Set Alert Title
        builder.setTitle("¡Cuidado!");

        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setPositiveButton("Si", (DialogInterface.OnClickListener) (dialog, which) -> {
            // When the user click yes button then app will close
            u2a6tvidmarcadorJugador.setText("0");
            u2a6tvidmarcadorMaquina.setText("0");
            u2a6tvidresEleccion.setText("");
            u2a6tvidmaqEleccion.setText("");
            contadorJugador = 0;
            contadorMaquina = 0;
            contadorAcumulado = 0;
            u2a6idtvJugador.setVisibility(View.VISIBLE);
            u2a6idtvMaquina.setVisibility(View.VISIBLE);
            u2a6tvidmarcadorJugador.setVisibility(View.VISIBLE);
            u2a6tvidmarcadorMaquina.setVisibility(View.VISIBLE);
            u2a6tvidmaqEleccion.setVisibility(View.VISIBLE);
            u2a6tvidresEleccion.setVisibility(View.VISIBLE);
            u2a6idimbtPiedra.setVisibility(View.VISIBLE);
            u2a6idimbtTijeras.setVisibility(View.VISIBLE);
            u2a6idimbtPapel.setVisibility(View.VISIBLE);
            u2a6idtvGanador.setVisibility(View.GONE);
            u2a6idimgWin.setVisibility(View.GONE);
            u2a6idtvPerdedor.setVisibility(View.GONE);
            u2a6idimgLose.setVisibility(View.GONE);

        });

        // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            // If user click no then dialog box is canceled.
            dialog.cancel();
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        alertDialog.show();
    }
    private String EleccionMaquina() {
        String[] eleccion = {"Piedra", "Papel", "Tijeras"};
        int i = new Random().nextInt(eleccion.length);
        return eleccion[i];
    }
}