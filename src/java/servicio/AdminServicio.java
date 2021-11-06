/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;

/**
 *
 * @author Jesus
 */
public interface AdminServicio {
    public List listarPedidos();
    public String cobrarPedido(String codPed);
}
