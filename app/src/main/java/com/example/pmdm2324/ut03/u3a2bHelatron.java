package com.example.pmdm2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm2324.R;

public class u3a2bHelatron extends AppCompatActivity {

    TextView tvFresa, tvChoco, tvVainilla, tvRecipiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a2b_helatron);

        tvFresa = findViewById(R.id.u3a2bidtvFresa);
        tvChoco = findViewById(R.id.u3a2bidtvChocolate);
        tvVainilla = findViewById(R.id.u3a2bidtvVainilla);
        tvRecipiente = findViewById(R.id.u3a2bidtvRecipiente);

        Bundle info = getIntent().getExtras();

        String bolasFresa = info.getString(u3a2aHelatron.INFO_FRESA);
        int bFresa = Integer.parseInt(bolasFresa);
        String  bolasChoco = info.getString(u3a2aHelatron.INFO_CHOCO);
        int bChoco = Integer.parseInt(bolasChoco);
        String bolasVainilla = info.getString(u3a2aHelatron.INFO_VAINILLA);
        int bVainilla = Integer.parseInt(bolasVainilla);
        String recipiente = info.getString(u3a2aHelatron.INFO_RECIPIENTE);

        for(int i = 1; i<=bFresa; i++){
            String o = "O";
            tvFresa.append(o);
        }
        for(int i = 1; i<=bChoco; i++){
            String o = "O";
            tvChoco.append(o);
        }
        for(int i = 1; i<=bVainilla; i++){
            String o = "O";
            tvVainilla.append(o);
        }
        if(recipiente.equals("Cucurucho")){
            tvRecipiente.setText("V");
        } else if (recipiente.equals("Cucurucho Chocolate")) {
         tvRecipiente.setText("V");
         tvRecipiente.setTextColor(Color.rgb(128,64,0));
        } else if (recipiente.equals("Tarrina")) {
            tvRecipiente.setText("U");
        }

    }
}