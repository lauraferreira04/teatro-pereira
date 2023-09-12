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
public class Comum extends Usuario implements Serializable{
    private static final long serialVersionUID = 123L;

    public Comum(int idUsuario, String nomeUsuario, String login, String senha, String cpf, String email, String telefone) {
        super(idUsuario, nomeUsuario, login, senha, cpf, email, telefone);
    }

    public Comum(String nomeUsuario, String login, String senha, String cpf, String email, String telefone) {
        super(nomeUsuario, login, senha, cpf, email, telefone);
    }

    @Override
    public String toString() {
        return "Comum{" + '}'+ super.toString();
    }
    
}
