package com.example.teatropereira_mobile.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.teatropereira_mobile.R;
import com.example.teatropereira_mobile.controller.ConexaoController;
import com.example.teatropereira_mobile.databinding.FragmentLoginBinding;
import com.example.teatropereira_mobile.viewModel.InformacoesViewModel;

import modelDominio.Usuario;

public class LoginFragment extends Fragment {
    FragmentLoginBinding binding;
    InformacoesViewModel informacoesViewModel;
    boolean resultado;
    Usuario usuarioLogado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false);
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                resultado = conexaoController.criaConexaoServidor("127.0.0.1",12345);

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (resultado == true) {
                            Toast.makeText(getContext(), "Conexão estabelecida com sucesso.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "Erro: conexão com o servidor não efetuada.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }); thread.start();

        binding.bLoginEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.etLoginUsuario.getText().toString().equals("")) {
                    if (!binding.etLoginSenha.getText().toString().equals("")) {
                        String usuario = binding.etLoginUsuario.getText().toString();
                        String senha = binding.etLoginSenha.getText().toString();

                        usuarioLogado = new Usuario(usuario, senha);
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                                usuarioLogado = conexaoController.efetuarLogin(usuarioLogado);
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (usuarioLogado != null) {
                                            informacoesViewModel.inicializaUsuarioLogado(usuarioLogado);
                                            Navigation.findNavController(view).navigate(R.id.acao_LoginFragment_HomeFragment);
                                        } else {
                                            Toast.makeText(getContext(), "Erro: usuário e/ou senha inválidos.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }); thread.start();
                    } else {
                        binding.etLoginSenha.setError("Erro: informe a senha.");
                        binding.etLoginSenha.requestFocus();
                    }
                } else {
                    binding.etLoginUsuario.setError("Erro: informe o usuário.");
                    binding.etLoginUsuario.requestFocus();
                }
            }
        });

        binding.bLoginCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.acao_LoginFragment_CadastroFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}