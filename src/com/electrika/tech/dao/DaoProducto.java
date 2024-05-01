
package com.electrika.tech.dao;

import com.electrika.tech.entidades.Producto;
import java.util.List;


public interface DaoProducto extends DaoInterface<Producto, Integer>{
    List<Object[]> verData();
}
