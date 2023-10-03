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
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario us = listaUsuarios.get(rowIndex);
        switch (columnIndex) {
            case 0: return us.getIdUsuario();
            case 1: return us.getNomeUsuario();
            case 2: return us.getLogin();
            case 3: return us.getSenha();
            case 4: return us.getCpf();
            case 5: return us.getEmail();
            case 6: return us.getTelefone();
            case 7:return us.getTipo();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Código";
            case 1: return "Nome usuário";
            case 2: return "Login";
            case 3: return "Senha";
            case 4: return "CPF";
            case 5: return "Email";
            case 6: return "Telefone";
            case 7: return "Tipo";
            default: return "NoName";
        }
    }
    
    public Usuario getUsuario(int row){
        Usuario usuario = this.listaUsuarios.get(row);
        return usuario;
    } 
}
