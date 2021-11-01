/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import negocio.*;

/**
 *
 * @author Jesus
 */
public interface ClienteServicio {
     public Object[]validar(String usu,String pas);
     public String RegistrarCliente(Cliente cli);
      public String BuscarCliente(String usu);
      public String ActualizarCliente(Cliente cli);
}
