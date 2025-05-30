/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.inventariobodega.forms;

import com.mycompany.inventariobodega.DAO.BaseDatosDao;
import com.mycompany.inventariobodega.DAO.CategoriProductoDao;
import com.mycompany.inventariobodega.DAO.MarcaProductoDao;
import com.mycompany.inventariobodega.DAO.MedidaProductoDao;
import com.mycompany.inventariobodega.DAO.NombreProductoDao;
import com.mycompany.inventariobodega.DAO.ProveedorProductoDao;
import com.mycompany.inventariobodega.DAO.UbicacionProductoDao;
import com.mycompany.inventariobodega.entidades.BaseDatos;
import com.mycompany.inventariobodega.entidades.BaseDatosTabla;
import com.mycompany.inventariobodega.entidades.CategoriaProducto;
import com.mycompany.inventariobodega.entidades.MarcaProducto;
import com.mycompany.inventariobodega.entidades.MedidaProducto;
import com.mycompany.inventariobodega.entidades.NombreProducto;
import com.mycompany.inventariobodega.entidades.ProveedorProducto;
import com.mycompany.inventariobodega.entidades.UbicacionProducto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OSCAR
 * Este código Java define un panel (inventario) que muestra una tabla con datos de inventario de la bodega. 
 */
public class inventario extends javax.swing.JPanel {

    //Declaración de Variables de Instancia
    private final BaseDatosDao baseDatosDao;
    private final NombreProductoDao nombreProductoDao;
    private final MarcaProductoDao marcaProductoDao;
    private final CategoriProductoDao categoriaProductoDao;
    private final MedidaProductoDao medidaProductoDao;
    private final UbicacionProductoDao ubicacionProductoDao;
    private final ProveedorProductoDao proveedorProductoDao;
    
    //constructor
    public inventario() {
        initComponents();
        
        // Inicializa las variables de instancia de los DAOs.
        baseDatosDao = new BaseDatosDao();
        nombreProductoDao = new NombreProductoDao();
        marcaProductoDao = new MarcaProductoDao();
        categoriaProductoDao = new CategoriProductoDao();
        medidaProductoDao = new MedidaProductoDao();
        ubicacionProductoDao = new UbicacionProductoDao();
        proveedorProductoDao = new ProveedorProductoDao();
        cargarDatosTabla();//Llama al método para cargar los datos en la tabla
        
    }

    private List<BaseDatosTabla> obtenerDatosTabla() {
        List<BaseDatos> baseDatosList = baseDatosDao.obtenerTodos();//Obtiene una lista de todos los registros de la tabla BaseDatos
        List<BaseDatosTabla> datosTabla = new ArrayList<>();//Crea una lista para almacenar los datos que se mostrarán en la tabla.

        //Bucle for: Itera a través de la lista de registros BaseDatos
        for (BaseDatos baseDatos : baseDatosList) {
            try {
                
            // obtener entidades relacionadas
            NombreProducto nombreProducto = nombreProductoDao.obtenerPorId(baseDatos.getFknombreproducto());
            MarcaProducto marcaProducto = marcaProductoDao.obtenerPorId(baseDatos.getFkmarcaproducto());
            CategoriaProducto categoriaProducto = categoriaProductoDao.obtenerPorId(baseDatos.getFkcategoriaproducto());
            MedidaProducto medidaProducto = medidaProductoDao.obtenerPorId(baseDatos.getFkmedidaproducto());
            UbicacionProducto ubicacionProducto = ubicacionProductoDao.obtenerPorId(baseDatos.getFkubicacionproducto());
            ProveedorProducto proveedorProducto = proveedorProductoDao.obtenerPorId(baseDatos.getFkproveedorproducto());

            BaseDatosTabla baseDatosTabla = new BaseDatosTabla(
                    nombreProducto.getNombre(),
                    marcaProducto.getMarca(),
                    categoriaProducto.getCategoria(),
                    medidaProducto.getMedida(),
                    ubicacionProducto.getUbicacion(),
                    proveedorProducto.getProveedor(),
                    baseDatos.getStock()
            );
            datosTabla.add(baseDatosTabla);
            } catch (Exception e) {
            }
        }
        return datosTabla;
    }

    private void cargarDatosTabla() {
        List<BaseDatosTabla> datosTabla = obtenerDatosTabla();
         DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Nombre Producto");
    model.addColumn("Marca");
    model.addColumn("Categoría");
    model.addColumn("Medida");
    model.addColumn("Ubicación");
    model.addColumn("Proveedor");
    model.addColumn("Stock");

    for (BaseDatosTabla dato : datosTabla) {
        model.addRow(new Object[]{
                dato.getNombreProducto(),
                dato.getMarcaProducto(),
                dato.getCategoriaProducto(),
                dato.getMedidaProducto(),
                dato.getUbicacionProducto(),
                dato.getProveedorProducto(),
                dato.getStock()
        });
    }
    tablaInventario.setModel(model); 
      
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();
        actualizar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaInventario);

        actualizar.setText("Actualizar");
        actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(actualizar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseClicked
        cargarDatosTabla();
    }//GEN-LAST:event_actualizarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaInventario;
    // End of variables declaration//GEN-END:variables
}
