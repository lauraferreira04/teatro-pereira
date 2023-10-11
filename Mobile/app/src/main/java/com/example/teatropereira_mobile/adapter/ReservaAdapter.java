package com.example.teatropereira_mobile.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teatropereira_mobile.databinding.ReservaListRowBinding;

import java.io.ByteArrayInputStream;
import java.util.List;

import modelDominio.Reserva;

public class ReservaAdapter extends RecyclerView.Adapter<ReservaAdapter.MyViewHolder> {
    private List<Reserva> listaReservas;
    private ReservaOnClickListener reservaOnClickListener;

    public ReservaAdapter(List<Reserva> listaReservas, ReservaOnClickListener reservaOnClickListener) {
        this.listaReservas = listaReservas;
        this.reservaOnClickListener = reservaOnClickListener;
    }

    @Override
    public ReservaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ReservaListRowBinding reservaListRowBinding = ReservaListRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(reservaListRowBinding);
    }

    @Override
    public void onBindViewHolder(final ReservaAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Reserva minhaReserva = listaReservas.get(position);
        Bitmap banner = ByteArrayToBitmap(minhaReserva.getEvento().getBanner());
        holder.reservaListRowBinding.ivMinhasReservasBanner.setImageBitmap(banner);
        holder.reservaListRowBinding.tvMinhasReservasTitulo.setText(String.valueOf(minhaReserva.getEvento().getNomeEvento()));
        holder.reservaListRowBinding.tvMinhasReservasArtista.setText(String.valueOf(minhaReserva.getEvento().getArtista()));
        holder.reservaListRowBinding.tvMinhasReservasData.setText(String.valueOf(minhaReserva.getEvento().getData()));
        holder.reservaListRowBinding.tvMinhasReservasQtdCadeiras.setText(String.valueOf(minhaReserva.getQtdCadeiras()));

        if(reservaOnClickListener != null) {
            holder.reservaListRowBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    reservaOnClickListener.onClickListener(holder.itemView, position, minhaReserva);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaReservas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ReservaListRowBinding reservaListRowBinding;
        public MyViewHolder(ReservaListRowBinding reservaListRowBinding) {
            super(reservaListRowBinding.getRoot());
            this.reservaListRowBinding = reservaListRowBinding;
        }
    }

    public interface ReservaOnClickListener {
        public void onClickListener(View view, int position, Reserva reserva);
    }

    public Bitmap ByteArrayToBitmap(byte[] byteArray) {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        return bitmap;
    }
}
