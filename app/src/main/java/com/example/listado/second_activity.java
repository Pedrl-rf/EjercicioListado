package com.example.listado;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class second_activity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        TextInputEditText til_producto = findViewById(R.id.tiet_producto);
        TextInputEditText til_cantidad = findViewById(R.id.tiet_cantidad);
        Button bt_enviar = findViewById(R.id.bt_añadir);
        bt_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent enviar_producto = new Intent();
                enviar_producto.putExtra("producto", til_producto.getText().toString());
                enviar_producto.putExtra("cantidad", til_cantidad.getText().toString());
                setResult(RESULT_OK, enviar_producto);
                finish();
            }
        });

    }
}
