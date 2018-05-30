/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bioinformatica.ultilitarios;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

public class ConectaBanco {
    
    public Statement stm;
    public ResultSet rs;
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static  final String URL = "jdbc:mysql://localhost:3306/questionario";
    private static  final String USER = "root";
    private static  final String PASS = "";
    private static Connection conexao;

 
    public ConectaBanco() throws Exception{

        try { 
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL,USER, PASS);
 
            JOptionPane.showMessageDialog(null, "Conexão OK");
            }
                catch(ClassNotFoundException Driver)
            {
                throw new Exception("Driver não encontrado!!!");
            }
                catch(SQLException sql)
            {
                throw new Exception("Falha ocorrida: " + sql.getMessage());
            }
        

    }

    public static Connection getConnection()
       {
           
            return conexao;
       }
    
    public static void closeConnection(Connection con){
        try {
            if(con!=null){

                con.close();
            } 
        }catch (SQLException ex) {
                Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try {
            if(stmt !=null){
                stmt.close();
            }

        }catch (SQLException ex) {
                Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        try {
            if(rs !=null){
                rs.close();
            }

        }catch (SQLException ex) {
                Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
