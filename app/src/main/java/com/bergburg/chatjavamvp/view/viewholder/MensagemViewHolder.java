package com.bergburg.chatjavamvp.view.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bergburg.chatjavamvp.R;
import com.bergburg.chatjavamvp.model.entities.Mensagem;

public class MensagemViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewNome,textViewData;

    public MensagemViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewNome = itemView.findViewById(R.id.textMensagemTexto);
        textViewData = itemView.findViewById(R.id.textViewData);
    }

    public void bind(Mensagem mensagem){
        textViewNome.setText(mensagem.getTexto());
        textViewData.setText(mensagem.getData_create());
    }
}
