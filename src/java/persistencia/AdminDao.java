/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Cliente;
import negocio.Empleado;

/**
 *
 * @author Jesus
 */
public interface AdminDao {
    public List listarPedidos();
    public String cobrarPedido(String codPed);
    public Empleado validarAcceso(String usuario,String pass);
    public List listarEmpleados();
    public String actualizarEmpleado(Empleado em);
    public String registrarEmpleado(Empleado em);
    public String eliminarEmpleado(int id);
    public Object[] buscarEmpleado(int id);
    public List listarClientes();
    public String registrarCliente(Cliente cli);
    public String actualizarCliente(Cliente cli);
    public Object[] buscarCliente(int id);
    public String eliminarCliente(int id);
    public List verDatos();
    public List listarConsultas();
    public String eliminarConsulta(int id);
    
}
