/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import persistencia.AdminDao;
import persistencia.AdminDaoImp;

/**
 *
 * @author Jesus
 */
public class AdminServicioImp implements AdminServicio{
    private AdminDao admDao;

    public AdminServicioImp() {
        admDao=new AdminDaoImp();
    }
   
    
    @Override
    public List listarPedidos() {
       return admDao.listarPedidos();
    }
    @Override
    public String cobrarPedido(String codPed){
        String msg=admDao.cobrarPedido(codPed);
        if (msg==null) {
            msg="Pedido Pagado";
        }
        return msg;
    }
}
