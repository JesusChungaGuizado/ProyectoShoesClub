/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import negocio.*;
import persistencia.PedidoDao;
import persistencia.PedidoDaoImp;





/**
 *
 * @author Jesus
 */
public class PedidoServicioImp implements PedidoServicio{
    private Pedido ped;
    private PedidoDao pdao;

    public PedidoServicioImp() {
       pdao = new PedidoDaoImp();
      
    }
    @Override
    public void NuevoPedido(){
     ped=new Pedido();
    }

    @Override
    public List agregarArticulos(int idProduc, int can) {
        
        Producto pro=pdao.buscar(idProduc);
        ped.agregarLinea(pro, can);
        return verCesta();
    }
     @Override
    public List restarArticulos(int idProdc, int can) {
        Producto pro=pdao.buscar(idProdc);
        ped.restarLinea(pro, can);
        return verCesta();
    }

    @Override
    public List quitarArticulo(String cod) {
        ped.quitarLinea(cod);
        return verCesta();
    }
    private String getFec(){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(new Date());
    }
    private String generarCodigo(){
        Object[] cod= pdao.ObtenerUltimoPedido();
        String text=cod[0].toString();
        String numbers = text.length() <= 5 ? text : text.substring(text.length() - 5);
        Object[]codGenerado=pdao.GenerarCodigoPedido(Integer.parseInt(numbers));
        return codGenerado[0].toString();
       
    }
   
    private List verCesta(){
        List lis=new ArrayList();
        for (int i = 0; i < ped.getCes().size(); i++) {
            LineaPedido lin=(LineaPedido)ped.getCes().get(i);
            Object[]fil=new Object[11];
            //fil[0]=lin.getPro().getId();
            fil[0]=lin.getPro().getNombre();
            fil[1]=lin.getPro().getImagen();
            fil[2]=lin.getPro().getPrecioOferta();
            fil[3]=lin.getPro().getPrecioNormal();
            fil[4]=lin.getCan();
            fil[5]=lin.getImp();
            fil[6]=ped.getSubtotal();
            fil[7]=ped.getTotDesc();
            fil[8]=ped.getTot();
            fil[9]=lin.getPro().getIdProducto();
            fil[10]=lin.getPro().getOferta();
            lis.add(fil);
        }
        return lis;
    }
    @Override
    public String grabarPedido(int codCliente) {
        String msg;
        ped.setNum(generarCodigo());
        ped.setFec(getFec());
        Cliente cli=new Cliente();
        cli.setIdUsuario(codCliente);
        ped.setCli(cli);
        msg=new PedidoDaoImp().grabarPedido(ped);
        if(msg==null){
            msg="El Pedido ha sido Grabado";
        }
        for (int i = 0; i < ped.getCes().size(); i++) {
            LineaPedido lp=(LineaPedido)ped.getCes().get(i);
            msg=new PedidoDaoImp().grabarDetallePedido(ped, lp);
            if(msg==null){
                msg="El Detalle ha sido grabado";
            }
        }
     
        return msg;
    }

   
   
}