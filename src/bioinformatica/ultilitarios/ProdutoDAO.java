/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bioinformatica.ultilitarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import bioinformatica.ultilitarios.ConectaBanco;
import java.util.ArrayList;


/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ProdutoDAO {
    private static ResultSet rs;
    private static PreparedStatement stmt;
    private static boolean status;
    public static Usuario usuario;
    public static Questoes Questoes;
    private static Alternativa Alternativa;
    public static Alternativa[] ArrayAlternativa;

    public static boolean User(String us, String sh) throws SQLException{
        Connection con = DataBase.getConnection();
        stmt = null;
        rs = null;
        status = false; 
        usuario = new Usuario();

        
        
        try {
            String sql = "SELECT * FROM usuario WHERE login = ? && senha = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1,us);
            stmt.setString(2,sh);
            rs = stmt.executeQuery();
            
            while(rs.next()){

                usuario.setId(rs.getInt("idUsuario"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getString("tipo"));
                
                status = true;

            }

            
            
            } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectaBanco.closeConnection(con, stmt, rs);
        }
        return status;
    }
    
    
    public static Questoes getQuestoes(int id) throws SQLException{
        Connection con = DataBase.getConnection();
        stmt = null;
        rs = null;
        status = false; 
        Questoes = new Questoes();
        
        
        try {
            String sql = "SELECT * FROM questionario.questao WHERE idQuestao = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            
            while(rs.next()){

                Questoes.setIdQuestao(rs.getInt("IdQuestao"));
                Questoes.setQuestao(rs.getString("Questao"));
                Questoes.setTipoQuestoes(rs.getInt("TipoQuestoes"));

                
                status = true;

            }

            
            
            } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectaBanco.closeConnection(con, stmt, rs);
        }
        return Questoes;
    }
    
        public static ArrayList<bioinformatica.ultilitarios.Alternativa> getAlternativas(int questao) throws SQLException{
        Connection con = DataBase.getConnection();
        stmt = null;
        rs = null;
        status = false; 
        
        ArrayList<Alternativa> listaAlternativa = new ArrayList<>();
        ArrayAlternativa = new Alternativa[4];
        int i = 0;
        
        
        try {
            String sql = "SELECT * FROM questionario.alternativas WHERE Questao = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,questao);
            rs = stmt.executeQuery();
            
            
            while(rs.next()){

                Alternativa = new Alternativa ();
                //int e = rs.getInt("idAlternativas");
                Alternativa.setIntId(rs.getInt("idAlternativas"));
                Alternativa.setIntQuestao(rs.getInt("Questao"));
                Alternativa.setStrAlternativa(rs.getString("alternativas"));
                Alternativa.setBooResposta(rs.getBoolean("booResposta"));
                listaAlternativa.add(Alternativa);
                i++;


                status = true;
            }


            
            } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectaBanco.closeConnection(con, stmt, rs);
        }
        return listaAlternativa;
    }//INSERT INTO `questionario`.`tblnotas` (`idUsuario`, `dobleNota`) VALUES ('1', '5.5');
        
        public static void setNota(String idUsuario, String nota) throws SQLException{
        Connection con = DataBase.getConnection();
        stmt = null;
        rs = null;
        status = false; 
        Questoes = new Questoes();
        
        
        try {
            String sql = "INSERT INTO `questionario`.`tblnotas` (`idUsuario`, `dobleNota`) VALUES ('"+idUsuario+"','"+nota+"');";
            stmt = con.prepareStatement(sql);
            int i = stmt.executeUpdate(sql);
                       
            
            } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectaBanco.closeConnection(con, stmt, rs);
        }

    }
        public static void setAlteraSenha(String idUsuario, String strSenha) throws SQLException{
        Connection con = DataBase.getConnection();
        stmt = null;
        rs = null;
        status = false; 
        Questoes = new Questoes();
        
        
        try {
            String sql = "UPDATE `questionario`.`usuario` SET `senha`='"+strSenha+"' WHERE `idUsuario`='"+idUsuario+"';";
            stmt = con.prepareStatement(sql);
            int i = stmt.executeUpdate(sql);
                       
            
            } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectaBanco.closeConnection(con, stmt, rs);
        }

    }
        public static void setNovoUsuario(String strLogin, String strSenha) throws SQLException{
        Connection con = DataBase.getConnection();
        stmt = null;
        rs = null;
        status = false; 
        Questoes = new Questoes();
        
        
        try {
            String sql = "INSERT INTO `questionario`.`usuario` (`login`, `senha`) VALUES ('"+strLogin+"', '"+strSenha+"');";
            stmt = con.prepareStatement(sql);
            int i = stmt.executeUpdate(sql);
                       
            
            } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConectaBanco.closeConnection(con, stmt, rs);
        }

    } 



}
