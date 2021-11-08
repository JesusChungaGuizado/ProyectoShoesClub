/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.Cliente;
import negocio.Empleado;

/**
 *
 * @author Jesus
 */
public interface AdminServicio {
    public List listarPedidos();
    public String cobrarPedido(String codPed);
    public Object[]validar(String usu,String pas);
    public List listarEmpleados();
    public String actualizarEmpleado(Empleado em);
    public String registrarEmpleado(Empleado em);
    public String eliminarEmpleado(int id);
    public Empleado buscarEmpleado(int id);
    public List listarClientes();
    public String registrarCliente(Cliente cli);
    public String actualizarCliente(Cliente cli);
    public Cliente buscarCliente(int id);
    public String eliminarCliente(int id);
}
