package com.example.pmdm2324.ut09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm2324.R;
import com.example.pmdm2324.ut09.dataGymExercises.Ejercicio;
import com.example.pmdm2324.ut09.dataGymExercises.ServiceExercises;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ut09a2_Exercises extends AppCompatActivity {

    EditText muscle;
    Button get;
    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut09a2_exercises);
        muscle = findViewById(R.id.ut09a2_Muscle);
        get = findViewById(R.id.ut09a2_getExercises);
        info = findViewById(R.id.ut09a2_info);

        get.setOnClickListener((v)->{
            ServiceExercises exercise = ServiceExercises.getInstancia();
            Call<JsonArray> llamada =  exercise.getRepo().getEjercicio(muscle.getText().toString());

            llamada.enqueue(new Callback<JsonArray>() {
                @Override
                public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                    JsonArray exer = response.body();
                    String name = "";
                    String muscle = "";
                    String difficulty = "";
                    for (JsonElement jsonElement : exer) {
                        JsonObject ejercicioObject = jsonElement.getAsJsonObject();
                        name = ejercicioObject.get("name").getAsString();
                        muscle = ejercicioObject.get("muscle").getAsString();
                        difficulty = ejercicioObject.get("difficulty").getAsString();
                    }
                    info.append(name + "\n");
                    info.append(muscle + "\n");
                    info.append(difficulty + "\n");
                }

                @Override
                public void onFailure(Call<JsonArray> call, Throwable t) {
                    String nuncaToast = "Debug";
                }
            });
        });
    }
}