/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador1;


import static Controlador1.ConexionBD.con;
import static Controlador1.ConexionBD.st;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOEL
 */
public class ClsCategoria {
    ConexionBD cx;
    String sql="";
    public ClsCategoria() {
        cx = new ConexionBD();
        try {
            cx.AbrirConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClsCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void reporteCategoria() throws SQLException
    {
        
        sql = "SELECT id_categoria, descripcion FROM categoria ";        
        ResultSet rs = st.executeQuery(sql);
        if(rs!=null)
        {
            while(rs.next()){
                System.out.println(rs.getString("id_categoria")+" "+rs.getString("descripcion"));
            }
        }
        else{
        System.out.println("Error de consulta "+sql);
        }
        st.close();
        //rs.close();
        con.close();
        
    }
    public void createCategoria(String id, String desc, String estado) throws SQLException
    {
        sql="INSERT INTO categoria (id_categoria, descripcion, estado )"
                + "VALUES('"+id+"', '"+desc+"', '"+estado+"')";
        
        int result = st.executeUpdate(sql);
        System.out.println("result "+ result);
        if(result!=0){
            con.commit();
            System.out.println("Inserto correctamente "+ sql);
        }else{
            con.rollback();
            System.out.println("No insertó ");
        }
        //cx.CerrarConexion();
    }
   public void updateCategroia(String id, String desc) throws SQLException
   {
       sql="UPDATE categoria SET descripcion= '"+desc+"', estado = '0' "
               + "WHERE id_categoria='"+id+"' ";
       int result = st.executeUpdate(sql);
        System.out.println("result "+ result);
        if(result!=0){
            con.commit();
            System.out.println("Actualizó correctamente "+ sql);
        }else{
            System.out.println("No actualizó ");
            con.rollback();
        }
   }
   public void deleteCategoria(String id) throws SQLException{
       sql="DELETE FROM categoria WHERE id_categoria='"+id+"'";
       int result = st.executeUpdate(sql);
        System.out.println("result "+ result);
        if(result!=0){
            con.commit();
            System.out.println("eliminó correctamente "+ sql);
        }else{
            con.rollback();
            System.out.println("No eliminó ");
        }
   }
    
}
