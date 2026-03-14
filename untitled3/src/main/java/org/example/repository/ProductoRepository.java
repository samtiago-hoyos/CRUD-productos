package org.example.repository;

import org.example.Model.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * Simula la base de datos usando ArrayList
 */
public class ProductoRepository {

    private List<Producto> listaProductos;

    public ProductoRepository() {
        listaProductos = new ArrayList<>();
    }

    public void guardar(Producto producto) {
        listaProductos.add(producto);
    }

    public List<Producto> listar() {
        return listaProductos;
    }

    public Producto buscarPorId(int id) {

        for (Producto p : listaProductos) {

            if (p.getId() == id) {
                return p;
            }

        }

        return null;
    }

    public void eliminar(int id) {

        Producto producto = buscarPorId(id);

        if (producto != null) {
            listaProductos.remove(producto);
        }

    }

}