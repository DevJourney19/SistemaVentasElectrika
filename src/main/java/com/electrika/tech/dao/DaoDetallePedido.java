package com.electrika.tech.dao;

import com.electrika.tech.entidades.DetallePedido;
import com.electrika.tech.entidades.Producto;
import java.util.List;
import java.util.Stack;

public interface DaoDetallePedido extends DaoInterface<DetallePedido, Integer> {

    List<Object[]> verData();

    String actualizarPedido(Integer idDeta);

    List<DetallePedido> seleccionarMemoria();

    void eliminarMemoria();

    void obtenerId(Integer idGenerado);

    List<Object[]> obtenerProductos(Integer idPed);
}
