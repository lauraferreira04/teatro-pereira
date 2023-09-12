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
                    usuarioLogado = new Administrador(idUsuario, nomeUsuario, login, senha, cpf, email, telefone);
                } else {
                    usuarioLogado = new Comum(idUsuario, nomeUsuario, login, senha, cpf, email, telefone);
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
}
