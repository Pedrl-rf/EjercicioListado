package com.example.listado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<compra> productos= new ArrayList<>();
        compra producto= new compra("Anchoas", 3);
        compra producto2= new compra("Pepinillos", 2);
        compra producto3= new compra("Platanos", 1);

        productos.add(producto);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto);
        productos.add(producto2);
        productos.add(producto3);

        RecyclerView recyclerview = findViewById(R.id.recyclerView);
        LinearLayoutManager llm =new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerview.setLayoutManager(llm);
        MyAdapter adapter = new MyAdapter(MainActivity.this, productos);
        recyclerview.setAdapter(adapter);

        Button bt_añadir = findViewById(R.id.bt_añadir);
        Button bt_eliminar_todos = findViewById(R.id.bt_eliminarTodos);

        bt_añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}