/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;

import java.io.Serializable;
import java.util.Date;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class Evento implements Serializable{
    private static final long serialVersionUID = 123L;
    private int idEvento;
    private String nomeEvento;
    private String artista;
    private Date data;
    private float valor;
    private int qtdCadeiras;
    private byte banner;

    public Evento(int idEvento, String artista, String nomeEvento, Date data, float valor, int qtdCadeiras, byte banner) {
        this.idEvento = idEvento;
        this.nomeEvento = nomeEvento;
        this.artista = artista;
        this.data = data;
        this.valor = valor;
        this.qtdCadeiras = qtdCadeiras;
        this.banner = banner;
    }

    public Evento(String artista, String nomeEvento, Date data, float valor, int qtdCadeiras, byte banner) {
        this.nomeEvento = nomeEvento;
        this.artista = artista;
        this.data = data;
        this.valor = valor;
        this.qtdCadeiras = qtdCadeiras;
        this.banner = banner;
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

    public Date getDataHora() {
        return data;
    }

    public void setDataHora(Date dataHora) {
        this.data = dataHora;
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

    public byte getBanner() {
        return banner;
    }

    public void setBanner(byte banner) {
        this.banner = banner;
    }

    @Override
    public String toString() {
        return "Evento{" + "codEvento=" + idEvento + ", nome evento=" + nomeEvento + ", artista=" + artista + ", data e hora=" + data + ", valor=" + valor + ", quantidade cadeiras" + qtdCadeiras + '}';
    }
}
