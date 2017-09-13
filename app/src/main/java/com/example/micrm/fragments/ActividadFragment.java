package com.example.micrm.fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.micrm.R;
import com.example.micrm.models.Actividad;
import com.example.micrm.models.Negocio;
import com.example.micrm.models.Organizacion;
import com.example.micrm.models.Persona;
import com.example.micrm.views.DatePickerFragment;
import com.example.micrm.views.TimePickerFragment;

public class ActividadFragment extends Fragment implements View.OnClickListener {

    private final String TAG_D = "ActividadFragment";

    private EditText txt_descripcion;
    private EditText txt_tipo;
    private EditText txt_organizacion;
    private EditText txt_persona;
    private EditText txt_negocio;
    private EditText txt_fecha;
    private EditText txt_hora;
    private Button btn_agregar;

    public ActividadFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actividad, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_descripcion = view.findViewById(R.id.txt_descripcion);
        txt_tipo = view.findViewById(R.id.txt_tipo);
        txt_organizacion = view.findViewById(R.id.txt_organizacion);
        txt_persona = view.findViewById(R.id.txt_persona);
        txt_negocio = view.findViewById(R.id.txt_negocio);
        txt_fecha = view.findViewById(R.id.txt_fecha);
        txt_fecha.setOnClickListener(this);
        txt_hora = view.findViewById(R.id.txt_hora);
        txt_hora.setOnClickListener(this);
        btn_agregar = view.findViewById(R.id.btn_actividad);
        btn_agregar.setOnClickListener(this);
    }

    private void showDatePickerDialog(final EditText view) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
                final String selectedDate = twoDigits(day) + "/" + twoDigits(month + 1) + "/" + year;
                view.setText(selectedDate);
            }
        });
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }

    private void showTimePickerDialog(final EditText view) {
        TimePickerFragment newFragment = TimePickerFragment.newInstance(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                // +1 because january is zero
                final String selectedTime = twoDigits(hourOfDay) + ":" + twoDigits(minute);
                view.setText(selectedTime);
            }
        });
        newFragment.show(getActivity().getSupportFragmentManager(), "timePicker");
    }

    private void guardarActividad() {
        txt_descripcion.setError(null);
        if (!TextUtils.isEmpty(txt_descripcion.getText().toString())) {

            String descripcion = txt_descripcion.getText().toString();
            String tipo = txt_tipo.getText().toString();
            String organizacion = txt_organizacion.getText().toString();
            String persona = txt_persona.getText().toString();
            String negocio = txt_negocio.getText().toString();
            String fecha = txt_fecha.getText().toString();
            String hora = txt_hora.getText().toString();

            //Mock de Organizacion
            Organizacion o = new Organizacion(organizacion);
            //Mock de Persona
            Persona p = new Persona(persona);
            //Mock de Negocio
            Negocio n = new Negocio(negocio);
            Actividad a = new Actividad(descripcion, tipo, o, p, n, fecha, hora);
            Log.d(TAG_D, "Guardar el objeto " + a.toString());

            Toast.makeText(getActivity().getApplicationContext(), getResources().getString(R.string.actividad_msg_exitoso), Toast.LENGTH_SHORT).show();

            txt_descripcion.setText("");
            txt_tipo.setText("");
            txt_organizacion.setText("");
            txt_persona.setText("");
            txt_negocio.setText("");
            txt_fecha.setText("");
            txt_hora.setText("");
        } else {
            txt_descripcion.setError(getResources().getString(R.string.error_campo_requerido));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_actividad:
                guardarActividad();
                break;

            case R.id.txt_fecha:
                showDatePickerDialog(txt_fecha);
                break;
            case R.id.txt_hora:
                showTimePickerDialog(txt_hora);
                break;
        }
    }

    private String twoDigits(int n) {
        return (n <= 9) ? ("0" + n) : String.valueOf(n);
    }
}
