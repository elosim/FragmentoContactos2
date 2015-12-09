package com.example.ivan.fragmentocontactos2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ivan.fragmentocontactos2.fragmentos.FragmentDetalles;
import com.example.ivan.fragmentocontactos2.utiles.Contacto;

public class Main extends AppCompatActivity implements OnFragmentoInteraccionListener {
    public static final int APLICACION=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @Override
    public void onInteraccion(Contacto c) {
        FragmentDetalles fragment = (FragmentDetalles) getFragmentManager().findFragmentById(R.id.fragmentdh);

        if (fragment == null || !fragment.isInLayout()) {

            Intent i=new Intent (this,Second.class);
            Bundle b= new Bundle();

            b.putSerializable("contacto", c);
            i.putExtras(b);

            startActivityForResult(i, APLICACION);

        }else{
            fragment.setContacto(c);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == APLICACION){
            Contacto x = (Contacto) data.getExtras().getSerializable("contacto");
            onInteraccion(x);
        }

    }
}
