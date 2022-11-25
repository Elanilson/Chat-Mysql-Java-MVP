package com.bergburg.chatjavamvp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bergburg.chatjavamvp.R;
import com.bergburg.chatjavamvp.model.entities.Conversa;
import com.bergburg.chatjavamvp.view.listernes.AcaoListener;
import com.bergburg.chatjavamvp.view.viewholder.ConversaViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ConversaAdapter extends RecyclerView.Adapter<ConversaViewHolder> {
    private List<Conversa> conversas = new ArrayList<>();
    private AcaoListener<Conversa> listener;

    @NonNull
    @Override
    public ConversaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_conversa,parent,false);
        return new ConversaViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversaViewHolder holder, int position) {
        holder.bind(conversas.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return conversas.size();
    }

    public void attackConversas(List<Conversa> conversas ){
        this.conversas = conversas;
        notifyDataSetChanged();
    }
    public void attackListener(AcaoListener<Conversa> listener){
        this.listener = listener;

    }
}
