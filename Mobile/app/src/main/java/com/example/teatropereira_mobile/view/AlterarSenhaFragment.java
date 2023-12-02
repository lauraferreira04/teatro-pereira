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
import com.example.teatropereira_mobile.databinding.FragmentAlterarSenhaBinding;
import com.example.teatropereira_mobile.view.util.Hash;
import com.example.teatropereira_mobile.viewModel.InformacoesViewModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class AlterarSenhaFragment extends Fragment {

    FragmentAlterarSenhaBinding binding;
    InformacoesViewModel informacoesViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_alterar_senha, container, false);
        binding = FragmentAlterarSenhaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);

        binding.bAlterarSenhaAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String senhaVelha = binding.etAlterarSenhaAntiga.getText().toString();
                String senhaNova = binding.etAlterarSenhaNova.getText().toString();
                String confirmaSenha = binding.etAlterarSenhaConfirmar.getText().toString();
                if (!senhaVelha.equals("")){
                    if (!senhaNova.equals("")){
                        if (!confirmaSenha.equals("")){
                            if (senhaNova.equals(confirmaSenha)){
                                try {
                                    String senhaCriptografadaVelha = Hash.encriptar(senhaVelha, "SHA-256");
                                    informacoesViewModel.getUsuarioLogado().setSenha(senhaCriptografadaVelha);
                                    Log.e("TeatroPereira", "Senha: " + informacoesViewModel.getUsuarioLogado().getSenha());
                                    String senhaCriptografadaNova = Hash.encriptar(senhaNova, "SHA-256");
                                    Thread thread = new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                                            boolean senhaExiste = conexaoController.senhaUsuarioExiste(informacoesViewModel.getUsuarioLogado(), senhaCriptografadaNova);

                                            getActivity().runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    if (senhaExiste == true){
                                                        informacoesViewModel.getUsuarioLogado().setSenha(senhaCriptografadaNova);
                                                        Toast.makeText(getContext(), "Senha alterarda com sucesso.", Toast.LENGTH_SHORT).show();
                                                        Navigation.findNavController(view).navigateUp();
                                                    } else {
                                                        Toast.makeText(getContext(), "Erro ao alterar senha.", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });
                                        }
                                    }); thread.start();
                                } catch (NoSuchAlgorithmException ex) {
                                    binding.etAlterarSenhaNova.setError("Erro ao tentar gerar o código hash.");
                                    binding.etAlterarSenhaNova.requestFocus();
                                } catch (UnsupportedEncodingException ex) {
                                    binding.etAlterarSenhaNova.setError("Erro ao tentar gerar o código hash.");
                                    binding.etAlterarSenhaNova.requestFocus();
                                }
                            } else {
                                binding.etAlterarSenhaConfirmar.setError("Erro: as senhas não coincidem.");
                                binding.etAlterarSenhaConfirmar.requestFocus();
                            }
                        } else {
                            binding.etAlterarSenhaConfirmar.setError("Erro: confirme a senha nova.");
                            binding.etAlterarSenhaConfirmar.requestFocus();
                        }
                    } else {
                        binding.etAlterarSenhaNova.setError("Erro: informe a nova senha.");
                        binding.etAlterarSenhaNova.requestFocus();
                    }
                } else {
                    binding.etAlterarSenhaAntiga.setError("Erro: informe a senha atual.");
                    binding.etAlterarSenhaAntiga.requestFocus();
                }
            }
        });

        binding.bAlterarSenhaCancelar.setOnClickListener(new View.OnClickListener() {
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