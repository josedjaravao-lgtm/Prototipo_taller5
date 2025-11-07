package com.example.taller5.Modelo;

public class Producto {
    private  String nombre;
    private  String id;
    private  Double precio;
    public Producto(String nombre, String id, Double precio){
        this.id=id;
        this.nombre=nombre;
        this.precio=precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }
    @Override
    public String toString() {
            return "Nombre: " + nombre + ", Id: " + nombre + ", Precio: " + precio;
    }
}
