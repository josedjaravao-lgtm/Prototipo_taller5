package com.example.taller5;

import com.example.taller5.Modelo.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RegistroProductos {
    private static final ObservableList<Producto> listaProductos = FXCollections.observableArrayList();


    public static void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }


    public static ObservableList<Producto> getListaProductos() {
        return listaProductos;
    }

}
