/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class Evento implements Serializable{
    private static final long serialVersionUID = 123L;
    private int idEvento;
    private String nomeEvento;
    private String artista;
    private LocalDateTime dataHora;
    private float valor;
    private int qtdCadeiras;
    private byte[] imagem;

    public Evento(int idEvento, String nomeEvento, String artista, LocalDateTime dataHora, float valor, int qtdCadeiras) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.artista = artista;
        this.dataHora = dataHora;
        this.valor = valor;
        this.qtdCadeiras = qtdCadeiras;
    }

    public Evento(String nomeEvento, String artista, LocalDateTime dataHora, float valor, int qtdCadeiras, byte[] imagem) {
        this.nomeEvento = nomeEvento;
        this.artista = artista;
        this.dataHora = dataHora;
        this.valor = valor;
        this.qtdCadeiras = qtdCadeiras;
        this.imagem = imagem;
    }

    public Evento(int idEvento, String nomeEvento, float valor) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.valor = valor;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQtdCadeiras() {
        return qtdCadeiras;
    }

    public void setQtdCadeiras(int qtdCadeiras) {
        this.qtdCadeiras = qtdCadeiras;
    }
    
    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}