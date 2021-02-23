package com.example.listado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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





    }
}