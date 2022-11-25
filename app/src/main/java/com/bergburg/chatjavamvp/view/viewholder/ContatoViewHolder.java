package com.bergburg.chatjavamvp.view.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bergburg.chatjavamvp.R;
import com.bergburg.chatjavamvp.model.entities.Contato;
import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContatoViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imagem;
        private TextView textViewNome, textViewStaus;

        public ContatoViewHolder(@NonNull View itemView) {
                super(itemView);

                imagem = itemView.findViewById(R.id.profile_imageContato);
                textViewNome = itemView.findViewById(R.id.textViewNomeContato);
        }

        public void bind(Contato contato){
                Glide.with(itemView.getContext()).load(contato.getImagem()).into(imagem);
                textViewNome.setText(contato.getNome());
        }
}
