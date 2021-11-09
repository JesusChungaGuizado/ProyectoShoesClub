/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.List;
import negocio.Cliente;
import persistencia.AdminDao;
import persistencia.AdminDaoImp;
import negocio.Empleado;

/**
 *
 * @author Jesus
 */
public class AdminServicioImp implements AdminServicio{
    private AdminDao admDao;

    public AdminServicioImp() {
        admDao=new AdminDaoImp();
    }
   
    
    @Override
    public List listarPedidos() {
       return admDao.listarPedidos();
    }
    @Override
    public String cobrarPedido(String codPed){
        String msg=admDao.cobrarPedido(codPed);
        if (msg==null) {
            msg="Pedido Pagado";
        }
        return msg;
    }

    @Override
    public Object[] validar(String usu, String pas) {
       Empleado cli=admDao.validarAcceso(usu, pas);
        Object[]fil=new Object[9];
        if (cli!=null ) {
            fil[0]=cli.getIdUsuario();
            fil[1]=cli.getNombre();
            fil[2]=cli.getEmail();
            fil[3]=cli.getCelular();
            fil[4]=cli.getDni();
            fil[5]=cli.getDireccion();
            fil[6]=cli.getUsuario();
            fil[7]=cli.getPassword();
            fil[8]=cli.getCargo();
            return fil;
        }
        return null;
    }

    @Override
    public List listarEmpleados() {
        return admDao.listarEmpleados();
    }

    @Override
    public String actualizarEmpleado(Empleado em) {
         String msg=admDao.actualizarEmpleado(em);
        if (msg==null) {
            msg="Datos Actualizados";
        }
        return msg;
    }

    @Override
    public String registrarEmpleado(Empleado em) {
         String msg=admDao.registrarEmpleado(em);
        if (msg==null) {
            msg="Registro Exitoso";
        }
        return msg;
    }

    @Override
    public String eliminarEmpleado(int id) {
         String msg=admDao.eliminarEmpleado(id);
        if (msg==null) {
            msg="Registro Eliminado";
        }
        return msg;
    }

    @Override
    public Empleado buscarEmpleado(int id) {
         Object[]pro=(Object[])admDao.buscarEmpleado(id);
        if (pro!=null) {
            Empleado emp=new Empleado();
              emp.setIdUsuario((int)pro[0]);
              emp.setNombre(pro[1].toString());
              emp.setEmail(pro[2].toString());
              emp.setCelular(pro[3].toString());
              emp.setDni(pro[4].toString());
              emp.setDireccion(pro[5].toString());
              emp.setUsuario(pro[6].toString());
              emp.setPassword(pro[7].toString());
              emp.setCargo((int)pro[8]);
        
            return emp;
        }
        return null;
    }

    @Override
    public List listarClientes() {
       return admDao.listarClientes();
    }

    @Override
    public String registrarCliente(Cliente cli) {
          String msg=admDao.registrarCliente(cli);
        if (msg==null) {
            msg="Registro Exitoso";
        }
        return msg;
    }

    @Override
    public String actualizarCliente(Cliente cli) {
          String msg=admDao.actualizarCliente(cli);
        if (msg==null) {
            msg="Datos Actualizados";
        }
        return msg;
    }

    @Override
    public Cliente buscarCliente(int id) {
        Object[]pro=(Object[])admDao.buscarCliente(id);
        if (pro!=null) {
            Cliente cli=new Cliente();
              cli.setIdUsuario((int)pro[0]);
              cli.setNombre(pro[1].toString());
              cli.setEmail(pro[2].toString());
              cli.setCelular(pro[3].toString());
              cli.setDireccion(pro[4].toString());
              cli.setUsuario(pro[5].toString());
              cli.setPassword(pro[6].toString());
            return cli;
        }
        return null;
    }

    @Override
    public String eliminarCliente(int id) {
       String msg=admDao.eliminarCliente(id);
        if (msg==null) {
            msg="Registro Eliminado";
        }
        return msg;
    }

    @Override
    public List verDatos() {
       return admDao.verDatos();
    }
     @Override
    public List listarConsultas(){
        return admDao.listarConsultas();
    }
    @Override
    public String eliminarConsulta(int id){
        String msg=admDao.eliminarConsulta(id);
        if (msg==null) {
            msg="Consulta Eliminada";
        }
        return msg;
    }
}
