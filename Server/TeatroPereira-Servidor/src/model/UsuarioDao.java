/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conector;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelDominio.Administrador;
import modelDominio.Comum;
import modelDominio.Usuario;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class UsuarioDao {
    private Connection con;

    public UsuarioDao() {
        this.con = Conector.getConnection();
    }
    
    public Usuario efetuarLogin (Usuario usuario){
        Usuario usuarioLogado = null;
        PreparedStatement stmt = null;
        try {
            String sql = "select * from usuario where login = ? and senha = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            ResultSet res = stmt.executeQuery();
            while (res.next()){
                int idUsuario = res.getInt("idusuario");
                String nomeUsuario = res.getString("nomeusuario");
                String login = res.getString("login");
                String senha = res.getString("senha");
                String cpf = res.getString("cpf");
                String email = res.getString("email");
                String telefone = res.getString("telefone");
                int tipo = res.getInt("tipo");
                
                if (tipo == 0) {
                    usuarioLogado = new Administrador(idUsuario, nomeUsuario, login, senha, cpf, email, telefone, tipo);
                } else {
                    usuarioLogado = new Comum(idUsuario, nomeUsuario, login, senha, cpf, email, telefone, tipo);
                }
            }
            
            res.close();
            stmt.close();
            con.close();
        } catch (SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            usuarioLogado = null;
        }
        return usuarioLogado;
    }
    
    public boolean usuarioExiste (Usuario usuario){
        boolean resultado;
        PreparedStatement stmt = null;
        try {
            con.setAutoCommit(false);
            String sql = "select login from usuario where login = '?'" ;
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            
            stmt.execute();
            con.commit();
            
            resultado = true;
        } catch(SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            resultado = false;
        } finally{
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
                resultado = false;
            }
        }
        return resultado;
    }
    
    public boolean inserirUsuario (Usuario usuario){
        boolean resultado;
        PreparedStatement stmt = null;
        try {
            con.setAutoCommit(false);
            String sql = "insert into usuario (nomeusuario, login, senha, cpf, email, telefone, tipo) " +
                            " values (?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getTelefone());            
            stmt.setInt(7, 0);  
            
            stmt.execute();
            con.commit();
            
            resultado = true;
        } catch(SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            resultado = false;
            
        } finally{
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
                resultado = false;
            }
        }
        return resultado;
    } 
    public boolean alterarUsuario (Usuario usuario){
        boolean resultado;
        PreparedStatement stmt = null;
        try {
            con.setAutoCommit(false);
            String sql = "update usuario set nomeusuario = ?, login = ?, " +
                            "senha = ?, cpf = ?, email = ?, telefone = ?" +
                            "where idusuario = ?";
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getCpf());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getTelefone());  
            stmt.setInt(7, usuario.getIdUsuario());
             
            stmt.execute();
            con.commit();
            resultado = true;
            
        } catch (SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            resultado = false;
            try {
                con.rollback();
            } catch (SQLException exc2){
                System.out.println("Erro: " + exc.getMessage());                
            }
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            }catch (SQLException exc){
                System.out.println("Erro: " + exc.getMessage());
                resultado = false;
            }
        }
        return resultado;
    }
    public boolean excluirUsuario (Usuario usuario){
        boolean resultado;
        PreparedStatement stmt = null;
        try {
            con.setAutoCommit(false);
            String sql = "delete from usuario where idusuario = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getIdUsuario());
            
            stmt.execute();
            con.commit();
            resultado = true;
        } catch(SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            resultado = false;
            try {
                con.rollback();
            } catch (SQLException exc2){
                System.out.println("Erro: " + exc2.getMessage());                
            }
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException exc){
                System.out.println("Erro: " + exc.getMessage());       
                resultado = false;
            }
        }
        return resultado;
    }
    
    public ArrayList<Usuario> getListaUsuarios(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        PreparedStatement stmt = null;
        try {
            String sql = "select * from usuario";
            stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
                        
            while(res.next()){
                int idUsuario = res.getInt("idusuario");
                String nomeusuario = res.getString("nomeusuario");
                String login = res.getString("login");
                String senha = res.getString("senha");
                String cpf = res.getString("cpf");
                String email = res.getString("email");
                String telefone = res.getString("telefone");
                int tipo = res.getInt("tipo");
                
                Usuario usuario = new Usuario(idUsuario, nomeusuario, login, senha, cpf, email, telefone, tipo);
                                
                listaUsuarios.add(usuario);
            }
            res.close();
            con.close();            
            stmt.close();
        } catch (SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            listaUsuarios = null;
        }
        return listaUsuarios;
    }
}
