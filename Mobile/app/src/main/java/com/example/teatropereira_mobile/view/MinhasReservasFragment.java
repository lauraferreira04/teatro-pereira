package com.example.teatropereira_mobile.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teatropereira_mobile.adapter.EventoAdapter;
import com.example.teatropereira_mobile.adapter.ReservaAdapter;
import com.example.teatropereira_mobile.controller.ConexaoController;
import com.example.teatropereira_mobile.databinding.FragmentMinhasReservasBinding;
import com.example.teatropereira_mobile.viewModel.InformacoesViewModel;

import java.util.ArrayList;

import modelDominio.Reserva;

public class MinhasReservasFragment extends Fragment {

    FragmentMinhasReservasBinding binding;
    ReservaAdapter reservaAdapter;
    InformacoesViewModel informacoesViewModel;
    ArrayList<Reserva> listaReservas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_visualiza_eventos, container, false);
        binding = FragmentMinhasReservasBinding.inflate(inflater, container, false);
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
                listaReservas = conexaoController.reservaLista();
                if (listaReservas != null) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            atualizaListagem();
                        }
                    });
                }
            }
        }); thread.start();
    }

    public void atualizaListagem() {
        reservaAdapter = new ReservaAdapter(listaReservas);
        binding.rvVisualizacaoReservas.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvVisualizacaoReservas.setItemAnimator(new DefaultItemAnimator());
        binding.rvVisualizacaoReservas.setAdapter(reservaAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}