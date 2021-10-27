/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus
 */
public class Pedido {
     private String num;
    private String fec;
    private Cliente cli;
   //private Empleado emp;
    private List ces=new ArrayList();
    
    public void agregarLinea(Producto pro,int can){
        LineaPedido lin=new LineaPedido(pro,can);
         int canti=0;
         boolean rpta=false;
        for (int i = 0; i < ces.size(); i++) {
            LineaPedido li=(LineaPedido)ces.get(i);
            if (li.getPro().getIdProducto()==pro.getIdProducto()) {
                canti=li.getCan();
                if (canti<li.getPro().getStock()) {
                    li.setCan(canti+=1);
                }
                 rpta=true;
                break;
            }
        }
        if (rpta==false) {
            ces.add(lin);
        }
        
    }
    public void restarLinea(Producto pro,int can){
        LineaPedido lin=new LineaPedido(pro,can);
        int canti=0;
         //boolean rpta=false;
        for (int i = 0; i < ces.size(); i++) {
            LineaPedido li=(LineaPedido)ces.get(i);
            if (li.getPro().getIdProducto()==pro.getIdProducto()) {
                canti=li.getCan();
                if (li.getCan()>1) {
                     li.setCan(canti-=1);
                }
                break;
            }
        }
        
    }
    public void quitarLinea(String cod){
        for(int i=0;i<ces.size();i++){
            LineaPedido lin=(LineaPedido)ces.get(i);
            if(lin.getPro().getIdProducto()==Integer.parseInt(cod)){
                ces.remove(i);
            }
        }
    }
    public double getTot(){
        double tot=0;
        for(int i=0;i<ces.size();i++){
            LineaPedido lin=(LineaPedido)ces.get(i);
            tot+=lin.getImp();
        }
        
        return tot;
    }
    public double getTotDesc(){
        double totDesc=0;
        for(int i=0;i<ces.size();i++){
            LineaPedido lin=(LineaPedido)ces.get(i);
            totDesc+=lin.getDescuento();
        }
        
        return totDesc;
    }
    public double getSubtotal(){
        double subtotal=0;
        for(int i=0;i<ces.size();i++){
            LineaPedido lin=(LineaPedido)ces.get(i);
            subtotal+=lin.getSubtotal();
        }
        
        return subtotal;
    }

    public List getCes() {
        return ces;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getFec() {
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

//    public Empleado getEmp() {
//        return emp;
//    }
//
//    public void setEmp(Empleado emp) {
//        this.emp = emp;
//    }
    
}
