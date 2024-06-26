
package com.electrika.tech.test2;

import java.sql.SQLException;
import com.electrika.tech.util.ConectaBD;

public class TestConexion {
    public static void main(String[] args) {
        try {
            ConectaBD con= new ConectaBD();
            con.getConexion();
            System.out.println("Exito");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
