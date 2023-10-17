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
            String sql = "insert into reserva (idreserva,idusuario,idevento,qtdcadeiras,valortotal) " +
                         "values (?,?,?,?,?)";
            
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, reserva.getIdReserva());
            stmt.setInt(2, reserva.getUsuario().getIdUsuario());
            stmt.setInt(3, reserva.getEvento().getIdEvento());
            stmt.setInt(4, reserva.getQtdCadeiras());
            stmt.setFloat(5, reserva.getValorTotal());
            
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
                String nomeUsuario = res.getString("nomeusuario");
                Usuario usuario = new Usuario(idUsuario, nomeUsuario);
                int idEvento = res.getInt("idevento");
                String nomeEvento = res.getString("nomeevento");
                float valor = res.getFloat("valor");
                Evento evento = new Evento(idEvento, nomeEvento, valor);
                int qtdCadeiras = res.getInt("qtdcadeiras");
                float valorTotal = res.getFloat("valortotal");
                
                Reserva reserva = new Reserva(idReserva, usuario, evento, qtdCadeiras, valorTotal);
                
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
