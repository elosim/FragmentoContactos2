package com.example.ivan.fragmentocontactos2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ivan.fragmentocontactos2.fragmentos.FragmentDetalles;
import com.example.ivan.fragmentocontactos2.utiles.Contacto;


public class Second extends AppCompatActivity {

    private Contacto contactoaux;
    private Contacto contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactoaux =null;


        if(savedInstanceState!=null){
            contactoaux = (Contacto) savedInstanceState.getSerializable("contactoaux");
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.second_activity);

            contacto = (Contacto) getIntent().getExtras().getSerializable("contacto");
            Intent i=new Intent (this,Second.class);
            Bundle b= new Bundle();

            b.putSerializable("contacto", contacto);
            i.putExtras(b);

            FragmentDetalles fragment = (FragmentDetalles) getFragmentManager().findFragmentById(R.id.fragment2v);
            fragment.setContacto(contacto);

        }else{

            Intent i=new Intent (this,Second.class);
            Bundle b= new Bundle();
            contacto = (Contacto) getIntent().getExtras().getSerializable("contacto");

            b.putSerializable("contacto", contacto);
            i.putExtras(b);

            setResult(Main.APLICACION, i);
            finish();


        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("contactoaux", contacto);
    }
}
