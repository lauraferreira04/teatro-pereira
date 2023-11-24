package com.example.teatropereira_mobile.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavAction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.teatropereira_mobile.R;
import com.example.teatropereira_mobile.adapter.ReservaAdapter;
import com.example.teatropereira_mobile.controller.ConexaoController;
import com.example.teatropereira_mobile.databinding.FragmentReservaBinding;
import com.example.teatropereira_mobile.viewModel.InformacoesViewModel;

import java.util.ArrayList;

import modelDominio.Evento;

public class ReservaFragment extends Fragment {

    FragmentReservaBinding binding;
    ReservaAdapter reservaAdapter;
    InformacoesViewModel informacoesViewModel;
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
        binding.tvReservaTitulo.setText(evento.getNomeEvento());
        binding.tvReservaArtista.setText(evento.getArtista());
        binding.tvReservaData.setText(evento.getData().toString());
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
                    //colocar um where no select do banco OU
                    Toast.makeText(getContext(), "EVENTO ESGOTADO", Toast.LENGTH_LONG).show();
                    Navigation.findNavController(view).navigateUp();
                }
            }
        }); thread.start();

        //fazer o metódo nos dois lugares do servidor

        /*confirmar compra
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ConexaoController conexaoController = new ConexaoController(informacoesViewModel);

            }
        }); thread.start();*/

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}