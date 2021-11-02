/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import persistencia.ProductoDao;
import persistencia.ProductoDaoImp;
import negocio.Producto;
/**
 *
 * @author Jesus
 */
public class ProductoServicioImp implements ProductoServicio{
    private ProductoDao proDao;

    public ProductoServicioImp() {
        proDao =new ProductoDaoImp();
    }

    @Override
    public List listarOfertas() {
        return proDao.listarOfertas();
    }

    @Override
    public Producto buscarProducto(int cod) {
      
        Object[]pro=(Object[])proDao.buscarProducto(cod);
        if (pro!=null) {
              Producto p=new Producto();
            p.setIdProducto((int)pro[0]);
            p.setNombre(pro[1].toString());
            p.setMarca(pro[2].toString());
            p.setDescripcion(pro[3].toString());
            p.setPrecioNormal((double)pro[4]);
            p.setImagen(pro[5].toString());
            p.setCategoria((int)pro[6]);
            p.setOferta((int)pro[7]);
            p.setDescuento((int)pro[8]);
            p.setPrecioOferta((double)pro[9]);
            p.setTalla((int)pro[11]);
            p.setSexo(pro[10].toString());
            p.setStock((int)pro[12]);
            return p;
        }
        return null;
    }

    @Override
    public List FiltrarProductos(int cat, String sexo) {
        return proDao.FiltrarProducto(cat, sexo);
    }

    @Override
    public String RegistrarProducto(Producto pro) {
        String msg=proDao.registrarProducto(pro);
        if (msg==null) {
            msg="Producto Registrado";
        }
        return msg;
    }

    @Override
    public List listarProductos() {
        return proDao.listarProductos();
    }

    @Override
    public String eliminarProducto(int id) {
      String msg=proDao.eliminarProducto(id);
        if (msg==null) {
            msg="Producto Eliminado";
        }
        return msg;
    }

    @Override
    public String actualizarProducto(Producto pro) {
        String msg=proDao.actualizarProducto(pro);
        if (msg==null) {
            msg="Producto Actualizado";
        }
        return msg;
    }
    
}
