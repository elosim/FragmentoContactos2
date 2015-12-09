package com.example.ivan.fragmentocontactos2.fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.ivan.fragmentocontactos2.OnFragmentoInteraccionListener;
import com.example.ivan.fragmentocontactos2.R;
import com.example.ivan.fragmentocontactos2.adaptadores.Adaptador;
import com.example.ivan.fragmentocontactos2.utiles.ConnectContact;
import com.example.ivan.fragmentocontactos2.utiles.Contacto;

import java.util.ArrayList;
import java.util.List;

public class Fragmentlista extends android.support.v4.app.Fragment {
    View v;
    private List<Contacto> lista ;
    private ListView lv;
    private Adaptador ad;
    private OnFragmentoInteraccionListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_lista, container, false);

        init();

        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentoInteraccionListener){
            listener = (OnFragmentoInteraccionListener) context;
        }
    }



    private void init(){
        lv = (ListView) v.findViewById(R.id.lvFragment);
        lista = new ArrayList<>();
        lista = ConnectContact.getLista(getActivity());

        ad = new Adaptador(getActivity(),(ArrayList)lista);
        lv.setAdapter(ad);
        lv.setTag(lista);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onInteraccion(lista.get(position));
            }
        });
    }
}
