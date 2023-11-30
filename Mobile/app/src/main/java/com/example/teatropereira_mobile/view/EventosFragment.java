package com.example.teatropereira_mobile.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teatropereira_mobile.R;
import com.example.teatropereira_mobile.adapter.EventoAdapter;
import com.example.teatropereira_mobile.controller.ConexaoController;
import com.example.teatropereira_mobile.databinding.FragmentEventosBinding;
import com.example.teatropereira_mobile.viewModel.InformacoesViewModel;

import java.util.ArrayList;

import modelDominio.Evento;

public class EventosFragment extends Fragment {

    FragmentEventosBinding binding;
    EventoAdapter eventoAdapter;
    InformacoesViewModel informacoesViewModel;
    ArrayList<Evento> listaEventos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_eventos, container, false);
        binding = FragmentEventosBinding.inflate(inflater, container, false);
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
                listaEventos = conexaoController.eventoLista();
                if (listaEventos != null) {
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
        eventoAdapter = new EventoAdapter(listaEventos, trataCliqueItem);
        binding.rvVisualizacaoEventos.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvVisualizacaoEventos.setItemAnimator(new DefaultItemAnimator());
        binding.rvVisualizacaoEventos.setAdapter(eventoAdapter);
    }

    EventoAdapter.EventoOnClickListener trataCliqueItem = new EventoAdapter.EventoOnClickListener() {
        @Override
        public void onClickListener(View view, int position, Evento evento) {
            EventosFragmentDirections.AcaoEventosFragmentReservaFragment acao =
                    EventosFragmentDirections.acaoEventosFragmentReservaFragment(evento);
            Navigation.findNavController(view).navigate(acao);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}