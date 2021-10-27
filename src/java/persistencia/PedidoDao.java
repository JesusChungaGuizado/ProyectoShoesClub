/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.*;
import java.util.List;

/**
 *
 * @author Jesus
 */
public interface PedidoDao {
    public String grabarPedido(Pedido p);
      public String grabarDetallePedido(Pedido p,LineaPedido lp);
      public List ListarPedidos();
       public Producto buscar(int cod) ;
       public Object[] ObtenerUltimoPedido();
       public Object[] GenerarCodigoPedido(int Item);
}
