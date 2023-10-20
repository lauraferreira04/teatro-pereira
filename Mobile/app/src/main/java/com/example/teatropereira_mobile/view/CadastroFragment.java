package com.example.teatropereira_mobile.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.teatropereira_mobile.R;
import com.example.teatropereira_mobile.controller.ConexaoController;
import com.example.teatropereira_mobile.databinding.FragmentCadastroBinding;
import com.example.teatropereira_mobile.viewModel.InformacoesViewModel;

import modelDominio.Usuario;

public class CadastroFragment extends Fragment {
    FragmentCadastroBinding binding;
    InformacoesViewModel informacoesViewModel;
    Usuario usuario;
    boolean resultado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_cadastro, container, false);
        binding = FragmentCadastroBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);

        binding.bCadastroCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.etCadastroNome.getText().toString().equals("")) {
                    if (!binding.etCadastroUsuario.getText().toString().equals("")) {
                        if (!binding.etCadastroSenha.getText().toString().equals("")) {
                            if (!binding.etCadastroCpf.getText().toString().equals("")) {
                                if (!binding.etCadastroEmail.getText().toString().equals("")) {
                                    if (!binding.etCadastroTelefone.getText().toString().equals("")) {
                                        String nome = binding.etCadastroNome.getText().toString();
                                        String login = binding.etCadastroUsuario.getText().toString();
                                        String senha = binding.etCadastroSenha.getText().toString();
                                        String cpf = binding.etCadastroCpf.getText().toString();
                                        String email = binding.etCadastroEmail.getText().toString();
                                        String telefone = binding.etCadastroTelefone.getText().toString();
                                        
                                        usuario = new Usuario(nome, login, senha, cpf, email, telefone, 1);
                                        Thread thread = new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                                                resultado = conexaoController.usuarioInserir(usuario);
                                                //criar classe usuario existe
                                                getActivity().runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        if (resultado == true) {
                                                            Toast.makeText(getContext(), "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                                                            limpaCampos();
                                                        } else {
                                                            Toast.makeText(getContext(), "Erro: usuário não cadastrado.", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                            }
                                        }); thread.start();
                                    } else {
                                        binding.etCadastroTelefone.setError("Erro: informe o telefone.");
                                        binding.etCadastroTelefone.requestFocus();
                                    }
                                } else {
                                    binding.etCadastroEmail.setError("Erro: informe o e-mail.");
                                    binding.etCadastroEmail.requestFocus();
                                }
                            } else {
                                binding.etCadastroCpf.setError("Erro: informe o CPF.");
                                binding.etCadastroCpf.requestFocus();
                            }
                        } else {
                            binding.etCadastroSenha.setError("Erro: informe a senha.");
                            binding.etCadastroSenha.requestFocus();
                        }
                    } else {
                        binding.etCadastroUsuario.setError("Erro: informe o usuário.");
                        binding.etCadastroUsuario.requestFocus();
                    }
                } else {
                    binding.etCadastroNome.setError("Erro: informe o nome completo.");
                    binding.etCadastroNome.requestFocus();
                }
            }
        });

        binding.bCadastroCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpaCampos();
            }
        });
    }

    public void limpaCampos() {
        binding.etCadastroNome.setText("");
        binding.etCadastroUsuario.setText("");
        binding.etCadastroSenha.setText("");
        binding.etCadastroCpf.setText("");
        binding.etCadastroEmail.setText("");
        binding.etCadastroTelefone.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}