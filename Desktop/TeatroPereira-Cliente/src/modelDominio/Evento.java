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
    private String artista;
    private String nomeEvento;
    private Date dataHora;
    private float valor;
    private int qtdCadeiras;
    private byte banner;

    public Evento(int idEvento, String artista, String nomeEvento, Date dataHora, float valor, int qtdCadeiras, byte banner) {
        this.idEvento = idEvento;
        this.artista = artista;
        this.nomeEvento = nomeEvento;
        this.dataHora = dataHora;
        this.valor = valor;
        this.qtdCadeiras = qtdCadeiras;
        this.banner = banner;
    }

    public Evento(String artista, String nomeEvento, Date dataHora, float valor, int qtdCadeiras, byte banner) {
        this.artista = artista;
        this.nomeEvento = nomeEvento;
        this.dataHora = dataHora;
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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
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

    public byte getBanner() {
        return banner;
    }

    public void setBanner(byte banner) {
        this.banner = banner;
    }

    @Override
    public String toString() {
        return "Evento{" + "codEvento=" + idEvento + ", artista=" + artista + ", nome evento=" + nomeEvento + ", data e hora=" + dataHora + ", valor=" + valor + ", quantidade cadeiras" + qtdCadeiras + '}';
    }
}
