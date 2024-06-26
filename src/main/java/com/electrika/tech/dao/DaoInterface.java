
package com.electrika.tech.dao;

import java.util.List;

public interface DaoInterface<T,ID> {
    
    List<T> select();
    T get(ID id);
    String insert(T objeto);
    String update(T objeto);
    String delete(ID id);    
    String getMessage();
}
