package com.example.pmdm2324.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.pmdm2324.R;



public class u2a5Citatron4000 extends AppCompatActivity {

    TextView tvFecha, tvHora, tvMostrarNombre, tvMostrarApellidos,
            tvMostrarDNI, tvMensajeFinal, tvHoraFin, tvFechaFin, tvErrorNombre, tvErrorApellidos, tvErrorDni, tvErrorHora, tvErrorFecha;
    EditText etDNI, etNombre, etApellidos;
    Button btsFecha, btsHora, btCogerCita;

    ImageView imgCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a5_citatron4000);


        tvFecha = findViewById(R.id.u2a5idtvFecha);
        tvHora = findViewById(R.id.u2a5idtvHora);
        btsFecha = findViewById(R.id.u2a5idbtSelFecha);
        btsHora = findViewById(R.id.u2a5idbtSelHora);
        etNombre = findViewById(R.id.u2a5idetNombre);
        etApellidos = findViewById(R.id.u2a5idetApellidos);
        etDNI = findViewById(R.id.u2a5idetDNI);
        btCogerCita = findViewById(R.id.u2a5idbtCogerCita);
        tvMostrarNombre = findViewById(R.id.u2a5idtvmostrarNombre);
        tvMostrarApellidos = findViewById(R.id.u2a5idtvmostrarApellidos);
        tvMostrarDNI = findViewById(R.id.u2a5idtvmostrarDNI);
        tvMensajeFinal = findViewById(R.id.u2a5idtvMensajeFinal);
        imgCheck = findViewById(R.id.u2a5idimgCheck);
        tvFechaFin = findViewById(R.id.u2a5idtvmostrarFechaFin);
        tvHoraFin = findViewById(R.id.u2a5idtvmostrarHoraFin);
        tvErrorNombre = findViewById(R.id.u2a5idtvErrorNombre);
        tvErrorApellidos = findViewById(R.id.u2a5idtvErrorApellidos);
        tvErrorDni = findViewById(R.id.u2a5idtvErrorDni);
        tvErrorHora = findViewById(R.id.u2a5idtvErrorHora);
        tvErrorFecha = findViewById(R.id.u2a5idtvErrorFecha);


        tvMostrarNombre.setVisibility(View.GONE);
        tvMostrarApellidos.setVisibility(View.GONE);
        tvMostrarDNI.setVisibility(View.GONE);
        tvMensajeFinal.setVisibility(View.GONE);
        imgCheck.setVisibility(View.GONE);
        tvHoraFin.setVisibility(View.GONE);
        tvFechaFin.setVisibility(View.GONE);

        btsFecha.setOnClickListener((View v) -> {
            // on below line we are getting
            // the instance of our calendar.
            final Calendar c = Calendar.getInstance();
            // on below line we are getting
            // our day, month and year.
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            // on below line we are creating a variable for date picker dialog.
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    // on below line we are passing context.
                    u2a5Citatron4000.this,
                    (view, year1, monthOfYear, dayOfMonth) -> {
                        Calendar selectedDate = new GregorianCalendar(year, monthOfYear, dayOfMonth);
                        int diaSemana = selectedDate.get(Calendar.DAY_OF_WEEK);
                        // on below line we are setting date to our text view.
                        if (diaSemana == Calendar.SATURDAY || diaSemana == Calendar.SUNDAY) {
                            tvErrorFecha.setText("Fecha erronea. Abrimos de lunes a viernes.");
                        } else {
                            // on below line we are setting date to our text view.
                            tvFecha.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year1);
                            tvErrorFecha.setText("");
                        }

                    },
                    // on below line we are passing year,
                    // month and day for selected date in our date picker.
                    year, month, day);
            // at last we are calling show to
            // display our date picker dialog.
            datePickerDialog.show();
        });
        btsHora.setOnClickListener((View v) -> {
            // on below line we are getting the
            // instance of our calendar.
            final Calendar c = Calendar.getInstance();

            // on below line we are getting our hour, minute.
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // on below line we are initializing our Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    u2a5Citatron4000.this,
                    (view, hourOfDay, minute1) -> {
                        // on below line we are setting selected time
                        // in our text view.
                        if (hourOfDay >= 9 && hourOfDay < 14) {
                            tvHora.setText(hourOfDay + ":" + minute1);
                            tvErrorHora.setText("");
                        }else{
                            tvErrorHora.setText("Hora errónea. Abrimos de 9 a 14.");
                        }

                    }, hour, minute, true);
            // at last we are calling show to
            // display our time picker dialog.
            timePickerDialog.show();
        });
        btCogerCita.setOnClickListener((View v) -> {
            String Nombre = etNombre.getText().toString();
            String Apellidos = etApellidos.getText().toString();
            String DNI = etDNI.getText().toString();
            String Fecha = tvFecha.getText().toString();
            String Hora = tvHora.getText().toString();

            Pattern pat = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
            Matcher matcher=pat.matcher(DNI);

            if(matcher.matches() && !Nombre.isEmpty() && !Apellidos.isEmpty() && !Fecha.isEmpty() &&!Hora.isEmpty()) {
                tvFecha.setVisibility(View.GONE);
                tvHora.setVisibility(View.GONE);
                btsFecha.setVisibility(View.GONE);
                btsHora.setVisibility(View.GONE);
                etNombre.setVisibility(View.GONE);
                etApellidos.setVisibility(View.GONE);
                etDNI.setVisibility(View.GONE);
                btCogerCita.setVisibility(View.GONE);
                tvErrorNombre.setVisibility(View.GONE);
                tvErrorApellidos.setVisibility(View.GONE);
                tvErrorDni.setVisibility(View.GONE);
                tvErrorFecha.setVisibility(View.GONE);
                tvErrorHora.setVisibility(View.GONE);

                tvMostrarNombre.setVisibility(View.VISIBLE);
                tvMostrarApellidos.setVisibility(View.VISIBLE);
                tvMostrarDNI.setVisibility(View.VISIBLE);
                tvMensajeFinal.setVisibility(View.VISIBLE);
                imgCheck.setVisibility(View.VISIBLE);
                tvHoraFin.setVisibility(View.VISIBLE);
                tvFechaFin.setVisibility(View.VISIBLE);

                tvMostrarNombre.setText(Nombre);
                tvMostrarApellidos.setText(Apellidos);
                tvMostrarDNI.setText(DNI);

                tvFechaFin.setText("Fecha: ");
                tvFechaFin.append(Fecha);

                tvHoraFin.setText("Hora: ");
                tvHoraFin.append(Hora);
            }
            else{
                if (Nombre.isEmpty()) {
                    tvErrorNombre.setText("Nombre vacio.");
                } else {
                    tvErrorNombre.setText("");
                }
                if (Apellidos.isEmpty()) {
                    tvErrorApellidos.setText("Apellidos vacios.");
                } else {
                    tvErrorApellidos.setText("");
                }

                if (!(matcher.matches()) || DNI.isEmpty()) {
                    tvErrorDni.setText("Error en el DNI o DNI vacio");
                } else {
                    tvErrorDni.setText("");
                }

                if (Fecha.isEmpty()) {
                    tvErrorFecha.setText("Seleccione una fecha.");
                } else {
                    tvErrorFecha.setText("");
                }

                if (Hora.isEmpty()) {
                    tvErrorHora.setText("Seleccione una hora.");
                } else {
                    tvErrorHora.setText("");
                }
            }

        });
    }
}




