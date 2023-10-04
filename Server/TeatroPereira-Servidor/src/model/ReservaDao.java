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
    
    public Reserva efetuarReserva (Reserva reserva){
        Reserva reservaEfetuada = null;
        PreparedStatement stmt = null;
        try {
            String sql = "select reserva.*, evento.nomeevento, usuario.nomeusuario from reserva " +
                    "inner join evento on (evento.idevento = reserva.idevento) " +
                    "inner join marca on (usuario.idusuario = reserva.idusuario) ";
            
            stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            
            while (res.next()){
                int idEvento = res.getInt("idevento");
                String nomeEvento = res.getString("nomeevento");
                float valor = res.getFloat("valor");
                
                Evento evento = new Evento(idEvento, nomeEvento, valor);
                
                int idUsuario = res.getInt("idusuario");
                String nomeUsuario = res.getString("nomeusuario");
                
                Usuario usuario = new Usuario(idUsuario, nomeUsuario);
                
                int idReserva = res.getInt("idreserva");
                int qtdCadeiras = res.getInt("qtdcadeiras");
                float valorTotal = res.getFloat("valortotal");
                //Reserva reserva = new Reserva(idReserva, usuario, evento, qtdCadeiras, valorTotal);
            }
            res.close();
            con.close();            
            stmt.close();
        } catch (SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            reservaEfetuada = null;
        }
        return reservaEfetuada;
    }
    
    public ArrayList<Reserva> getListaReservas() {
        ArrayList<Reserva> listaReservas = new ArrayList<>();
        PreparedStatement stmt = null;
        try {
            String sql = "select * from reserva ";
            stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                int idReserva = res.getInt("idreserva");
                String usuario = res.getString("nomeusuario");
                String evento = res.getString("nomeevento");
                int qtdCadeiras = res.getInt("qtdcadeiras");
                float valorTotal = res.getFloat("valor");
                
                //Reserva reserva = new Reserva(idReserva, usuario, evento, qtdCadeiras, valorTotal);
                
                //listaReservas.add(reserva);
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
