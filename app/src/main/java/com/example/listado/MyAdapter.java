package com.example.listado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<compra> listado;

    public MyAdapter(Context context, List<compra> listado) {
        this.context = context;
        this.listado = listado;
    }

    static class MyHolder extends RecyclerView.ViewHolder {

        private TextView tv_nombre;
        private TextView tv_numero;

        public MyHolder (@NonNull View itemView) {
            super(itemView);
            tv_nombre = itemView.findViewById(R.id.tv_producto);
            tv_numero = itemView.findViewById(R.id.tv_cantidad);
        }

        public void setData (String nombre, String numero) {
            tv_nombre.setText(nombre);
            tv_numero.setText(numero);
        }


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.tarjetas, parent, false);
        MyHolder holder = new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        compra producto = listado.get(position);

        String nombre = producto.getProducto();
        String numero = String.valueOf(producto.getCantidad());

        // asignamos directamente el nombre al TextView
        //myHolder.tv_nombre.setText(nombre);

        // utilizando el método de la clase MyHolder
        myHolder.setData(nombre, numero);
    }

    @Override
    public int getItemCount() {
        return listado.size();
    }

}
