package tarea_10y11;

import java.sql.*;

public class conexion {
    Connection cn = null;
    public Connection conectar(){
        
        try {
            String url = "jdbc:mysql://localhost:3306/Northwind?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String user = "root";
            String password = "";
            this.cn = DriverManager.getConnection(url, user, password);
            System.out.println("ta listo");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cn; 
   
}
}
