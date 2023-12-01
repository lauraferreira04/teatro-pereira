/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.Evento;
import modelDominio.Reserva;
import modelDominio.Usuario;

/**
 *  trabalho interdisciplinar
 * @author laura ferreira & gabriel hackenhaar
 */
public class ConexaoController {
    private ObjectInputStream in;
    private ObjectOutputStream out;
    
    public Usuario usuarioLogado;

    public ConexaoController(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }
    
    public Usuario efetuarlogin(Usuario usuario) {
        Usuario usuarioLogado;
        String mensagem;
        try {
            out.writeObject("UsuarioEfetuarLogin");
            mensagem = (String) in.readObject();
            out.writeObject(usuario);
            usuarioLogado = (Usuario) in.readObject();
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            usuarioLogado = null;
        } catch(ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            usuarioLogado = null;
        }   
        return usuarioLogado;
    }
    
    public boolean usuarioExiste(Usuario usuario){
        boolean resultado;
        String mensagem;
        try{
            out.writeObject("UsuarioExiste");
            mensagem = (String) in.readObject();
            out.writeObject(usuario);
            resultado = (Boolean) in.readObject();
        } catch(IOException ioe){
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        } catch(ClassNotFoundException classe){
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public boolean senhaUsuarioExiste(Usuario usuario, String novaSenha){
        boolean resultado;
        String mensagem;
        try{
            out.writeObject("AtualizacaoSenhaUsuario");
            mensagem = (String) in.readObject();
            out.writeObject(usuario);
            mensagem = (String) in.readObject();
            out.writeObject(novaSenha);
            resultado = (Boolean) in.readObject();            
            
        } catch(IOException ioe){
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        } catch(ClassNotFoundException classe){
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public boolean usuarioInserir(Usuario usuario) {
        boolean resultado;
        String mensagem;
        try {
            out.writeObject("UsuarioInserir");
            mensagem = (String) in.readObject();
            out.writeObject(usuario);
            resultado = (Boolean) in.readObject();
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        } catch(ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public boolean usuarioAlterar(Usuario usuario) {
        boolean resultado;
        String mensagem;
        try {
            out.writeObject("UsuarioAlterar");
            mensagem = (String) in.readObject();
            out.writeObject(usuario);
            resultado = (Boolean) in.readObject();
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        } catch(ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public boolean usuarioExcluir(Usuario usuario) {
        boolean resultado;
        String mensagem;
        try {
            out.writeObject("UsuarioExcluir");
            mensagem = (String) in.readObject();
            out.writeObject(usuario);
            resultado = (Boolean) in.readObject();
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        } catch(ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public ArrayList<Usuario> usuarioLista() {
        ArrayList<Usuario> listaUsuarios;
        try {
            out.writeObject("UsuarioLista");
            listaUsuarios = (ArrayList<Usuario>)in.readObject();
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            listaUsuarios = null;
        } catch(ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            listaUsuarios = null;
        }
        return listaUsuarios;
    }
    
    public boolean eventoInserir(Evento evento) {
        boolean resultado;
        String mensagem;
        try {
            out.writeObject("EventoInserir");
            mensagem = (String) in.readObject();
            out.writeObject(evento);
            resultado = (Boolean) in.readObject();
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        } catch(ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public boolean eventoAlterar(Evento evento) {
        boolean resultado;
        String mensagem;
        try {
            out.writeObject("EventoAlterar");
            mensagem = (String) in.readObject();
            out.writeObject(evento);
            resultado = (Boolean) in.readObject();
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        } catch(ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public boolean eventoExcluir(Evento evento) {
        boolean resultado;
        String mensagem;
        try {
            out.writeObject("EventoExcluir");
            mensagem = (String) in.readObject();
            out.writeObject(evento);
            resultado = (Boolean) in.readObject();
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            resultado = false;
        } catch(ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public ArrayList<Evento> eventoLista() {
        ArrayList<Evento> listaEventos;
        try {
            out.writeObject("EventoLista");
            listaEventos = (ArrayList<Evento>)in.readObject();
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            listaEventos = null;
        } catch(ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            listaEventos = null;
        }
        return listaEventos;
    }
    
    public ArrayList<Reserva> reservaLista() {
        ArrayList<Reserva> listaReservas;
        try {
            out.writeObject("ReservaLista");
            listaReservas = (ArrayList<Reserva>)in.readObject();
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
            listaReservas = null;
        } catch(ClassNotFoundException classe) {
            System.out.println("Erro: " + classe.getMessage());
            listaReservas = null;
        }
        return listaReservas;
    }
    
    public boolean enviarEmail(String emailDestinatario) {
        boolean resultado;
        String mensagem;
        try {
            out.writeObject("EnviarEmail");
            mensagem = (String) in.readObject();
            out.writeObject(emailDestinatario); // Envie apenas o e-mail
            resultado = (Boolean) in.readObject();
        } catch(IOException | ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
            resultado = false;
        }
        return resultado;
    }
    
    public void fim() {
        try {
            out.writeObject("fim");
            in.close();
            out.close();
        } catch(IOException ioe) {
            System.out.println("Erro: " + ioe.getMessage());
        }
    }
}