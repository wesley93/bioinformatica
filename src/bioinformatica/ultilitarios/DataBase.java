/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bioinformatica.ultilitarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DataBase {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/questionario";
    private static final String usuario = "root";
    private static final String senha = "";

    static Connection getConnection() throws SQLException{
        Connection Connection = DriverManager.getConnection(url,usuario, senha);
        return Connection;
        
    }
    

}
