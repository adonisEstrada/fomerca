/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dto.Cliente;
import dto.Factura;
import dto.RelFacturaProducto;
import java.util.Date;
import java.util.List;

/**
 * Clase utilitaria para organizar la informacion a enviar para el reporte
 *
 * @author Adonis
 */
public class FacturaReport {

    private Factura factura;
    private Cliente cliente;
    private List<RelFacturaProducto> relFacturaProductos;
    private String iva;
    private String totalSinIva;
    private String totalConIva;
    private String totalIva;
    private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(String totalIva) {
        this.totalIva = totalIva;
    }

    public FacturaReport() {
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getTotalSinIva() {
        return totalSinIva;
    }

    public void setTotalSinIva(String totalSinIva) {
        this.totalSinIva = totalSinIva;
    }

    public String getTotalConIva() {
        return totalConIva;
    }

    public void setTotalConIva(String totalConIva) {
        this.totalConIva = totalConIva;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<RelFacturaProducto> getRelFacturaProductos() {
        return relFacturaProductos;
    }

    public void setRelFacturaProductos(List<RelFacturaProducto> relFacturaProductos) {
        this.relFacturaProductos = relFacturaProductos;
    }

}
