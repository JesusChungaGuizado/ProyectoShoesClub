/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Jesus
 */
public class Cliente extends Usuario{
    public Cliente() {
    }
    public Cliente(String nombre, String email, String celular, String direccion, String usuario, String password) {
        super(nombre, email, celular, direccion, usuario, password);
    }
}
