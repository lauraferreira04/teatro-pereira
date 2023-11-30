package com.example.teatropereira_mobile.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavAction;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.teatropereira_mobile.R;
import com.example.teatropereira_mobile.adapter.EventoAdapter;
import com.example.teatropereira_mobile.controller.ConexaoController;
import com.example.teatropereira_mobile.databinding.FragmentReservaBinding;
import com.example.teatropereira_mobile.viewModel.InformacoesViewModel;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import modelDominio.Evento;
import modelDominio.Reserva;
import modelDominio.Usuario;

public class ReservaFragment extends Fragment {

    FragmentReservaBinding binding;
    InformacoesViewModel informacoesViewModel;
    Reserva reserva;
    boolean resultado;
    int cadeirasDisponiveis = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_reserva, container, false);
        binding = FragmentReservaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void carregaSpinnerCadeiras(int cadeirasDisponiveis) {
        String[] cadeiras = new String[cadeirasDisponiveis + 1];
        cadeiras[0] = "<< Selecionar >>";
        for (int x = 1; x <= cadeirasDisponiveis; x++) {
            cadeiras[x + 1] = String.valueOf(x);
        }
        binding.spReservaQtdCadeiras.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, cadeiras));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);
        ReservaFragmentArgs argumentos = ReservaFragmentArgs.fromBundle(getArguments());
        Evento evento = argumentos.getEvento();
        //Bitmap banner = ByteArrayToBitmap(evento.getBanner());
        //binding.ivReservaBanner.setImageBitmap(banner);
        binding.tvReservaTitulo.setText(evento.getNomeEvento());
        binding.tvReservaArtista.setText(evento.getArtista());
        //binding.tvReservaData.setText(String.valueOf(evento.getData().getTime()));
        LocalDateTime dataHora;
        dataHora = java.sql.Date.valueOf(dataHora.toLocalDate());
        binding.tvReservaData.setText(dataHora);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            dataHora = LocalDateTime.parse(evento.getData(), formatter);
        } catch (Exception e) {
            dataHora = null;
            Log.e("TeatroPereira", "Erro: " + e.getMessage());
        }
        binding.tvReservaPreco.setText(String.valueOf(evento.getValor()));
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                cadeirasDisponiveis = conexaoController.listaCadeiras(evento);
                if (cadeirasDisponiveis > 0) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            carregaSpinnerCadeiras(cadeirasDisponiveis);
                        }
                    });
                } else {
                    Toast.makeText(getContext(), "EVENTO ESGOTADO", Toast.LENGTH_LONG).show();
                    Navigation.findNavController(view).navigateUp();
                }
            }
        }); thread.start();

        binding.bReservaReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.spReservaQtdCadeiras.getSelectedItemPosition() > 0) {
                    int idUsuario = informacoesViewModel.getUsuarioLogado().getIdUsuario();
                    Usuario usuario = informacoesViewModel.getUsuarioLogado();
                    int qtdCadeiras = binding.spReservaQtdCadeiras.getSelectedItemPosition();
                    float valorTotal = evento.getValor() * binding.spReservaQtdCadeiras.getSelectedItemPosition();

                    reserva = new Reserva(idUsuario, usuario, evento, qtdCadeiras, valorTotal);
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                            resultado = conexaoController.efetuarReserva(reserva);
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (resultado == true) {
                                        Navigation.findNavController(view).navigate(R.id.acao_ReservaFragment_MinhasReservasFragment);
                                    } else {
                                        Toast.makeText(getContext(), "Erro: reserva não efetuada.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }); thread.start();
                } else {
                    Toast.makeText(getContext(), "Erro: informe a quantidade de ingressos.", Toast.LENGTH_SHORT).show();
                    binding.spReservaQtdCadeiras.requestFocus();
                }
            }
        });

        binding.bReservaCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigateUp();
            }
        });

        binding.bReservaSuporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.acao_ReservaFragment_SuporteFragment);
            }
        });
    }

    public Bitmap ByteArrayToBitmap(byte[] byteArray) {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        return bitmap;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}