/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Producto;

/**
 *
 * @author Jesus
 */
public interface ProductoDao {
    public List listarOfertas();
    public Object[]buscarProducto(int cod);
    public List FiltrarProducto(int cat,String sexo);
    public List listarProductos();
    public String registrarProducto(Producto pro);
    public String eliminarProducto(int id);
    public String actualizarProducto(Producto pro);
}
