/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;

/**
 *
 * @author Jesus
 */
public class AdminDaoImp implements AdminDao{

    @Override
    public List listarPedidos() {
        String sql="{call listarPedidos()}";
        return Operacion.listar(sql);
    }
    @Override
    public String cobrarPedido(String codPed){
        String sql="{call PedidoPagado('"+codPed+"')}";
        return Operacion.ejecutar(sql);
    
    }
    
}
