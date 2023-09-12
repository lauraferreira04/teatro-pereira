/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class Reserva implements Serializable{
    private static final long serialVersionUID = 123L;
    private int idReserva;
    private Usuario usuario;
    private Evento evento;
    private int qtdCadeiras;
    private float valorTotal;

    public Reserva(int idReserva, Usuario usuario, Evento evento, int qtdCadeiras, float valorTotal) {
        this.idReserva = idReserva;
        this.usuario = usuario;
        this.evento = evento;
        this.qtdCadeiras = qtdCadeiras;
        this.valorTotal = valorTotal;
    }

    public Reserva(Usuario usuario, Evento evento, int qtdCadeiras, float valorTotal) {
        this.usuario = usuario;
        this.evento = evento;
        this.qtdCadeiras = qtdCadeiras;
        this.valorTotal = valorTotal;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public int getQtdCadeiras() {
        return qtdCadeiras;
    }

    public void setQtdCadeiras(int qtdCadeiras) {
        this.qtdCadeiras = qtdCadeiras;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
}
