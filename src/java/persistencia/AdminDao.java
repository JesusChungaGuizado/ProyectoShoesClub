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
public interface AdminDao {
    public List listarPedidos();
    public String cobrarPedido(String codPed);
    
}
