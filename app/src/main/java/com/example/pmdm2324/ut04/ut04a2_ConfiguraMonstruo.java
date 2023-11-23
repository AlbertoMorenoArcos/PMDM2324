package com.example.pmdm2324.ut04;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pmdm2324.R;
import com.example.pmdm2324.ut03.Monstruo;

public class ut04a2_ConfiguraMonstruo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText etNombre, etExtremidades, etColor;
    TextView tvError;
    Button btCrear;
    ut04f2_ConfiguraMonstruo monstruo1, monstruo2, monstruo3, monstruo4;
    Spinner spMonstruo;
    String monstruoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut04a2_configura_monstruo);
        etNombre = findViewById(R.id.ut4a2idetNombre);
        etExtremidades = findViewById(R.id.ut4a2idetExtremidades);
        etColor = findViewById(R.id.ut4a2idetColor);
        btCrear = findViewById(R.id.ut4a2idbtCrear);
        spMonstruo = findViewById(R.id.ut4a2idspMonstruo);
        tvError = findViewById(R.id.ut4a2idtvError);
        monstruo1 = (ut04f2_ConfiguraMonstruo) getSupportFragmentManager().findFragmentById(R.id.ut4a2idFrMonstruo1);
        monstruo2 = (ut04f2_ConfiguraMonstruo) getSupportFragmentManager().findFragmentById(R.id.ut4a2idFrMonstruo2);
        monstruo3 = (ut04f2_ConfiguraMonstruo) getSupportFragmentManager().findFragmentById(R.id.ut4a2idFrMonstruo3);
        monstruo4 = (ut04f2_ConfiguraMonstruo) getSupportFragmentManager().findFragmentById(R.id.ut4a2idFrMonstruo4);

        btCrear.setOnClickListener(view -> {
            try{
            String nombre = etNombre.getText().toString();
            String color = etColor.getText().toString();
            String etExtrem = etExtremidades.getText().toString();
            int extremidades = Integer.parseInt(etExtrem);
            Monstruo miMonstruo = new Monstruo(nombre, extremidades, color);
            if (monstruoSeleccionado.equals("Monstruo 1")) {
                monstruo1.setText(miMonstruo.toString());
                monstruo1.setColor(color);
                tvError.setText("");
            } else if (monstruoSeleccionado.equals("Monstruo 2")) {
                monstruo2.setText(miMonstruo.toString());
                monstruo2.setColor(color);
                tvError.setText("");
            } else if (monstruoSeleccionado.equals("Monstruo 3")) {
                monstruo3.setText(miMonstruo.toString());
                monstruo3.setColor(color);
                tvError.setText("");
            } else if (monstruoSeleccionado.equals("Monstruo 4")) {
                monstruo4.setText(miMonstruo.toString());
                monstruo4.setColor(color);
                tvError.setText("");
            }
            }catch (Exception e){
                tvError.setText("Hay campos vacios.");
            }


        });
        spMonstruo.setOnItemSelectedListener(this);
        String[] recipientes = {"Monstruo 1", "Monstruo 2", "Monstruo 3", "Monstruo 4"};
        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, recipientes);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spMonstruo.setAdapter(ad);


    }
    // Performing action when ItemSelected
    // from spinner, Overriding onItemSelected method

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        monstruoSeleccionado = spMonstruo.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}