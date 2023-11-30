package com.example.teatropereira_mobile.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teatropereira_mobile.databinding.EventoListRowBinding;

import java.io.ByteArrayInputStream;
import java.util.List;

import modelDominio.Evento;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.MyViewHolder> {
    private List<Evento> listaEventos;
    private EventoOnClickListener eventoOnClickListener;

    public EventoAdapter(List<Evento> listaEventos, EventoOnClickListener eventoOnClickListener) {
        this.listaEventos = listaEventos;
        this.eventoOnClickListener = eventoOnClickListener;
    }

    @Override
    public EventoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        EventoListRowBinding eventoListRowBinding = EventoListRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(eventoListRowBinding);
    }

    @Override
    public void onBindViewHolder(final EventoAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Evento meuEvento = listaEventos.get(position);
        if (meuEvento.getBanner() != null) {
            Bitmap banner = ByteArrayToBitmap(meuEvento.getBanner());
            holder.eventoListRowBinding.ivEventoBanner.setImageBitmap(banner);
        }
        holder.eventoListRowBinding.tvEventoNome.setText(meuEvento.getNomeEvento());

        if(eventoOnClickListener != null) {
            holder.eventoListRowBinding.getRoot().setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   eventoOnClickListener.onClickListener(holder.itemView, position, meuEvento);
               }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaEventos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public EventoListRowBinding eventoListRowBinding;
        public MyViewHolder(EventoListRowBinding eventoListRowBinding) {
            super(eventoListRowBinding.getRoot());
            this.eventoListRowBinding = eventoListRowBinding;
        }
    }

    public interface EventoOnClickListener {
        public void onClickListener(View view, int position, Evento evento);
    }

    public Bitmap ByteArrayToBitmap(byte[] byteArray) {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        return bitmap;
    }
}
