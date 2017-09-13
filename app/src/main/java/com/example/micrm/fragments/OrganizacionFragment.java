package com.example.micrm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.micrm.R;
import com.example.micrm.models.Organizacion;

public class OrganizacionFragment extends Fragment {

    private final String TAG_D = "OrganizacionFragment";

    private EditText txt_nombre;
    private EditText txt_direccion;
    private EditText txt_telefono;
    private Button btn_agregar;

    public OrganizacionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_organizacion, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_nombre = view.findViewById(R.id.txt_nombre);
        txt_direccion = view.findViewById(R.id.txt_direccion);
        txt_telefono = view.findViewById(R.id.txt_telefono);
        btn_agregar = view.findViewById(R.id.btn_organizacion);

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarOrganizacion();
            }
        });
    }

    private void guardarOrganizacion() {
        txt_nombre.setError(null);
        if (!TextUtils.isEmpty(txt_nombre.getText().toString())) {

            String nombre = txt_nombre.getText().toString();
            String direccion = txt_direccion.getText().toString();
            String telefono = txt_telefono.getText().toString();

            Organizacion o = new Organizacion(nombre, direccion, telefono);
            Log.d(TAG_D, "Guardar el objeto " + o.toString());

            Toast.makeText(getActivity().getApplicationContext(), getResources().getString(R.string.organizacion_msg_exitoso), Toast.LENGTH_SHORT).show();

            txt_nombre.setText("");
            txt_direccion.setText("");
            txt_telefono.setText("");
        } else {
            txt_nombre.setError(getResources().getString(R.string.error_campo_requerido));
        }
    }

}
