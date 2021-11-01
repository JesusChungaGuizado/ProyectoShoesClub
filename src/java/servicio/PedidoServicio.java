/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.io.OutputStream;
import java.util.List;
import negocio.Producto;

/**
 *
 * @author Jesus
 */
public interface PedidoServicio {
    // public Object[] nuevoPedido(int cod);
    public List agregarArticulos(int idProd, int can);
    public List restarArticulos(int idProd, int can);
    public List quitarArticulo(String cod);
   // public List listarArticulos();
    //public Object[] buscarCliente(int cod);
    public String grabarPedido(int cod);
    public void NuevoPedido();
    public void GenerarBoletaPedido(OutputStream out,String codPedido);
    public  List VerMisPedidos(int codCli);
}
