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
            return p;
        }
        return null;
    }
    
}
