/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoev01;

/**
 *
 * @author triba
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProyectoEV01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario="root";
        String password="7845God";
        String url="jdbc:mysql://localhost:3306/mydb";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoEV01.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion=DriverManager.getConnection(url,usuario,password);
            statement=conexion.createStatement();
            rs=statement.executeQuery("SELECT * FROM CLIENTES");
            rs.next();
            do{
                System.out.println(rs.getInt("ID_Cliente")+":"+ rs.getString("Nombre"));
            }while (rs.next());
            
            /*Insert
            statement.executeUpdate("INSERT INTO CLIENTES VALUES(8, 'Clara Lopez', 'Carrera 78', '4134784651', 'clarita@outlook.com')");
            System.out.println("");
            rs=statement.executeQuery("SELECT * FROM CLIENTES");
            rs.next();
            do{
                System.out.println(rs.getInt("ID_Cliente")+":"+ rs.getString("Nombre"));
            }while (rs.next());
            */
            
            //Update
            statement.executeUpdate("UPDATE clientes SET Nombre='Jean Clawn' WHERE ID_Cliente=5");
            System.out.println("");
            rs=statement.executeQuery("SELECT * FROM CLIENTES");
            rs.next();
            do{
                System.out.println(rs.getInt("ID_Cliente")+":"+ rs.getString("Nombre"));
            }while (rs.next());
            
            //Delete
            statement.executeUpdate("DELETE from clientes WHERE ID_Cliente=9");
            System.out.println("");
            rs=statement.executeQuery("SELECT * FROM CLIENTES");
            rs.next();
            do{
                System.out.println(rs.getInt("ID_Cliente")+":"+ rs.getString("Nombre"));
            }while (rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoEV01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
