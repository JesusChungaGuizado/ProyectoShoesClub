/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.Producto;
/**
 *
 * @author Jesus
 */
public interface ProductoServicio {
    public List listarOfertas();
    public Producto buscarProducto(int cod);
    public List FiltrarProductos(int cat,String sexo);
    public String RegistrarProducto(Producto pro);
    public List listarProductos();
    public String eliminarProducto(int id);
    public String actualizarProducto(Producto pro);
}
