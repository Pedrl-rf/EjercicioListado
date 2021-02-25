package com.example.listado;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int CODE = 1;
    List<Compra> productos;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab_eliminar = findViewById(R.id.floatingActionButton);

        productos= new ArrayList<>();

        Compra producto= new Compra("Anchoas", 3);
        Compra producto2= new Compra("Pepinillos", 2);
        Compra producto3= new Compra("Platanos", 1);

        myAdapter = new MyAdapter(MainActivity.this, productos);

        productos.add(producto);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto);

        RecyclerView recyclerview = findViewById(R.id.recyclerView);
        LinearLayoutManager llm =new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerview.setLayoutManager(llm);
        MyAdapter adapter = new MyAdapter(MainActivity.this, productos);
        recyclerview.setAdapter(adapter);

        Button bt_añadir = findViewById(R.id.bt_new);
        Button bt_eliminar_todos = findViewById(R.id.bt_eliminarTodos);

        bt_añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, second_activity.class);
                startActivityForResult(intent, CODE);
            }
        });

        bt_eliminar_todos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myAdapter.clearAll();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Activity.RESULT_OK && requestCode == CODE){
            if(data != null){
                String nombre = data.getStringExtra("producto");
                String cantidad =data.getStringExtra("cantidad");
                Compra compra = new Compra(nombre,Integer.parseInt(cantidad));
                productos.add(compra);
                myAdapter.notifyItemInserted(productos.size());
                Toast toast = Toast.makeText(getApplicationContext(),"Hola",Toast.LENGTH_LONG);
                toast.show();
            }
            else if (resultCode == Activity.RESULT_CANCELED) {
                Toast toast = Toast.makeText(getApplicationContext(),"Nada",Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}