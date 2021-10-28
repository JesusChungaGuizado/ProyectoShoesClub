/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.sql.Connection;
import negocio.Cliente;
import persistencia.Conexion;

/**
 *
 * @author Jesus
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Conexion con =new Conexion();
        Connection cn=con.getConexion();
        if (cn!=null) {
            System.out.println("Si hay conexion Shoes");
        }else{
            System.out.println("No hay conexion");
                  
        }
      ClienteServicio cs=new ClienteServicioImp();
    
//       Object[] fil =  cs.validar("Jesus", "741d18013");
//                if(fil!=null ){
//                    System.out.println(fil[0]);
//                     System.out.println(fil[1]);
//                      System.out.println(fil[2]);
//                      System.out.println(fil[3]);
//                      System.out.println(fil[4]);
//                      System.out.println(fil[5]);
//                      System.out.println(fil[6]);
//                      System.out.println(fil[7]);
//                     
//                }else{
//                    System.out.println("usuario no encontrado");
//                }
//String busqueda =cs.BuscarCliente("Jesus");
//if ( busqueda !=null) {
//             System.out.println("si existe");
//        }else{
//      System.out.println("No exites");
//}
       
        PedidoServicioImp p=new PedidoServicioImp();
//        System.out.println(   p.generarCodigo());
    }
    
}
