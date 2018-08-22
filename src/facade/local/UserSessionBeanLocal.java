/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.local;

import dto.Cliente;
import dto.Constante;
import dto.Factura;
import dto.Perfil;
import dto.Producto;
import dto.RelFacturaProducto;
import dto.Usuario;
import java.util.List;
import util.FacturaReport;

/**
 *
 * @author Adonis
 */
public interface UserSessionBeanLocal {

    public Usuario getUser(String name, String pass);

    public List<Usuario> getUsers();

    public void saveUser(Usuario user);

    public List<Perfil> getPerfiles();

    public Perfil getPerfil(String perfil);

    public Usuario getUser(String name);

    public List<Producto> getProductos(String busqueda);

    public Producto getProducto(int index);

    public void saveProducto(Producto producto);

    public void saveCliente(Cliente cliente);

    public List<Cliente> getClientes(String busqueda);

    public Cliente getCliente(int index);

    public Producto getProducto(String descripcion);

    public Cliente getClienteByCedula(int cedula);

    public List<Constante> getConstantes();

    public void saveConstante(Constante constante);

    public String[] listaLabelsClientes(String busqueda);

    public String[] listaLabelsProductos(String busqueda);

    public String[] listaLabelsRelFacturaProducto(List<RelFacturaProducto> relFacturaProductos);

    /**
     * Metodo que calcula el precio total que hay en un listado de productos.
     *
     * @param listRelFacturaProductos lista a calcular
     * @return precio total
     */
    public String total(List<RelFacturaProducto> listaRelFacturaProductos);

    /**
     * Metodo que calcula la cantidad de productos en un listado, comprueba la
     * cantidad que posee el producto, verifica cuantos de esos productos estan
     * en el listado y devuelve la cantidad de productos menos la cantidad
     * encontrada en el listado.
     *
     * @param listRelFacturaProductos lista de productos a calcular
     * @param producto producto a verificar cantidad
     * @return devuelve la cantidad de productos disponibles
     */
    public Integer cantidadProducto(List<RelFacturaProducto> listRelFacturaProductos, Producto producto);

    public Double getPrecioBolivar();

    public List<RelFacturaProducto> llenarRelacion(List<RelFacturaProducto> listRelFacturaProductos);

    public Double getIva();

    public FacturaReport getFacturaReport(Factura factura);

    public void saveFactura(Factura factura);

    public Double getTotal(List<RelFacturaProducto> relFacturaProductos);

    public void saveRelFacturaProducto(List<RelFacturaProducto> relFacturaProductos);

    public String[] listLabelFacturas(List<Factura> facturas);

    public String generarGuardarReporteFactura(Factura factura, List<RelFacturaProducto> relFacturaProductos);

    public String getFolder();

    public List<Factura> getFacturas();

    public String generarReporte(Factura factura);
}
