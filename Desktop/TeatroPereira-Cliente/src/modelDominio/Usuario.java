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
public class Usuario implements Serializable{
    private static final long serialVersionUID = 123L;
    private int idUsuario;
    private String nomeUsuario;
    private String login;
    private String senha;
    private String cpf;
    private String email;
    private String telefone;
    private int tipo;

    public Usuario(int idUsuario, String nomeUsuario, String login, String senha, String cpf, String email, String telefone, int tipo) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public Usuario(String nomeUsuario, String login, String senha, String cpf, String email, String telefone,int tipo) {
        this.nomeUsuario = nomeUsuario;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int idUsuario, String nomeUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
    }

    public Usuario(String login, String cpf, String email) {
        this.login = login;
        this.cpf = cpf;
        this.email = email;
    }
    
    public Usuario(String login, String cpf, String email, String senha) {
        this.login = login;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
           
    public Usuario(String login){
        this.login = login;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", login=" + login + ", senha=" + senha + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone + ", tipoUsuario=" + tipo + '}';
    }
    
    
}
