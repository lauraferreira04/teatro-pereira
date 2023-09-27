/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Evento;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class EventoTableModel extends AbstractTableModel{
    private ArrayList<Evento> listaEventos;
    
    public EventoTableModel(ArrayList<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }
    
    @Override
    public int getRowCount() {
        return listaEventos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Evento ev = listaEventos.get(rowIndex);
        switch (columnIndex) {
            case 0: return ev.getIdEvento();
            case 1: return ev.getNomeEvento();
            case 2: return ev.getArtista();
            case 3: return ev.getValor();
            case 4: return ev.getData();
            case 5: return ev.getQtdCadeiras();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Código";
            case 1: return "Nome Evento";
            case 2: return "Artista";
            case 3: return "Valor";
            case 4: return "Data e Hora";
            default: return "NoName";
        }
    }
    
    public Evento getBike(int row){
        Evento evento = this.listaEventos.get(row);
        return evento;
    } 
}
