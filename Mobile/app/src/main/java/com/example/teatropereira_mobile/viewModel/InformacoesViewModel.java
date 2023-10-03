package com.example.teatropereira_mobile.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelDominio.Evento;
import modelDominio.Usuario;

public class InformacoesViewModel extends ViewModel {
    private MutableLiveData<ObjectInputStream> mIn;
    private MutableLiveData<ObjectOutputStream> mOut;

    private MutableLiveData<Usuario> mUsuarioLogado;

    public void inicializaObjetosSocket(ObjectInputStream in, ObjectOutputStream out) {
        this.mIn = new MutableLiveData<>();
        this.mOut = new MutableLiveData<>();
        this.mIn.postValue(in);
        this.mOut.postValue(out);
    }

    public void inicializaUsuarioLogado(Usuario usuarioLogado) {
        this.mUsuarioLogado = new MutableLiveData<>();
        this.mUsuarioLogado.postValue(usuarioLogado);
    }

    public ObjectInputStream getInputStream() {
        return this.mIn.getValue();
    }

    public ObjectOutputStream getOutputStream() {
        return this.mOut.getValue();
    }

    public Usuario getUsuarioLogado() {
        return this.mUsuarioLogado.getValue();
    }
}
