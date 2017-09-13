package com.example.micrm.fragments;

import android.app.DatePickerDialog;
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
import android.widget.Toast;

import com.example.micrm.R;
import com.example.micrm.models.Negocio;
import com.example.micrm.models.Organizacion;
import com.example.micrm.models.Persona;
import com.example.micrm.views.DatePickerFragment;

public class NegocioFragment extends Fragment implements View.OnClickListener {

    private final String TAG_D = "NegocioFragment";

    private EditText txt_titulo;
    private EditText txt_descripcion;
    private EditText txt_organizacion;
    private EditText txt_persona;
    private EditText txt_valor;
    private EditText txt_fecha_cierre;
    private EditText txt_estado;
    private Button btn_agregar;

    public NegocioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_negocio, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_titulo = view.findViewById(R.id.txt_titulo);
        txt_descripcion = view.findViewById(R.id.txt_descripcion);
        txt_organizacion = view.findViewById(R.id.txt_organizacion);
        txt_persona = view.findViewById(R.id.txt_persona);
        txt_valor = view.findViewById(R.id.txt_valor);
        txt_fecha_cierre = view.findViewById(R.id.txt_fecha_cierre);
        txt_fecha_cierre.setOnClickListener(this);
        txt_estado = view.findViewById(R.id.txt_estado);
        btn_agregar = view.findViewById(R.id.btn_negocio);
        btn_agregar.setOnClickListener(this);
    }

    private void guardarNegocio() {
        txt_titulo.setError(null);
        if (!TextUtils.isEmpty(txt_titulo.getText().toString())) {

            String titulo = txt_titulo.getText().toString();
            String descripcion = txt_descripcion.getText().toString();
            String organizacion = txt_organizacion.getText().toString();
            String persona = txt_persona.getText().toString();
            double valor = 0;
            if (!TextUtils.isEmpty(txt_valor.getText().toString()))
                valor = Double.valueOf(txt_valor.getText().toString());
            String fecha_cierre = txt_fecha_cierre.getText().toString();
            String estado = txt_estado.getText().toString();

            //Mock de Organizacion
            Organizacion o = new Organizacion(organizacion);
            //Mock de Persona
            Persona p = new Persona(persona);
            Negocio n = new Negocio(titulo, descripcion, o, p, valor, fecha_cierre, estado);
            Log.d(TAG_D, "Guardar el objeto " + n.toString());

            Toast.makeText(getActivity().getApplicationContext(), getResources().getString(R.string.negocio_msg_exitoso), Toast.LENGTH_SHORT).show();

            txt_titulo.setText("");
            txt_descripcion.setText("");
            txt_organizacion.setText("");
            txt_persona.setText("");
            txt_valor.setText("");
            txt_fecha_cierre.setText("");
            txt_estado.setText("");
        } else {
            txt_titulo.setError(getResources().getString(R.string.error_campo_requerido));
        }
    }

    private void showDatePickerDialog(final EditText view) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
                final String selectedDate = twoDigits(day) + "/" + twoDigits(month+1) + "/" + year;
                view.setText(selectedDate);
            }
        });
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_negocio:
                guardarNegocio();
                break;

            case R.id.txt_fecha_cierre:
                showDatePickerDialog(txt_fecha_cierre);
                break;
        }
    }

    private String twoDigits(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }
}
