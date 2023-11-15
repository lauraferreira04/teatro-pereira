package com.example.teatropereira_mobile.controller;

import android.util.Log;

import com.example.teatropereira_mobile.viewModel.InformacoesViewModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelDominio.Evento;
import modelDominio.Reserva;
import modelDominio.Usuario;

public class ConexaoController {
    InformacoesViewModel informacoesViewModel;

    public ConexaoController(InformacoesViewModel informacoesViewModel) {
        this.informacoesViewModel = informacoesViewModel;
    }

    public boolean criaConexaoServidor(String ip, int porta) {
        boolean resultado;
        try {
            Socket socket = new Socket(ip, porta);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            informacoesViewModel.inicializaObjetosSocket(in, out);
            resultado = true;
        } catch(IOException ioe) {
            Log.e("TeatroPereira", "Erro: " + ioe.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public Usuario efetuarLogin (Usuario usuario) {
        Usuario usuarioLogado;
        String mensagem;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("UsuarioEfetuarLogin");
            mensagem = (String)this.informacoesViewModel.getInputStream().readObject();
            this.informacoesViewModel.getOutputStream().writeObject(usuario);
            usuarioLogado = (Usuario)this.informacoesViewModel.getInputStream().readObject();
        } catch (IOException ioe) {
            Log.e("TeatroPereira", "Erro: " + ioe.getMessage());
            usuarioLogado = null;
        } catch (ClassNotFoundException classe) {
            Log.e("TeatroPereira", "Erro: " + classe.getMessage());
            usuarioLogado = null;
        }
        return usuarioLogado;
    }

    public boolean usuarioExiste (Usuario usuario) {
        boolean resultado;
        String mensagem;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("UsuarioExiste");
            mensagem = (String)this.informacoesViewModel.getInputStream().readObject();
            this.informacoesViewModel.getOutputStream().writeObject(usuario);
            resultado = (Boolean)this.informacoesViewModel.getInputStream().readObject();
        } catch (IOException ioe) {
            Log.e("TeatroPereira", "Erro: " + ioe.getMessage());
            resultado = false;
        } catch (ClassNotFoundException classe) {
            Log.e("TeatroPereira", "Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public boolean usuarioInserir (Usuario usuario) {
        boolean resultado;
        String mensagem;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("CriaUsuario");
            mensagem = (String)this.informacoesViewModel.getInputStream().readObject();
            this.informacoesViewModel.getOutputStream().writeObject(usuario);
            resultado = (Boolean)this.informacoesViewModel.getInputStream().readObject();
        } catch (IOException ioe) {
            Log.e("TeatroPereira", "Erro: " + ioe.getMessage());
            resultado = false;
        } catch (ClassNotFoundException classe) {
            Log.e("TeatroPereira", "Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public ArrayList<Evento> eventoLista() {
        ArrayList<Evento> listaEventos;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("EventoLista");
            listaEventos = (ArrayList<Evento>) this.informacoesViewModel.getInputStream().readObject();
        } catch (IOException ioe) {
            Log.e("TeatroPereira", "Erro: " + ioe.getMessage());
            listaEventos = null;
        } catch (ClassNotFoundException classe) {
            Log.e("TeatroPereira", "Erro: " + classe.getMessage());
            listaEventos = null;
        }
        return listaEventos;
    }

    public int listaCadeiras() {
        int cadeirasDisponiveis;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("CadeiraLista");
            mensagem = (String)this.informacoesViewModel.getInputStream().readObject();
            this.informacoesViewModel.getOutputStream().writeObject(evento);
            cadeirasDisponiveis = (int)this.informacoesViewModel.getInputStream().readObject();
        } catch (IOException ioe) {
            Log.e("TeatroPereira", "Erro: " + ioe.getMessage());
            cadeirasDisponiveis = 0;
        } catch (ClassNotFoundException classe) {
            Log.e("TeatroPereira", "Erro: " + classe.getMessage());
            cadeirasDisponiveis = 0;
        }
        return cadeirasDisponiveis;
    }

    public boolean efetuarReserva(Reserva reserva) {
        boolean resultado;
        String mensagem;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("EfetuarReserva");
            mensagem = (String)this.informacoesViewModel.getInputStream().readObject();
            this.informacoesViewModel.getOutputStream().writeObject(reserva);
            resultado = (Boolean)this.informacoesViewModel.getInputStream().readObject();
        } catch (IOException ioe) {
            Log.e("TeatroPereira", "Erro: " + ioe.getMessage());
            resultado = false;
        } catch (ClassNotFoundException classe) {
            Log.e("TeatroPereira", "Erro: " + classe.getMessage());
            resultado = false;
        }
        return resultado;
    }

    public ArrayList<Reserva> reservaLista() {
        ArrayList<Reserva> listaReservas;
        try {
            this.informacoesViewModel.getOutputStream().writeObject("ReservaLista");
            listaReservas = (ArrayList<Reserva>) this.informacoesViewModel.getInputStream().readObject();
        } catch (IOException ioe) {
            Log.e("TeatroPereira", "Erro: " + ioe.getMessage());
            listaReservas = null;
        } catch (ClassNotFoundException classe) {
            Log.e("TeatroPereira", "Erro: " + classe.getMessage());
            listaReservas = null;
        }
        return listaReservas;
    }
}
