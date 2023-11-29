/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Usuario;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class UsuarioTableModel extends AbstractTableModel{
    private ArrayList<Usuario> listaUsuarios;
    
    public UsuarioTableModel(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    @Override
    public int getRowCount() {
        return listaUsuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario us = listaUsuarios.get(rowIndex);
        switch (columnIndex) {
            case 0: return us.getNomeUsuario();
            case 1: return us.getLogin();
            case 2:return us.getTipoLiteral();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Nome usuário";
            case 1: return "Login";
            case 2: return "Tipo";
            default: return "NoName";
        }
    }
    
    public Usuario getUsuario(int row){
        Usuario usuario = this.listaUsuarios.get(row);
        return usuario;
    } 
}
