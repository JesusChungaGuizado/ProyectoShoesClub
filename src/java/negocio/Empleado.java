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
public class Empleado extends Usuario{
    private String dni;
    private int cargo;

    public Empleado() {
       
    }

    public Empleado(String dni, int cargo, String nombre, String email, String celular, String direccion, String usuario, String password) {
        super(nombre, email, celular, direccion, usuario, password);
        this.dni = dni;
        this.cargo = cargo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
    
}
