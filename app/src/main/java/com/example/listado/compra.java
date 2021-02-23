package com.example.listado;

public class compra {
    String producto;
    int cantidad;

    public compra(String producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getProducto() {
        return producto;
    }
}
