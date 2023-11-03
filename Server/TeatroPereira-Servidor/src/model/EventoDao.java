/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import modelDominio.Evento;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

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
            String sql = "insert into evento (idevento, nomeartista, nomeevento, datahora, valor, qtdcadeiras) " +
                            " values (?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, evento.getIdEvento());
            stmt.setString(2, evento.getArtista());
            stmt.setString(3, evento.getNomeEvento());
            stmt.setObject(4, java.sql.Timestamp.valueOf(evento.getDataHora()));
            stmt.setFloat(5, evento.getValor());
            stmt.setInt(6, evento.getQtdCadeiras());          
            
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
                            "datahora = ?, valor = ?, qtdcadeiras = ? " +
                            "where idevento = ?";
            stmt = con.prepareStatement(sql);
                  
            stmt.setString(1, evento.getArtista());
            stmt.setString(2, evento.getNomeEvento());
            stmt.setObject(3, java.sql.Timestamp.valueOf(evento.getDataHora()));
            stmt.setFloat(4, evento.getValor());
            stmt.setInt(5, evento.getQtdCadeiras());  
            stmt.setInt(6, evento.getIdEvento());
            
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
    public boolean excluirEvento (Evento evento){
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
    
    public ArrayList<Evento> getListaEventos() {
        ArrayList<Evento> listaEventos = new ArrayList<>();
        PreparedStatement stmt = null;
        try {
            String sql = "select * from evento ";
            stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                int idEvento = res.getInt("idevento");
                String nomeArtista = res.getString("nomeartista");
                String nomeEvento = res.getString("nomeevento");
                LocalDateTime dataHora = res.getTimestamp("datahora").toLocalDateTime();
                float valor = res.getFloat("valor");
                int qtdCadeiras = res.getInt("qtdcadeiras");
                
                Evento evento = new Evento(idEvento, nomeEvento, nomeArtista, dataHora, valor, qtdCadeiras);
                
                listaEventos.add(evento);
            }
            res.close();
            con.close();            
            stmt.close();
            
        } catch (SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            listaEventos = null;
        }
        return listaEventos;
    }
}
