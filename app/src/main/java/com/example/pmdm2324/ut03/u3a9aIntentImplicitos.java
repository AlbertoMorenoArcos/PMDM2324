package com.example.pmdm2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a9aIntentImplicitos extends AppCompatActivity {
    public static final String URL_CANCION = "https://www.youtube.com/watch?v=eyurjSNb20w";
    public static final String CADENA_ERROR = "No se pudo realizar la acción";
    public static final String CADENA_SMS = "Te veo hoy a las 6pm";
    public static final String NUMERO_PACO = "625789413";
    public static final String STRING_GEOLOCALIZACION = "geo:0,0?q=Paseo+de+la+Florida,+10,+28008+Madrid";

    Button btnCancion, btnNumero, btnSMS, btnAbrirMapa, btnAlarma;
    TextView tvError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a9a_intent_implicitos);

        btnCancion = findViewById(R.id.u3a9abtnCancion);
        btnNumero = findViewById(R.id.u3a9abtnNumero);
        btnSMS = findViewById(R.id.u3a9abtnSMS);
        btnAbrirMapa = findViewById(R.id.u3a9abtnMapa);
        btnAlarma = findViewById(R.id.u3a9abtnAlarma);
        tvError = findViewById(R.id.u3a9atvError);

        btnCancion.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, URL_CANCION);
            startActivity(intent);
        });

        btnNumero.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + "666"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                tvError.setText(CADENA_ERROR);
            }
        });

        btnSMS.setOnClickListener(view -> {
            Uri uri = Uri.parse("smsto:" + NUMERO_PACO);
            Intent i = new Intent(Intent.ACTION_SENDTO, uri);
            i.putExtra("sms_body", CADENA_SMS);
            startActivity(i);
        });

        btnAbrirMapa.setOnClickListener(view -> {
            Uri uri = Uri.parse(STRING_GEOLOCALIZACION);
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        });

        btnAlarma.setOnClickListener(view -> {
            String mensaje = "¡ALARMAAAAAA!";
            Integer hour = 9;
            Integer minutes = 15;

            Intent i = new Intent(AlarmClock.ACTION_SET_ALARM).
                    putExtra(AlarmClock.EXTRA_MESSAGE, mensaje).
                    putExtra(AlarmClock.EXTRA_HOUR, hour).
                    putExtra(AlarmClock.EXTRA_MINUTES, minutes);
            startActivity(i);
        });
    }
}