/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import modelDominio.Evento;
import java.sql.SQLException;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar teste
 */
public class EventoDao {
    private Connection con;
    
    public EventoDao(){
        this.con = Conector.getConnection();
    }
    
    public boolean inserirEvento (Evento evento){
        boolean resultado;
        PreparedStatement stmt = null;
        try {
            con.setAutoCommit(false);
            String sql = "insert into evento (idevento, nomeartista, nomeevento, datahora, valor, qtdcadeiras, banner) " +
                            " values (?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, evento.getIdEvento());
            stmt.setString(2, evento.getArtista());
            stmt.setString(3, evento.getNomeEvento());
            stmt.setDate(4, new java.sql.Date(evento.getData().getTime()));
            stmt.setFloat(5, evento.getValor());
            stmt.setInt(6, evento.getQtdCadeiras());
            stmt.setBytes(7, evento.getBanner());            
            
            stmt.execute();
            con.commit();
            
            resultado = true;
        } catch(SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            resultado = false;
            try {
                con.rollback();
            } catch(SQLException exc2) {
                System.out.println("Erro: " + exc2.getMessage());
            }
        } finally {
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
    
    public boolean alterarEvento (Evento evento){
        boolean resultado;
        PreparedStatement stmt = null;
        try{
            con.setAutoCommit(false);
            String sql = "update evento set nomeartista = ?, nomeevento = ?, " +
                            "datahora = ?, valor = ?, qtdcadeiras = ?, banner = ?" +
                            "where idevento = ?";
            stmt = con.prepareStatement(sql);
                  
            stmt.setString(1, evento.getArtista());
            stmt.setString(2, evento.getNomeEvento());
            stmt.setDate(3, new java.sql.Date(evento.getData().getTime()));
            stmt.setFloat(4, evento.getValor());
            stmt.setInt(5, evento.getQtdCadeiras());
            stmt.setBytes(6, evento.getBanner());    
            stmt.setInt(7, evento.getIdEvento());
            
            stmt.execute();
            con.commit();
            resultado = true;            
        } catch (SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            resultado = false;
            try {
                con.rollback();
            } catch(SQLException exc2) {
                System.out.println("Erro: " + exc2.getMessage());
            }
        } finally {
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
    public boolean exclirEvento (Evento evento){
        boolean resultado;
        PreparedStatement stmt = null;
        try {
            con.setAutoCommit(false);
            String sql = "delete from evento where idevento = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, evento.getIdEvento());
            
            stmt.execute();
            con.commit();
            resultado = true;
        } catch (SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            resultado = false;
            try {
                con.rollback();
            } catch(SQLException exc2) {
                System.out.println("Erro: " + exc2.getMessage());
            }
        } finally {
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
}
