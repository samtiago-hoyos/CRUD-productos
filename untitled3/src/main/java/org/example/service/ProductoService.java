package org.example.service;


import org.example.Model.Producto;
import org.example.repository.ProductoRepository;

import java.util.List;

public class ProductoService {

    private ProductoRepository repository;

    public ProductoService() {
        repository = new ProductoRepository();
    }

    public void crearProducto(int id, String nombre, double precio, int cantidad) {

        Producto producto = new Producto(id, nombre, precio, cantidad);

        repository.guardar(producto);
    }

    public List<Producto> listarProductos() {
        return repository.listar();
    }

    public void eliminarProducto(int id) {
        repository.eliminar(id);
    }

    public void actualizarProducto(int id, String nombre, double precio, int cantidad) {

        Producto producto = repository.buscarPorId(id);

        if (producto != null) {

            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCantidad(cantidad);

        }

    }

}