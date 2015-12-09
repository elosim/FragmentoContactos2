package com.example.ivan.fragmentocontactos2.fragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.ivan.fragmentocontactos2.R;
import com.example.ivan.fragmentocontactos2.utiles.Contacto;

import java.util.ArrayList;

public class FragmentDetalles extends Fragment {

    private View v;
    private TextView tvNombre;
    private TextView tvNumeros;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_detalles, container, false);

        tvNombre = (TextView) v.findViewById(R.id.tvNombre);
        tvNumeros = (TextView) v.findViewById(R.id.tvNumeros);

        return v;
    }

    public void setContacto(Contacto c){

        tvNombre.setText(c.getNombre().trim());
        tvNumeros.setText(getNums(c));

    }
    public String getNums(Contacto c){
        ArrayList<String> numeros = c.getNumeros();
        String aux = "\n";
        for (String num : numeros) {
            aux+= num + "\n";
        }

        return aux;
    }
}
