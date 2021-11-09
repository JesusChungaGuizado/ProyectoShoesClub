/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import negocio.*;
import persistencia.*;

/**
 *
 * @author Jesus
 */
public class ClienteServicioImp implements ClienteServicio{
    private ClienteDao cliDao;

    public ClienteServicioImp() {
        cliDao=new ClienteDaoImp();
    }
    
    
    @Override
    public Object[] validar(String usu, String pas) {
        Cliente cli=cliDao.validarAcceso(usu, pas);
        Object[]fil=new Object[8];
        if (cli!=null ) {
            fil[0]=cli.getIdUsuario();
            fil[1]=cli.getNombre();
            fil[2]=cli.getEmail();
            fil[3]=cli.getCelular();
            fil[4]=cli.getDireccion();
            fil[5]=cli.getUsuario();
            fil[6]=cli.getPassword();
            return fil;
        }
        return null;
    }

    @Override
    public String RegistrarCliente(Cliente cli) {
        String msg=cliDao.registrarCliente(cli);
        if (msg==null) {
            msg="Registro Exitoso";
        }
        return msg;
    }

    @Override
    public String BuscarCliente(String usu) {
        Cliente cli=cliDao.buscarCliente(usu);
        if (cli!=null ) {
            return "Este usuario ya existe";
        }
        return null;
    }

    @Override
    public String ActualizarCliente(Cliente cli) {
        String msg=cliDao.ActualizarCliente(cli);
        if (msg==null) {
            msg="Datos Actualizados";
        }
        return msg;
    }

    @Override
    public String RegistrarConsulta(String nom, String correo, String cel, String asunto, String consulta) {
        String msg=cliDao.RegistrarConsulta(nom, correo, cel, asunto, consulta);
        if (msg==null) {
            msg="Consulta Registrada";
        }
        return msg;
    }
   
}
