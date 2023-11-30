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
import com.example.teatropereira_mobile.databinding.FragmentCadastroBinding;
import com.example.teatropereira_mobile.databinding.FragmentRedefinirSenhaBinding;
import com.example.teatropereira_mobile.view.util.Hash;
import com.example.teatropereira_mobile.viewModel.InformacoesViewModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

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
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                String senha = "123456";
                                                try {
                                                    String senhaCriptografada = Hash.encriptar(senha, "SHA-256");
                                                    Usuario usuario1 = new Usuario(login, cpf, email, senhaCriptografada);
                                                    Thread thread1 = new Thread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            boolean resultado = conexaoController.usuarioAlterar(usuario1);
                                                            getActivity().runOnUiThread(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    if(resultado == true) { //se alterou sem erro
                                                                        //enviarEmail();

                                                                        Toast.makeText(getContext(), "Uma mensagem com sua nova senha foi enviada no email correspondente.", Toast.LENGTH_LONG).show();
                                                                        Navigation.findNavController(view).navigateUp();
                                                                    } else { //deu erro para alterar
                                                                        binding.etRedefinirSenhaUsuario.setError("Erro: usuário não pode ser atualizado.");
                                                                        binding.etRedefinirSenhaUsuario.requestFocus();
                                                                    }
                                                                }
                                                            });
                                                        }
                                                    }); thread1.start();
                                                } catch (NoSuchAlgorithmException ex) {
                                                    binding.etRedefinirSenhaEmail.setError("Erro ao tentar gerar o código hash.");
                                                    binding.etRedefinirSenhaEmail.requestFocus();
                                                } catch (UnsupportedEncodingException ex) {
                                                    binding.etRedefinirSenhaEmail.setError("Erro ao tentar gerar o código hash.");
                                                    binding.etRedefinirSenhaEmail.requestFocus();
                                                }
                                            }
                                        });
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

    /*private void enviarEmail() {
        String remetente = "o.teatropereira@gmail.com";
        String senhaRemetente = "nmvu riar rljg blsm";
        String destinatario = binding.etRedefinirSenhaEmail.getText().toString();
        String assunto = "Teatro Pereira: Recuperação de senha";
        String mensagem = "Sua nova senha é '123456', altere no próximo login.";

        System.out.println(senhaRemetente);

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        //properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(remetente, senhaRemetente);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(assunto);
            message.setText(mensagem);

            Transport.send(message);

            Toast.makeText(getContext(), "E-mail enviado com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (MessagingException e) {
            Toast.makeText(getContext(), "Erro ao enviar e-mail: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}