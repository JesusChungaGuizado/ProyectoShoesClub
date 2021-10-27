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
public class ProductoDaoImp implements ProductoDao{

    @Override
    public List listarOfertas() {
        String sql="{call listarOfertas()}";
        return Operacion.listar(sql);
    }

    @Override
    public Object[] buscarProducto(int cod) {
        String sql="{call buscarCalzado("+cod+")}";
       return Operacion.buscar(sql);
    }
    
}
