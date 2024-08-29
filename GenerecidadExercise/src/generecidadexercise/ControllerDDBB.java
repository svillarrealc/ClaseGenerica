/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generecidadexercise;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import generecidadexercise.BBDD;

public class ControllerDDBB{
  private final String tabla_usuarios = "usuarios";
    BBDD bd = new BBDD();
    private static String usuario;
    // Datos de la persona
    private Pair<Integer, String> personData;
    // Datos de EPS y fecha de nacimiento
    private Pair<String, String> epsData;
    
    Connection con = bd.conectar();

    // Constructor para inicializar con los datos
    public ControllerDDBB(Pair<Integer, String> personData, Pair<String, String> epsData) {
        this.personData = personData;
        this.epsData = epsData;
        this.con = bd.conectar();
    }

public void guardar_usuario() {
        try {
            if (con == null) {
                System.out.println("No se pudo establecer la conexión a la base de datos.");
                return;
            }
            
            String sql = "INSERT INTO " + this.tabla_usuarios + " (Edad, Nombre, EPS, Nacimiento) VALUES (?, ?, ?, ?)";
            PreparedStatement consulta = con.prepareStatement(sql);

            consulta.setInt(1, personData.getFirst()); // Edad
            consulta.setString(2, personData.getSecond()); // Nombre
            consulta.setString(3, epsData.getFirst()); // EPS
            consulta.setString(4, epsData.getSecond()); // Fecha de Nacimiento
            
            consulta.executeUpdate();
            
            System.out.println("Se guardaron los datos correctamente.");
        } catch (SQLException ex) {
            System.out.println("Hubo un error al momento de guardar los datos: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    

}
