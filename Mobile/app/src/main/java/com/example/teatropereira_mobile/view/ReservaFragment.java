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
import java.util.ArrayList;

import modelDominio.Evento;
import modelDominio.Reserva;
import modelDominio.Usuario;

public class ReservaFragment extends Fragment {

    FragmentReservaBinding binding;
    InformacoesViewModel informacoesViewModel;
    Reserva reserva;
    boolean resultado;


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
            cadeiras[x] = String.valueOf(x);
        }
        binding.spReservaQtdCadeiras.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, cadeiras));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        informacoesViewModel = new ViewModelProvider(getActivity()).get(InformacoesViewModel.class);
        ReservaFragmentArgs argumentos = ReservaFragmentArgs.fromBundle(getArguments());
        Evento evento = argumentos.getEvento();
        Bitmap banner = ByteArrayToBitmap(evento.getImagem());
        binding.ivReservaBanner.setImageBitmap(banner);
        binding.tvReservaTitulo.setText(evento.getNomeEvento());
        binding.tvReservaArtista.setText(evento.getArtista());
        LocalDateTime dataHora = evento.getDataHora();
        binding.tvReservaData.setText(dataHora.toString());
        binding.tvReservaPreco.setText(String.valueOf(evento.getValor()));
        if (evento.getQtdCadeiras() > 0) {
            carregaSpinnerCadeiras(evento.getQtdCadeiras());
        } else {
            Toast.makeText(getContext(), "EVENTO ESGOTADO", Toast.LENGTH_LONG).show();
            Navigation.findNavController(view).navigateUp();
        }

        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                resultado = conexaoController.listaCadeiras(evento);
                if (resultado == false) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            carregaSpinnerCadeiras(evento.getQtdCadeiras());
                        }
                    });
                } else {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(), "EVENTO ESGOTADO", Toast.LENGTH_LONG).show();
                            Navigation.findNavController(view).navigateUp();
                        }
                    });
                }
            }
        }); thread.start();*/

        binding.bReservaReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.spReservaQtdCadeiras.getSelectedItemPosition() > 0) {
                    Usuario usuario = informacoesViewModel.getUsuarioLogado();
                    int qtdCadeiras = binding.spReservaQtdCadeiras.getSelectedItemPosition();
                    float valorTotal = evento.getValor() * binding.spReservaQtdCadeiras.getSelectedItemPosition();

                    reserva = new Reserva(usuario, evento, qtdCadeiras, valorTotal);
                    Evento evento1 = new Evento(evento.getIdEvento(), evento.getNomeEvento(), evento.getArtista(), evento.getDataHora(), valorTotal, qtdCadeiras);
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ConexaoController conexaoController = new ConexaoController(informacoesViewModel);
                            Log.e("TeatroPereira", "Reserva: " + reserva.toString());
                            resultado = conexaoController.efetuarReserva(reserva);
                            Log.e("TeatroPereira", "efetuarReserva: " + resultado);
                            if (resultado == true) {
                                resultado = conexaoController.reservaCadeira(evento1);
                                Log.e("TeatroPereira", "reservaCadeira: " + resultado);
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (resultado == true) {
                                            Toast.makeText(getContext(), "Reserva efetuada com sucesso.", Toast.LENGTH_SHORT).show();
                                            Navigation.findNavController(view).navigate(R.id.acao_ReservaFragment_MinhasReservasFragment);
                                        } else {
                                            Toast.makeText(getContext(), "Erro: informe uma quantidade válida de cadeiras.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getContext(), "Erro: reserva não efetuada.", Toast.LENGTH_SHORT).show();
                                        binding.spReservaQtdCadeiras.requestFocus();
                                    }
                                });
                            }
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