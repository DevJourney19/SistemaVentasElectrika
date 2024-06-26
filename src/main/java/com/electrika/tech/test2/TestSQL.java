
package com.electrika.tech.test2;

import com.electrika.tech.dao.DaoVendedor;
import com.electrika.tech.dao.impl.DaoVendedorImpl;

public class TestSQL {
    public static void main(String[] args) {
        DaoVendedor d = new DaoVendedorImpl();
        //DaoDistribuidor dao = new DaoDistribuidorImpl();
        //DaoCategoria dao = new DaoCategoriaImpl();
        //dao.categoriaSel().forEach(t-> System.out.println(t.getNombre()));
        //Ese problema del MariDB se debe al error de sintaxis, se soluciona corrigiendo lo de DaoCategoriaImpl en la parte del "Selec" ...
        try {            
            System.out.println(d.login("da1", "123"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            System.out.println(d.getMessage());
        }
        //dao.provSel().forEach(t-> System.out.println(t.getNombre()));
        
        
    }
}
