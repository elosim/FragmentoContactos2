package com.example.ivan.fragmentocontactos2.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.ivan.fragmentocontactos2.R;
import com.example.ivan.fragmentocontactos2.utiles.Contacto;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<Contacto> {

    private Context ctx;
    private LayoutInflater lInflator;
    private ArrayList<Contacto> values;

    static class ViewHolder {
        TextView tvNom, tvNums;
    }

    public Adaptador(Context context, ArrayList<Contacto> objects) {
        super(context, R.layout.item, objects);
        this.ctx = context;
        this.lInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.values = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = new ViewHolder();

        if (convertView == null) {

            convertView = lInflator.inflate(R.layout.item, null);

            TextView tv = (TextView) convertView.findViewById(R.id.tvNombre);
            vh.tvNom = tv;

            tv = (TextView) convertView.findViewById(R.id.textView);
            vh.tvNums = tv;

            convertView.setTag(vh);

        } else {

            vh = (ViewHolder) convertView.getTag();
        }

        vh.tvNom.setText(values.get(position).getNombre());

        if (!values.get(position).isEmpty())
            vh.tvNums.setText(values.get(position).getNumeros().get(0));

        return convertView;
    }
}
