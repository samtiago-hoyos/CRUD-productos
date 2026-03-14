package org.example.view;



import org.example.Model.Producto;
import org.example.service.ProductoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductoView extends JFrame {

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;

    private JTable tabla;

    private ProductoService service;

    public ProductoView() {

        service = new ProductoService();

        setTitle("CRUD Productos");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponentes();

    }

    private void initComponentes(){

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(4,2,10,10));
        formulario.setBorder(BorderFactory.createTitledBorder("Datos Producto"));

        txtId = new JTextField();
        txtNombre = new JTextField();
        txtPrecio = new JTextField();
        txtCantidad = new JTextField();

        formulario.add(new JLabel("ID"));
        formulario.add(txtId);

        formulario.add(new JLabel("Nombre"));
        formulario.add(txtNombre);

        formulario.add(new JLabel("Precio"));
        formulario.add(txtPrecio);

        formulario.add(new JLabel("Cantidad"));
        formulario.add(txtCantidad);

        panel.add(formulario,BorderLayout.NORTH);

        tabla = new JTable();

        panel.add(new JScrollPane(tabla),BorderLayout.CENTER);

        JPanel botones = new JPanel();

        JButton btnCrear = new JButton("Crear");
        JButton btnListar = new JButton("Listar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");

        botones.add(btnCrear);
        botones.add(btnListar);
        botones.add(btnActualizar);
        botones.add(btnEliminar);

        panel.add(botones,BorderLayout.SOUTH);

        add(panel);

        btnCrear.addActionListener(e -> crear());
        btnListar.addActionListener(e -> listar());
        btnActualizar.addActionListener(e -> actualizar());
        btnEliminar.addActionListener(e -> eliminar());

    }

    private void crear(){

        int id = Integer.parseInt(txtId.getText());
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        int cantidad = Integer.parseInt(txtCantidad.getText());

        service.crearProducto(id,nombre,precio,cantidad);

        JOptionPane.showMessageDialog(this,"Producto creado");

    }

    private void listar(){

        String[] columnas = {"ID","Nombre","Precio","Cantidad"};

        DefaultTableModel modelo = new DefaultTableModel(columnas,0);

        for(Producto p : service.listarProductos()){

            Object[] fila = {
                    p.getId(),
                    p.getNombre(),
                    p.getPrecio(),
                    p.getCantidad()
            };

            modelo.addRow(fila);

        }

        tabla.setModel(modelo);

    }

    private void actualizar(){

        int id = Integer.parseInt(txtId.getText());
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        int cantidad = Integer.parseInt(txtCantidad.getText());

        service.actualizarProducto(id,nombre,precio,cantidad);

        JOptionPane.showMessageDialog(this,"Producto actualizado");

    }

    private void eliminar(){

        int id = Integer.parseInt(txtId.getText());

        service.eliminarProducto(id);

        JOptionPane.showMessageDialog(this,"Producto eliminado");

    }

}