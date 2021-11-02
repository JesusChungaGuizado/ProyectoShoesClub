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
public class ProductoDaoImp implements ProductoDao{

    @Override
    public List listarOfertas() {
        String sql="{call listarOfertas()}";
        return Operacion.listar(sql);
    }

    @Override
    public Object[] buscarProducto(int cod) {
        String sql="{call buscarCalzado("+cod+")}";
       return Operacion.buscar(sql);
    }

    @Override
    public List FiltrarProducto(int cat, String sexo) {
        String sql="{call FiltrarCalzado("+cat+",'"+sexo+"')}";
        return Operacion.listar(sql);
    }

    @Override
    public List listarProductos() {
        String sql="{call ListarCalzados()}";
        return Operacion.listar(sql);
    }

    @Override
    public String registrarProducto(Producto pro) {
        String sql="{call RegistrarCalzado('"+pro.getNombre()+"','"+pro.getMarca()+"','"+pro.getDescripcion()+"',"+pro.getPrecioNormal()+",'"+pro.getImagen()+"',"+pro.getCategoria()+",'"+pro.getSexo()+"',"+pro.getDescuento()+","+pro.getTalla()+","+pro.getStock()+")}";
        return Operacion.ejecutar(sql);
    }

    @Override
    public String eliminarProducto(int id) {
        String sql="{call EliminarCalzado("+id+")}";
        return Operacion.ejecutar(sql);
    }

    @Override
    public String actualizarProducto(Producto pro) {
        String sql="{call ActualizarCalzado("+pro.getIdProducto()+",'"+pro.getNombre()+"','"+pro.getMarca()+"','"+pro.getDescripcion()+"',"+pro.getPrecioNormal()+",'"+pro.getImagen()+"',"+pro.getCategoria()+",'"+pro.getSexo()+"',"+pro.getDescuento()+","+pro.getTalla()+","+pro.getStock()+")}";
        return Operacion.ejecutar(sql);
    }
    
}
