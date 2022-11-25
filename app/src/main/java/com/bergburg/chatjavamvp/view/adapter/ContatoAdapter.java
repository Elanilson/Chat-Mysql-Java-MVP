package com.bergburg.chatjavamvp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bergburg.chatjavamvp.R;
import com.bergburg.chatjavamvp.model.entities.Contato;
import com.bergburg.chatjavamvp.view.viewholder.ContatoViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ContatoAdapter extends RecyclerView.Adapter<ContatoViewHolder> {
    private List<Contato> contatos = new ArrayList<>();

    @NonNull
    @Override
    public ContatoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_contato,parent,false);
        return new ContatoViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ContatoViewHolder holder, int position) {
        holder.bind(contatos.get(position));
    }

    @Override
    public int getItemCount() {
        return contatos.size();
    }

    public void attackContatos(List<Contato> contatos ){
        this.contatos = contatos;
        notifyDataSetChanged();
    }
}
