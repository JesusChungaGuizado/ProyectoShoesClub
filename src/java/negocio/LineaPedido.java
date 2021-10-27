/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Jesus
 */
public class LineaPedido {
    private Producto pro;
    private int can;

    public LineaPedido(Producto pro, int can) {
        this.pro = pro;
        this.can = can;
    }

    public LineaPedido() {
    }

    public Producto getPro() {
        return pro;
    }

    public void setPro(Producto pro) {
        this.pro = pro;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }
    
    public double getImp(){
        return pro.getPrecioOferta()*getCan();
    }
    public double getDescuento(){
        return (pro.getPrecioNormal()*pro.getDescuento()*getCan())/100;
    }
    public double getSubtotal(){
        return pro.getPrecioNormal()*getCan();
    }
}   
