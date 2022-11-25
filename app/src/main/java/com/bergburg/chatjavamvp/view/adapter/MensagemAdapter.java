package com.bergburg.chatjavamvp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bergburg.chatjavamvp.R;
import com.bergburg.chatjavamvp.model.entities.Conversa;
import com.bergburg.chatjavamvp.model.entities.Mensagem;
import com.bergburg.chatjavamvp.view.listernes.AcaoListener;
import com.bergburg.chatjavamvp.view.viewholder.MensagemViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MensagemAdapter extends RecyclerView.Adapter<MensagemViewHolder> {
    private List<Mensagem> mensagens = new ArrayList<>();
    private int TIPO_REMETENTE = 0;
    private int TIPO_DESTINATARIO = 1;
    private View view;

    @NonNull
    @Override
    public MensagemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TIPO_REMETENTE){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mensagem_remetente,parent,false);
        }else if (viewType == TIPO_DESTINATARIO){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_mensagem_destinatario,parent,false);
        }
        return  new MensagemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MensagemViewHolder holder, int position) {
        holder.bind(mensagens.get(position));
    }
    @Override
    public int getItemViewType(int position) {
        // return super.getItemViewType(position)
        if(mensagens.get(position).getIdUsuario() == 1L){
            return TIPO_REMETENTE;
        }
        return TIPO_DESTINATARIO;
    }

    @Override
    public int getItemCount() {
        return mensagens.size();
    }

    public void attackConversas(List<Mensagem> mensagens ){
        this.mensagens = mensagens;
        notifyDataSetChanged();
    }

}
