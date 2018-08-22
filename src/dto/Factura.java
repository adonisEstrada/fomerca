/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Adonis
 */
public class Factura {

    private int facturaId;
    private String codigo;
    private Date fecha;
    private Cliente cliente;
    private Double total;
    private Set<RelFacturaProducto> relFacturaProductos = new HashSet<RelFacturaProducto>();

    public Set<RelFacturaProducto> getRelFacturaProductos() {
        return relFacturaProductos;
    }

    public void setRelFacturaProductos(Set<RelFacturaProducto> relFacturaProductos) {
        this.relFacturaProductos = relFacturaProductos;
    }


    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(int facturaId) {
        this.facturaId = facturaId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Factura() {
    }

    public Factura(String codigo, Date fecha, Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public Factura(Date fecha, Cliente cliente) {
        this.fecha = fecha;
        this.cliente = cliente;
    }

}
