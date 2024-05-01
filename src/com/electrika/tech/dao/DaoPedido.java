
package com.electrika.tech.dao;

import com.electrika.tech.entidades.Pedido;
import java.util.List;

public interface DaoPedido extends DaoInterface<Pedido, Integer>{
    
    List <Object[]> verData();
}
