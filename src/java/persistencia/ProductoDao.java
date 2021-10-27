/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;

/**
 *
 * @author Jesus
 */
public interface ProductoDao {
    public List listarOfertas();
   public Object[]buscarProducto(int cod);
   public List FiltrarProducto(int cat,String sexo);
}
