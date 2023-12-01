package com.example.teatropereira_mobile.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.teatropereira_mobile.R;
import com.example.teatropereira_mobile.controller.ConexaoController;
import com.example.teatropereira_mobile.databinding.FragmentRedefinirSenhaBinding;
import com.example.teatropereira_mobile.view.util.Hash;
import com.example.teatropereira_mobile.viewModel.InformacoesViewModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import modelDominio.Usuario;

public class RedefinirSenhaFragment extends Fragment {

    FragmentRedefinirSenhaBinding binding;
    InformacoesViewModel informacoesViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_redefinir_senha, container, false);
        binding = FragmentRedefinirSenhaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);

        binding.bRedefinirSenhaAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.etRedefinirSenhaUsuario.getText().toString().equals("")) {
                    if (!binding.etRedefinirSenhaCpf.getText().toString().equals("")) {
                        if (!binding.etRedefinirSenhaEmail.getText().toString().equals("")) {
                            String login = binding.etRedefinirSenhaUsuario.getText().toString();
                            String cpf = binding.etRedefinirSenhaCpf.getText().toString();
                            String email = binding.etRedefinirSenhaEmail.getText().toString();

                            Usuario usuario = new Usuario(login, cpf, email);
                            Thread thread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                                    boolean usuarioExiste = conexaoController.usuarioExiste(usuario);
                                    if (usuarioExiste == true){ // se usuario existe
                                        //senha recebe senha padrão de recuperação 123456
                                        String senha = "123456";
                                        try {
                                            String senhaCriptografada = Hash.encriptar(senha, "SHA-256");
                                            Usuario usuario1 = new Usuario(login, cpf, email, senhaCriptografada);
                                            boolean resultado = conexaoController.usuarioAlterar(usuario1);
                                            getActivity().runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    if(resultado == true) { //se alterou sem erro
                                                        boolean resultado = conexaoController.enviarEmail(email);
                                                        if (resultado == true) {
                                                            Toast.makeText(getContext(), "Uma mensagem com sua nova senha foi enviada no email correspondente.", Toast.LENGTH_LONG).show();
                                                            Navigation.findNavController(view).navigateUp();
                                                        } else {
                                                            binding.etRedefinirSenhaUsuario.setError("Erro: não foi possível enviar email.");
                                                            binding.etRedefinirSenhaEmail.requestFocus();
                                                        }
                                                    } else { //deu erro para alterar
                                                        binding.etRedefinirSenhaUsuario.setError("Erro: usuário não pode ser atualizado.");
                                                        binding.etRedefinirSenhaUsuario.requestFocus();
                                                    }
                                                }
                                            });
                                        } catch (NoSuchAlgorithmException ex) {
                                            binding.etRedefinirSenhaEmail.setError("Erro ao tentar gerar o código hash.");
                                            binding.etRedefinirSenhaEmail.requestFocus();
                                        } catch (UnsupportedEncodingException ex) {
                                            binding.etRedefinirSenhaEmail.setError("Erro ao tentar gerar o código hash.");
                                            binding.etRedefinirSenhaEmail.requestFocus();
                                        }
                                    } else { //usuario não existe, método usuarioExiste == false
                                        Toast.makeText(getContext(), "O usuário, cpf e/ou email informado não existe, confira se as informações estão corretas", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }); thread.start();
                        } else {
                            binding.etRedefinirSenhaEmail.setError("Erro: informe o email.");
                            binding.etRedefinirSenhaEmail.requestFocus();
                        }
                    } else {
                        binding.etRedefinirSenhaCpf.setError("Erro: informe o CPF.");
                        binding.etRedefinirSenhaCpf.requestFocus();
                    }
                } else {
                    binding.etRedefinirSenhaUsuario.setError("Erro: informe o usuário.");
                    binding.etRedefinirSenhaUsuario.requestFocus();
                }
            }
        });

        binding.bRedefinirSenhaCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigateUp();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}