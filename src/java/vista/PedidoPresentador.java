/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus
 */
public class PedidoPresentador {
    private String msg="";
    private Object[]fil={"","","","","","","","","","",""};
    private Object[]fil2={"",""};
    private Object[]fil3={"","","","","","","","","","",""};
    private List lis=new ArrayList();
    private List lis2=new ArrayList();
    public PedidoPresentador() {
        lis.add(fil);
        lis2.add(fil3);
    }

    public Object[] getFil() {
        return fil;
    }

    public void setFil(Object[] fil) {
        this.fil = fil;
    }

    public List getLis() {
        return lis;
    }

    public void setLis(List lis) {
        this.lis = lis;
    }

    public Object[] getFil2() {
        return fil2;
    }

    public void setFil2(Object[] fil2) {
        this.fil2 = fil2;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getLis2() {
        return lis2;
    }

    public void setLis2(List lis2) {
        this.lis2 = lis2;
    }
    
}
