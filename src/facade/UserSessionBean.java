/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.Cliente;
import dto.Constante;
import dto.Factura;
import dto.Perfil;
import dto.Producto;
import dto.RelFacturaProducto;
import dto.Usuario;
import facade.local.UserSessionBeanLocal;
import fomerca.dao.ClienteDAO;
import fomerca.dao.ConstanteDAO;
import fomerca.dao.FacturaDAO;
import fomerca.dao.PerfilDAO;
import fomerca.dao.ProductoDAO;
import fomerca.dao.RelFacturaProductoDAO;
import fomerca.dao.UserDAO;
import fomerca.dao.impl.ClienteDAOImpl;
import fomerca.dao.impl.ConstanteDAOImpl;
import fomerca.dao.impl.FacturaDAOImpl;
import fomerca.dao.impl.PerfilDAOImpl;
import fomerca.dao.impl.ProductoDAOImpl;
import fomerca.dao.impl.RelFacturaProductoDAOImpl;
import fomerca.dao.impl.UserDAOImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import util.FacturaReport;
import util.JasperUtil;

/**
 *
 * @author Adonis
 */
public class UserSessionBean implements UserSessionBeanLocal {

    UserDAO userDAO = new UserDAOImpl();
    PerfilDAO perfilDAO = new PerfilDAOImpl();
    ProductoDAO productoDAO = new ProductoDAOImpl();
    ClienteDAO clienteDAO = new ClienteDAOImpl();
    ConstanteDAO constanteDAO = new ConstanteDAOImpl();
    FacturaDAO facturaDAO = new FacturaDAOImpl();
    RelFacturaProductoDAO relFacturaProductoDAO = new RelFacturaProductoDAOImpl();

    @Override
    public Usuario getUser(String name, String pass) {
        return userDAO.getUser(name, pass);
    }

    @Override
    public List<Usuario> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public void saveUser(Usuario user) {
        userDAO.save(user);
    }

    @Override
    public List<Perfil> getPerfiles() {
        return perfilDAO.getPerfiles();
    }

    @Override
    public Perfil getPerfil(String perfil) {
        return perfilDAO.getPerfil(perfil);
    }

    @Override
    public Usuario getUser(String name) {
        return userDAO.getUser(name);
    }

    @Override
    public List<Producto> getProductos(String busqueda) {
        if (busqueda != null && !busqueda.equals("")) {
            return productoDAO.getProductos(busqueda);
        } else {
            return productoDAO.getProductos();
        }
    }

    @Override
    public Producto getProducto(int index) {
        return productoDAO.getProducto(index);
    }

    @Override
    public void saveProducto(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteDAO.save(cliente);
    }

    @Override
    public List<Cliente> getClientes(String busqueda) {
        if (busqueda != null && !busqueda.equals("")) {
            return clienteDAO.getClientes(busqueda);
        } else {
            return clienteDAO.getClientes();
        }
    }

    @Override
    public Cliente getCliente(int index) {
        return clienteDAO.getCliente(index);
    }

    @Override
    public Producto getProducto(String descripcion) {
        return productoDAO.getProducto(descripcion);
    }

    @Override
    public Cliente getClienteByCedula(int cedula) {
        return clienteDAO.getClienteByCedula(cedula);
    }

    @Override
    public List<Constante> getConstantes() {
        return constanteDAO.getConstantes();
    }

    @Override
    public void saveConstante(Constante constante) {
        constanteDAO.save(constante);
    }

    @Override
    public String[] listaLabelsClientes(String busqueda) {
        List<Cliente> clientes = new ArrayList<Cliente>();
        if (busqueda != null && !busqueda.equals("")) {
            clientes = clienteDAO.getClientes(busqueda);
        } else {
            clientes = clienteDAO.getClientes();
        }
        String[] stringClientes = new String[clientes.size()];
        for (int i = 0; i < clientes.size(); i++) {
            stringClientes[i] = clientes.get(i).getCedula() + " - "
                    + clientes.get(i).getNombre() + " - "
                    + clientes.get(i).getApellido();
        }
        return stringClientes;
    }

    @Override
    public String[] listaLabelsProductos(String busqueda) {
        List<Producto> productos = new ArrayList<Producto>();
        if (busqueda != null && !busqueda.equals("")) {
            productos = productoDAO.getProductos(busqueda);
        } else {
            productos = productoDAO.getProductos();
        }
        String[] stringClientes = new String[productos.size()];
        for (int i = 0; i < productos.size(); i++) {
            stringClientes[i] = productos.get(i).getCodigo() + " - "
                    + productos.get(i).getDescripcion() + " - "
                    + productos.get(i).getModelo() + " - "
                    + productos.get(i).getMarca() + " - "
                    + productos.get(i).getCantidad() + " - "
                    + productos.get(i).getPrecioVenta() + "$ - "
                    + String.format("%.2f", productos.get(i).getPrecioVenta()
                            * getPrecioBolivar());
        }
        return stringClientes;
    }

    @Override
    public String[] listaLabelsRelFacturaProducto(List<RelFacturaProducto> relFacturaProductos) {
//        List<Producto> productos = new ArrayList<Producto>();
//        if (busqueda != null && !busqueda.equals("")) {
//            productos = productoDAO.getProductos(busqueda);
//        } else {
//            productos = productoDAO.getProductos();
//        }
        String[] stringRelFacturaProductos = new String[relFacturaProductos.size()];
        for (int i = 0; i < relFacturaProductos.size(); i++) {
            stringRelFacturaProductos[i] = relFacturaProductos.get(i).getProducto().getCodigo() + " - "
                    + relFacturaProductos.get(i).getProducto().getDescripcion() + " - "
                    + relFacturaProductos.get(i).getProducto().getModelo() + " - "
                    + relFacturaProductos.get(i).getProducto().getMarca() + " - "
                    + relFacturaProductos.get(i).getProducto().getPrecioVenta() + " = "
                    + String.format("%.2f", relFacturaProductos.get(i).getProducto().getPrecioVenta()
                            * getPrecioBolivar());
        }
        return stringRelFacturaProductos;
    }

    @Override
    public String total(List<RelFacturaProducto> listaRelFacturaProductos) {
        double total = 0f;
        for (RelFacturaProducto listaRelFacturaProducto : listaRelFacturaProductos) {
            total = total + listaRelFacturaProducto.getProducto().getPrecioVenta();
        }
        return "" + total + "$" + " = " + String.format("%.2f", getPrecioBolivar() * total) + "BsS";
    }

    @Override
    public Integer cantidadProducto(List<RelFacturaProducto> listRelFacturaProductos, Producto producto) {
        int cantidad = 0;
        for (RelFacturaProducto listRelFacturaProducto : listRelFacturaProductos) {
            if (listRelFacturaProducto.getProducto().equals(producto)) {
                cantidad++;
            }
        }
        return producto.getCantidad() - cantidad;
    }

    @Override
    public Double getPrecioBolivar() {
        Constante constante = constanteDAO.getConstante("bolivar");
        if (constante != null) {
            return Double.valueOf(constante.getValue());
        } else {
            return 0d;
        }
    }

    @Override
    public List<RelFacturaProducto> llenarRelacion(List<RelFacturaProducto> listRelFacturaProductos) {
        for (RelFacturaProducto listRelFacturaProducto : listRelFacturaProductos) {
            listRelFacturaProducto.setPrecio(getPrecioBolivar()
                    * listRelFacturaProducto.getProducto().getPrecioVenta());
            listRelFacturaProducto.setPrecioIva(listRelFacturaProducto.getPrecio() * getIva()
                    + listRelFacturaProducto.getPrecio());
            listRelFacturaProducto.setPrecioSoloIva(listRelFacturaProducto.getPrecio() * getIva());
        }
        return listRelFacturaProductos;
    }

    @Override
    public Double getIva() {
        Constante constante = constanteDAO.getConstante("iva");
        if (constante != null) {
            return Double.valueOf(constante.getValue()) / 100;
        } else {
            return 0d;
        }
    }

    @Override
    public FacturaReport getFacturaReport(Factura factura) {
        factura.setFecha(new Date());
        FacturaReport facturaReport = new FacturaReport();
        facturaReport.setCliente(factura.getCliente());
        facturaReport.setRelFacturaProductos(new ArrayList<RelFacturaProducto>(factura.getRelFacturaProductos()));
        facturaReport.setIva("" + (getIva().doubleValue() * 100) + "%");
        double totalSinIva = 0;
        double totalIva = 0;
        for (RelFacturaProducto relFacturaProducto : factura.getRelFacturaProductos()) {
            totalIva = totalIva + relFacturaProducto.getPrecioSoloIva();
            totalSinIva = totalSinIva + relFacturaProducto.getPrecio();
        }
        facturaReport.setTotalSinIva(String.format("%.2f%s", totalSinIva, "BsS"));
        facturaReport.setTotalConIva(String.format("%.2f%s", (totalIva + totalSinIva), "BsS"));
        facturaReport.setTotalIva(String.format("%.2f%s", totalIva, "BsS"));
        facturaReport.setFecha(factura.getFecha());
        return facturaReport;
    }

    @Override
    public void saveFactura(Factura factura) {
        facturaDAO.save(factura);
    }

    @Override
    public Double getTotal(List<RelFacturaProducto> relFacturaProductos) {
        double totalIva = 0;
        double totalSinIva = 0;
        for (RelFacturaProducto relFacturaProducto : relFacturaProductos) {
            totalIva = totalIva + relFacturaProducto.getPrecioSoloIva();
            totalSinIva = totalSinIva + relFacturaProducto.getPrecio();
        }
        return totalIva + totalSinIva;
    }

    @Override
    public void saveRelFacturaProducto(List<RelFacturaProducto> relFacturaProductos) {
        relFacturaProductoDAO.saveRelFacturaProductos(relFacturaProductos);
    }

    @Override
    public String[] listLabelFacturas(List<Factura> facturas) {
        String[] stringFacturas = new String[facturas.size()];
        for (int i = 0; i < facturas.size(); i++) {
            stringFacturas[i] = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy").format(facturas.get(i).getFecha()) + " - "
                    + facturas.get(i).getCliente().getNombreCompleto() + " - "
                    + String.format("%.2f", facturas.get(i).getTotal());
        }
        return stringFacturas;
    }

    @Override
    public String generarGuardarReporteFactura(Factura factura, List<RelFacturaProducto> relFacturaProductos) {
        factura.setRelFacturaProductos(new HashSet<RelFacturaProducto>(llenarRelacion(relFacturaProductos)));
        factura.setFecha(new Date());
        factura.setTotal(getTotal(relFacturaProductos));
        List<Producto> productos = new ArrayList<Producto>();
        for (RelFacturaProducto relFacturaProducto : relFacturaProductos) {
            Producto producto = relFacturaProducto.getProducto();
            producto.setCantidad(cantidadProducto(relFacturaProductos, producto));
            productos.add(producto);
        }
        for (Producto producto : productos) {
            saveProducto(producto);
        }
        saveFactura(factura);
        saveRelFacturaProducto(relFacturaProductos);
        return JasperUtil.generarReposte(getFacturaReport(factura), getFolder());
    }

    @Override
    public String getFolder() {
        Constante constante = constanteDAO.getConstante("folder");
        if (constante != null) {
            return constante.getValue();
        } else {
            return "";
        }
    }

    @Override
    public List<Factura> getFacturas() {
        return facturaDAO.getFacturas();
    }

    @Override
    public String generarReporte(Factura factura) {
        JasperUtil.generarReporteTemporal(getFacturaReport(factura));
        return "";
    }
}
