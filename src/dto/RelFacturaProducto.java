/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Adonis
 */
public class RelFacturaProducto {

    private int relFacturaProductoId;
    private Factura factura;
    private Producto producto;
    private Double precio;
    private Double precioIva;
    private Double precioSoloIva;

    public RelFacturaProducto() {
    }

    public Double getPrecioSoloIva() {
        return precioSoloIva;
    }

    public void setPrecioSoloIva(Double precioSoloIva) {
        this.precioSoloIva = precioSoloIva;
    }

    public Double getPrecioIva() {
        return precioIva;
    }

    public void setPrecioIva(Double precioIva) {
        this.precioIva = precioIva;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public RelFacturaProducto(Factura factura, Producto producto) {
        this.factura = factura;
        this.producto = producto;
    }

    public int getRelFacturaProductoId() {
        return relFacturaProductoId;
    }

    public void setRelFacturaProductoId(int relFacturaProductoId) {
        this.relFacturaProductoId = relFacturaProductoId;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
