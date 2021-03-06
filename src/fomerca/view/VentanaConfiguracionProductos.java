/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.view;

import dto.Producto;
import facade.UserSessionBean;
import facade.local.UserSessionBeanLocal;
import java.text.Format;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Adonis
 */
public class VentanaConfiguracionProductos extends javax.swing.JFrame {

    private Producto producto;
    private UserSessionBeanLocal userSessionBeanLocal = new UserSessionBean();
    private List<Producto> productos = userSessionBeanLocal.getProductos(null);
    private boolean isFactura;
    private VentanaVentas ventanaVentas;

    public boolean isIsFactura() {
        return isFactura;
    }

    public void setIsFactura(boolean isFactura) {
        this.isFactura = isFactura;
    }

    public VentanaVentas getVentanaVentas() {
        return ventanaVentas;
    }

    public void setVentanaVentas(VentanaVentas ventanaVentas) {
        this.ventanaVentas = ventanaVentas;
    }

    /**
     * Creates new form VentanaConfiguracionProductos
     */
    public VentanaConfiguracionProductos() {
        initComponents();
        setLocationRelativeTo(null);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(getClass().getResource("/resource/fondo_constante.jpg")));
        label.setAlignmentX(this.getAlignmentX());
        label.setAlignmentY(this.getAlignmentY());
        label.setSize(this.getSize());
        this.add(label);

        String[] stringProductos = userSessionBeanLocal.listaLabelsProductos(null);
        listaProductos.setListData(stringProductos);
        listaProductos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
//                producto = userSessionBeanLocal.getProducto(listaProductos.getSelectedValue().split(" - ")[1].trim());
//                buttonEditar.setEnabled(producto != null);
                producto = productos.get(listaProductos.getSelectedIndex());
                textFieldNombreProducto.setText(producto.getDescripcion());
                textFieldPrecioBase.setText("" + producto.getPrecioBase());
                textFieldPrecioVenta.setText("" + producto.getPrecioVenta());
                textFieldMarca.setText("" + producto.getMarca());
                textFieldModelo.setText("" + producto.getModelo());
                spinnerCantidad.setValue(producto.getCantidad() != null
                        ? producto.getCantidad().intValue() : 0);
                textFieldCodigoProducto.setText("" + producto.getCodigo());
                buttonAgregar.setText("Editar");
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JList<>();
        buttonAgregar = new javax.swing.JButton();
        buttonEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textFieldNombreProducto = new javax.swing.JTextField();
        textFieldCodigoProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textFieldPrecioBase = new javax.swing.JFormattedTextField();
        textFieldPrecioVenta = new javax.swing.JFormattedTextField();
        buttonVolver = new javax.swing.JButton();
        buttonLimpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textFieldModelo = new javax.swing.JTextField();
        textFieldMarca = new javax.swing.JTextField();
        spinnerCantidad = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Productos");

        listaProductos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaProductos);

        buttonAgregar.setBackground(new java.awt.Color(102, 0, 0));
        buttonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        buttonAgregar.setText("Agregar");
        buttonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarActionPerformed(evt);
            }
        });

        buttonEliminar.setBackground(new java.awt.Color(102, 0, 0));
        buttonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        buttonEliminar.setText("Eliminar");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del producto:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Código:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Costo:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio venta:");

        textFieldPrecioBase.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        textFieldPrecioVenta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        buttonVolver.setBackground(new java.awt.Color(102, 0, 0));
        buttonVolver.setForeground(new java.awt.Color(255, 255, 255));
        buttonVolver.setText("Volver");
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed(evt);
            }
        });

        buttonLimpiar.setBackground(new java.awt.Color(102, 0, 0));
        buttonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        buttonLimpiar.setText("Limpiar");
        buttonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimpiarActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Modelo:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Marca:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cantidad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                        .addComponent(buttonVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldNombreProducto))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textFieldCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldPrecioBase, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(119, 119, 119)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(textFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPrecioBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(textFieldPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAgregar)
                    .addComponent(buttonEliminar)
                    .addComponent(buttonVolver)
                    .addComponent(buttonLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarActionPerformed
        if ((Integer) spinnerCantidad.getValue() < 0) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor o igual a 1.");
            return;
        }
        if (textFieldNombreProducto.getText() != null && !textFieldNombreProducto.getText().equals("")
                && textFieldCodigoProducto.getText() != null && !textFieldCodigoProducto.getText().equals("")
                && textFieldPrecioBase.getText() != null && !textFieldPrecioBase.getText().equals("")
                && textFieldPrecioVenta.getText() != null && !textFieldPrecioVenta.getText().equals("")) {
            if (Double.parseDouble(textFieldPrecioBase.getText().replace(",", "")) > 0
                    && Double.parseDouble(textFieldPrecioVenta.getText().replace(",", "")) > 0) {
                if (producto != null) {

                    if (JOptionPane.showConfirmDialog(null, "Desea EDITAR este producto? \n"
                            + textFieldNombreProducto.getText()
                            + "\nPrecio base: " + textFieldPrecioBase.getText() + "$"
                            + "\nPrecio venta: " + textFieldPrecioVenta.getText() + "$"
                            + "\nCodigo del producto: " + textFieldCodigoProducto.getText()
                            + "\nCantidad: " + spinnerCantidad.getValue().toString()) == 0) {
                        producto.setDescripcion(textFieldNombreProducto.getText());
                        producto.setPrecioBase(Double.parseDouble(textFieldPrecioBase.getText().replace(",", "")));
                        producto.setPrecioVenta(Double.parseDouble(textFieldPrecioVenta.getText().replace(",", "")));
                        producto.setMarca(textFieldMarca.getText() != null
                                && !textFieldMarca.getText().equals("")
                                ? textFieldMarca.getText() : "");
                        producto.setModelo(textFieldModelo.getText() != null
                                && !textFieldModelo.getText().equals("")
                                ? textFieldModelo.getText() : "");
                        producto.setCantidad((Integer) spinnerCantidad.getValue());
                        producto.setCodigo(textFieldCodigoProducto.getText());
                        producto.setActivo(Boolean.TRUE);
                        userSessionBeanLocal.saveProducto(producto);
                        recargar();
                    }
                } else {
                    if (JOptionPane.showConfirmDialog(null, "Desea guardar este NUEVO producto? \n"
                            + textFieldNombreProducto.getText()
                            + "\nPrecio base: " + textFieldPrecioBase.getText() + "$"
                            + "\nPrecio venta: " + textFieldPrecioVenta.getText() + "$"
                            + "\nCodigo del producto: " + textFieldCodigoProducto.getText()
                            + "\nCantidad: " + spinnerCantidad.getValue().toString()) == 0) {
                        Producto newProducto = new Producto(textFieldNombreProducto.getText(),
                                Double.parseDouble(textFieldPrecioBase.getText().replace(",", "")),
                                Double.parseDouble(textFieldPrecioVenta.getText().replace(",", "")),
                                textFieldCodigoProducto.getText());
                        newProducto.setActivo(Boolean.TRUE);
                        newProducto.setMarca(textFieldMarca.getText() != null
                                && !textFieldMarca.getText().equals("")
                                ? textFieldMarca.getText() : "");
                        newProducto.setModelo(textFieldModelo.getText() != null
                                && !textFieldModelo.getText().equals("")
                                ? textFieldModelo.getText() : "");
                        newProducto.setCantidad((Integer) spinnerCantidad.getValue());
                        newProducto.setCantidad((Integer) spinnerCantidad.getValue());
                        userSessionBeanLocal.saveProducto(newProducto);
                        recargar();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Precio y costo debe ser mayo o igual a 1.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.");
        }
    }//GEN-LAST:event_buttonAgregarActionPerformed

    private void buttonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimpiarActionPerformed
        producto = null;
        textFieldCodigoProducto.setText(null);
        textFieldNombreProducto.setText(null);
        textFieldModelo.setText(null);
        textFieldMarca.setText(null);
        spinnerCantidad.setValue(null);
        textFieldPrecioBase.setText(null);
        textFieldPrecioVenta.setText(null);
        buttonAgregar.setText("Agregar");
    }//GEN-LAST:event_buttonLimpiarActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        if (producto != null) {
            if (JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar este producto?."
                    + "\n" + producto.getDescripcion()
                    + "\nCódigo: " + producto.getCodigo()
                    + "\nPrecio base: " + producto.getPrecioBase() + "$"
                    + "\nPrecio venta: " + producto.getPrecioVenta() + "$") == 0) {
                producto.setActivo(Boolean.FALSE);
                userSessionBeanLocal.saveProducto(producto);
                recargar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto.");
        }
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolverActionPerformed
        if (isFactura) {
            if (ventanaVentas != null) {
                ventanaVentas.recargar();
            }
            this.setVisible(false);
        }
        VentanaMenu ventanaMenu = new VentanaMenu();
        ventanaMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaConfiguracionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaConfiguracionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaConfiguracionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaConfiguracionProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaConfiguracionProductos().setVisible(true);
            }
        });
    }

    private void recargar() {
        VentanaConfiguracionProductos ventanaConfiguracionProductos
                = new VentanaConfiguracionProductos();
        ventanaConfiguracionProductos.setVentanaVentas(ventanaVentas);
        ventanaConfiguracionProductos.setIsFactura(isFactura);
        ventanaConfiguracionProductos.setVisible(true);
        this.setVisible(false);
        try {
            finalize();
        } catch (Throwable ex) {
            Logger.getLogger(VentanaConfiguracionProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAgregar;
    private javax.swing.JButton buttonEliminar;
    private javax.swing.JButton buttonLimpiar;
    private javax.swing.JButton buttonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaProductos;
    private javax.swing.JSpinner spinnerCantidad;
    private javax.swing.JTextField textFieldCodigoProducto;
    private javax.swing.JTextField textFieldMarca;
    private javax.swing.JTextField textFieldModelo;
    private javax.swing.JTextField textFieldNombreProducto;
    private javax.swing.JFormattedTextField textFieldPrecioBase;
    private javax.swing.JFormattedTextField textFieldPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
