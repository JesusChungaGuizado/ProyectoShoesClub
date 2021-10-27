/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.Cliente;

/**
 *
 * @author Jesus
 */
public interface ClienteDao {
    public Cliente validarAcceso(String usuario,String pass);
    public String registrarCliente(Cliente cli);
    public Cliente buscarCliente(String usuario);
}
