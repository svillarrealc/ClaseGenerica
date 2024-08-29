/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generecidadexercise;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class BBDD {
    
    private static Connection conn;
    private static final String driver ="com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/prueba";
    private final String user = "root";
    private final String password = "";

    public  Connection conectar() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if(conn!=null){
                System.out.println("Conexion establecida en: " + this.toString());
            }
            return conn;
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
            return null;
        }
    }
}
