/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.LineaPedido;
import negocio.Pedido;
import negocio.Producto;

/**
 *
 * @author Jesus
 */
public class PedidoDaoImp implements PedidoDao{

    @Override
    public String grabarPedido(Pedido p) {
        String sql="{call grabarPedido('"+p.getNum()+"','"+p.getFec()+"',"+p.getTot()+","+p.getCli().getIdUsuario()+")}";
        return Operacion.ejecutar(sql);
    }

    @Override
    public String grabarDetallePedido(Pedido p, LineaPedido lp) {
        String sql="{call grabarDetallePedido('"+p.getNum()+"',"+lp.getPro().getIdProducto()+","+lp.getCan()+","+lp.getImp()+")}";
        return Operacion.ejecutar(sql);
    }

    @Override
    public List ListarPedidos() {
        String sql="{call listarPedidos()}";
        return Operacion.listar(sql);
    }

    @Override
    public Producto buscar(int cod) {
        Object[] pro = new ProductoDaoImp().buscarProducto(cod);
            if(pro!=null){
                    Producto p = new Producto ();
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
                    p.setStock((int)pro[12]);
                   return p;
            }
            
            return null;
        //return new ProductoDaoImp().buscarProducto(cod);
    }

    @Override
    public Object[] ObtenerUltimoPedido() {
       String sql="{call obtenerUltimoPedido()}";
       return Operacion.ObtenerUltimoPedido(sql);
    }

    @Override
    public Object[] GenerarCodigoPedido(int Item) {
        String sql="{call GenerarCodigo("+Item+")}";
        return Operacion.buscar(sql);
    }

    @Override
    public List VerMiPedido(int idCliente) {
        String sql="{call VerPedido("+idCliente+")}";
        return Operacion.listar(sql);
    }

    @Override
    public List verDetallePedido(String codPedido) {
        String sql="{call VerDetallePedido('"+codPedido+"')}";
        return Operacion.listar(sql);
    }

    @Override
    public Object[] verDatosPedido(String codPedido) {
        String sql="{call VerDatosPedido('"+codPedido+"')}";
        return Operacion.buscar(sql);
    }
    

   
}
