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
import com.example.micrm.models.Persona;

public class PersonaFragment extends Fragment {

    private final String TAG_D = "PersonaFragment";

    private EditText txt_nombre;
    private EditText txt_telefono;
    private EditText txt_email;
    private Button btn_agregar;

    public PersonaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_persona, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt_nombre = view.findViewById(R.id.txt_nombre);
        txt_telefono = view.findViewById(R.id.txt_telefono);
        txt_email = view.findViewById(R.id.txt_email);
        btn_agregar = view.findViewById(R.id.btn_persona);

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarPersona();
            }
        });
    }

    private void guardarPersona(){
        txt_nombre.setError(null);
        if(!TextUtils.isEmpty(txt_nombre.getText().toString())){

            String nombre = txt_nombre.getText().toString();
            String telefono = txt_telefono.getText().toString();
            String email = txt_email.getText().toString();

            Persona p = new Persona(nombre,telefono,email);
            Log.d(TAG_D, "Guardar el objeto " + p.toString());

            Toast.makeText(getActivity().getApplicationContext(), getResources().getString(R.string.persona_msg_exitoso), Toast.LENGTH_SHORT).show();

            txt_nombre.setText("");
            txt_telefono.setText("");
            txt_email.setText("");
        }else{
            txt_nombre.setError(getResources().getString(R.string.error_campo_requerido));
        }
    }
}
