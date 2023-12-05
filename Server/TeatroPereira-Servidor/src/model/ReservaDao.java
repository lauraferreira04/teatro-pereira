/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import factory.Conector;
import java.sql.Connection;
import modelDominio.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import modelDominio.Evento;
import modelDominio.Usuario;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class ReservaDao {
    private Connection con;
    
    public ReservaDao(){
        this.con = Conector.getConnection();
    }
    
    public boolean efetuarReserva (Reserva reserva){
        boolean resultado;
        PreparedStatement stmt = null;
        try {
            con.setAutoCommit(false);
            String sql = "insert into reserva (idusuario,idevento,qtdingressos,valortotal) " +
                         "values (?,?,?,?)";
            
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, reserva.getUsuario().getIdUsuario());
            stmt.setInt(2, reserva.getEvento().getIdEvento());
            stmt.setInt(3, reserva.getQtdCadeiras());
            stmt.setFloat(4, reserva.getValorTotal());
            
            stmt.execute();
            con.commit();
            resultado = true;
        } catch (SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            resultado = false;
            try {
                con.rollback();
            } catch (SQLException exc2) {
                System.err.println("Erro: " + exc2.getMessage());
            }
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
                resultado = false;
            }
        }
        return resultado;
    }
    
    public ArrayList<Reserva> getListaReservas() {
        ArrayList<Reserva> listaReservas = new ArrayList<>();
        PreparedStatement stmt = null;
        try {
            String sql = "select reserva.*, usuario.*, evento.* from reserva " +
                         "inner join usuario on (usuario.idusuario = reserva.idusuario) " +
                         "inner join evento on (evento.idevento = reserva.idevento) " +
                         "order by reserva.idreserva ";
            stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                int idReserva = res.getInt("idreserva");
                int idUsuario = res.getInt("idusuario");
                String nomeusuario = res.getString("nomeusuario");
                String login = res.getString("login");
                String senha = res.getString("senha");
                String cpf = res.getString("cpf");
                String email = res.getString("email");
                String telefone = res.getString("telefone");
                int tipo = res.getInt("tipo");
                Usuario usuario = new Usuario(idUsuario, nomeusuario, login, senha, cpf, email, telefone, tipo);
                int idEvento = res.getInt("idevento");
                String nomeEvento = res.getString("nomeevento");
                String nomeArtista = res.getString("nomeartista");
                LocalDateTime dataHora = res.getTimestamp("datahora").toLocalDateTime();
                float valor = res.getFloat("valor");
                int qtdCadeiras = res.getInt("qtdcadeiras");
                byte[]imagem = res.getBytes("imagem");
                Evento evento = new Evento(nomeEvento, nomeArtista, dataHora, valor, qtdCadeiras, imagem);
                evento.setIdEvento(idEvento);
                int qtdIngressos = res.getInt("qtdingressos");
                float valorTotal = res.getFloat("valortotal");
                
                Reserva reserva = new Reserva(idReserva, usuario, evento, qtdIngressos, valorTotal);
                
                listaReservas.add(reserva);
            }
            res.close();
            con.close();            
            stmt.close();
            
        } catch (SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            listaReservas = null;
        }
        return listaReservas;
    }
}
