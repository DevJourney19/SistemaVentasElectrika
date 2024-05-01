
package com.electrika.tech.test2;

import com.electrika.tech.dao.DaoPedido;
import com.electrika.tech.dao.impl.DaoPedidoImpl;

public class test3 {
    public static void main(String[] args) {
        
        DaoPedido dao = new DaoPedidoImpl();
        try {
            dao.verData().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(dao.getMessage());
        }
        
        
        
    }
}
