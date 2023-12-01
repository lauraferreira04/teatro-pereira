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
            String sql = "insert into evento (idevento, nomeartista, nomeevento, datahora, valor, qtdcadeiras, imagem) " +
                            " values (?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, evento.getIdEvento());
            stmt.setString(2, evento.getArtista());
            stmt.setString(3, evento.getNomeEvento());
            stmt.setObject(4, java.sql.Timestamp.valueOf(evento.getDataHora()));
            stmt.setFloat(5, evento.getValor());
            stmt.setInt(6, evento.getQtdCadeiras());
            stmt.setBytes(7, evento.getImagem());
            
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
                            "datahora = ?, valor = ?, qtdcadeiras = ?, imagem = ? " +
                            "where idevento = ?";
            stmt = con.prepareStatement(sql);
                  
            stmt.setString(1, evento.getArtista());
            stmt.setString(2, evento.getNomeEvento());
            stmt.setObject(3, java.sql.Timestamp.valueOf(evento.getDataHora()));
            stmt.setFloat(4, evento.getValor());
            stmt.setInt(5, evento.getQtdCadeiras());  
            stmt.setInt(6, evento.getIdEvento());
            stmt.setBytes(7, evento.getImagem());
            
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
            String sql = "select * from evento";
            stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                String nomeEvento = res.getString("nomeevento");
                String nomeArtista = res.getString("nomeartista");
                LocalDateTime dataHora = res.getTimestamp("datahora").toLocalDateTime();
                float valor = res.getFloat("valor");
                int qtdCadeiras = res.getInt("qtdcadeiras");
                byte[]imagem = res.getBytes("imagem");
                
                Evento evento = new Evento(nomeEvento, nomeArtista, dataHora, valor, qtdCadeiras, imagem);
                
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
    
    public boolean reservarCadeira (Evento evento) {
        int cadeirasDisponiveis = 0;
        boolean resultado = false;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try {
            String sql = "SELECT qtdcadeiras FROM evento WHERE idevento = ?";
            
            //se a quantidade de cadeiras que a pessoa escolheu é diferente de 0
            if (evento.getQtdCadeiras() != 0) {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, evento.getIdEvento());
                res = stmt.executeQuery();
                
                if (res.next()) {
                    int qtdCadeirasDisponiveis = res.getInt("qtdcadeiras");
                    
                    //se tem cadeira disponível
                    if (qtdCadeirasDisponiveis > 0) {
                        //verifica se o usuário solicitou um número válido de cadeiras
                        if (evento.getQtdCadeiras() > 0 && evento.getQtdCadeiras() <= qtdCadeirasDisponiveis) { 
                            //qtd cadeiras disponíveis  - quantidade que o usuario solicitou
                            int restoCadeira = qtdCadeirasDisponiveis - evento.getQtdCadeiras();
                            //se restoCadeiras for = 0 ou > 0, é pq tinha cadeira no banco
                            if (restoCadeira >= 0){
                                // Atualiza o banco de dados com a nova quantidade de cadeiras disponíveis
                                String updateSql = "UPDATE evento SET qtdcadeiras = ? WHERE idevento = ?";
                                PreparedStatement updateStmt = con.prepareStatement(updateSql);
                                updateStmt.setInt(1, restoCadeira);
                                updateStmt.setInt(2, evento.getIdEvento());
                                updateStmt.executeUpdate();
                                updateStmt.close();
                                resultado = true;
                            }    
                        }else {
                            resultado = false;
                        }
                    }    
                }
            } else {
                resultado = false;
            }
            
            res.close();
            con.close();            
            stmt.close();
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            cadeirasDisponiveis = 0;
        }
        return resultado;
    }
}
