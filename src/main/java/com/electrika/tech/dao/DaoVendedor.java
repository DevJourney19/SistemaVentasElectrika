package com.electrika.tech.dao;

import com.electrika.tech.entidades.Vendedor;

public interface DaoVendedor extends DaoInterface<Vendedor, Integer>{
    void iniciar(Vendedor vendedor);
    Vendedor getEmpleado();
    Vendedor login(String user, String pass);
}
