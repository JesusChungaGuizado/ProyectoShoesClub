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
public class AdminDaoImp implements AdminDao {

    @Override
    public List listarPedidos() {
        String sql = "{call ListarPedidos()}";
        return Operacion.listar(sql);
    }

    @Override
    public String cobrarPedido(String codPed) {
        String sql = "{call PedidoPagado('" + codPed + "')}";
        return Operacion.ejecutar(sql);

    }

    @Override
    public Empleado validarAcceso(String usuario, String pass) {
        String sql = "{call ValidarEmpleado('" + usuario + "','" + pass + "')}";
        Object[] fil = Operacion.buscar(sql);
        if (fil != null) {
            Empleado emp = new Empleado();
            emp.setIdUsuario((int) fil[0]);
            emp.setNombre(fil[1].toString());
            emp.setEmail(fil[2].toString());
            emp.setCelular(fil[3].toString());
            emp.setDni(fil[4].toString());
            emp.setDireccion(fil[5].toString());
            emp.setUsuario(fil[6].toString());
            emp.setPassword(fil[7].toString());
            emp.setCargo((int) fil[8]);
            return emp;
        }
        return null;
    }

    @Override
    public List listarEmpleados() {
         String sql = "{call ListarEmpleados()}";
        return Operacion.listar(sql);
    }

    @Override
    public String actualizarEmpleado(Empleado em) {
        String sql="{call ActualizarEmpleado("+em.getIdUsuario()+",'"+em.getNombre()+"','"+em.getEmail()+"','"+em.getCelular()+"','"+em.getDni()+"','"+em.getDireccion()+"','"+em.getUsuario()+"','"+em.getPassword()+"',"+em.getCargo()+")}";
       return Operacion.ejecutar(sql);
    }

    @Override
    public String registrarEmpleado(Empleado em) {
         String sql="{call RegistrarEmpleado('"+em.getNombre()+"','"+em.getEmail()+"','"+em.getCelular()+"','"+em.getDni()+"','"+em.getDireccion()+"','"+em.getUsuario()+"','"+em.getPassword()+"',"+em.getCargo()+")}";
       return Operacion.ejecutar(sql);
    }

    @Override
    public String eliminarEmpleado(int id) {
       String sql="{call EliminarEmpleado("+id+")}";
       return Operacion.ejecutar(sql);
    }

    @Override
    public Object[] buscarEmpleado(int id) {
          String sql="{call BuscarEmpleado("+id+")}";
          return Operacion.buscar(sql);
    }

    @Override
    public List listarClientes() {
        String sql = "{call ListarCliente()}";
        return Operacion.listar(sql);
    }

    @Override
    public String registrarCliente(Cliente cli) {
        return new ClienteDaoImp().registrarCliente(cli);
    }

    @Override
    public String actualizarCliente(Cliente cli) {
       return new ClienteDaoImp().ActualizarCliente(cli);
    }

    @Override
    public Object[] buscarCliente(int id) {
        String sql="{call BuscarClienteId("+id+")}";
          return Operacion.buscar(sql);
    }

    @Override
    public String eliminarCliente(int id) {
         String sql="{call EliminarCliente("+id+")}";
         return Operacion.ejecutar(sql);
    }

}
