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
public class ClienteDaoImp implements ClienteDao{

    @Override
    public Cliente validarAcceso(String usuario, String pass) {
       String sql="{call ValidarCliente('"+usuario+"','"+pass+"')}";
       Object[]fil=Operacion.buscar(sql);
         if(fil!=null){
             Cliente cli=new Cliente();
             cli.setIdUsuario((int)fil[0]);
             cli.setNombre(fil[1].toString());
             cli.setEmail(fil[2].toString());
             cli.setCelular(fil[3].toString());
             cli.setDireccion(fil[4].toString());
             cli.setUsuario(fil[5].toString());
             cli.setPassword(fil[6].toString());
             cli.setPermiso((int)fil[7]);
             return cli;
         }
         return null;
    }

    @Override
    public String registrarCliente(Cliente cli) {
       String sql="{call RegistrarCliente('"+cli.getNombre()+"','"+cli.getEmail()+"','"+cli.getCelular()+"','"+cli.getDireccion()+"','"+cli.getUsuario()+"','"+cli.getPassword()+"')}";
       return Operacion.ejecutar(sql);
    }

    @Override
    public Cliente buscarCliente(String usuario) {
         String sql="{call BuscarCliente('"+usuario+"')}";
       Object[]fil=Operacion.buscar(sql);
         if(fil!=null){
             Cliente cli=new Cliente();
             cli.setIdUsuario((int)fil[0]);
             cli.setNombre(fil[1].toString());
             cli.setEmail(fil[2].toString());
             cli.setCelular(fil[3].toString());
             cli.setDireccion(fil[4].toString());
             cli.setUsuario(fil[5].toString());
             cli.setPassword(fil[6].toString());
             cli.setPermiso((int)fil[7]);
             return cli;
         }
         return null;
    }

    @Override
    public String ActualizarCliente(Cliente cli) {
       String sql="{call ActualizarCliente("+cli.getIdUsuario()+",'"+cli.getNombre()+"','"+cli.getEmail()+"','"+cli.getCelular()+"','"+cli.getDireccion()+"','"+cli.getUsuario()+"','"+cli.getPassword()+"')}";
       return Operacion.ejecutar(sql);
    }
    
}
