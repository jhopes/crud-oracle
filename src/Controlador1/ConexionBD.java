/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOEL
 */
public class ConexionBD {
    static Connection con;
    static Statement st;
    public void AbrirConexion() throws ClassNotFoundException
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");            
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","venta01","venta01");
            st = con.createStatement();
            System.out.println("conexion abierta");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("sin conexion " + ex);
        }
            
    }
    public void CerrarConexion()
    {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
