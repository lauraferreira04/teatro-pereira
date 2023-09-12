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
public class Administrador extends Usuario implements Serializable{
    private static final long serialVersionUID = 123L;

    public Administrador(int idUsuario, String nomeUsuario, String login, String senha, String cpf, String email, String telefone, int tipoUsuario) {
        super(idUsuario, nomeUsuario, login, senha, cpf, email, telefone, tipoUsuario);
    }

    public Administrador(String nomeUsuario, String login, String senha, String cpf, String email, String telefone, int tipoUsuario) {
        super(nomeUsuario, login, senha, cpf, email, telefone, tipoUsuario);
    }

    @Override
    public String toString() {
        return "Administrador{" + '}' + super.toString();
    }
}
