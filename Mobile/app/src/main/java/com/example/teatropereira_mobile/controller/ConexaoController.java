package com.example.teatropereira_mobile.controller;

import android.util.Log;

import com.example.teatropereira_mobile.viewModel.InformacoesViewModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
}
