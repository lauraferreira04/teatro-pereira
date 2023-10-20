package com.example.teatropereira_mobile.controller;

import android.util.Log;

import com.example.teatropereira_mobile.viewModel.InformacoesViewModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
}
