package com.bergburg.chatjavamvp.view.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bergburg.chatjavamvp.R;
import com.bergburg.chatjavamvp.model.entities.Contato;
import com.bergburg.chatjavamvp.model.entities.Conversa;
import com.bergburg.chatjavamvp.view.listernes.AcaoListener;
import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class ConversaViewHolder  extends RecyclerView.ViewHolder {
    private CircleImageView imagem;
    private TextView textViewNome, textViewStaus,textViewData;
    private LinearLayout layout;

    public ConversaViewHolder(@NonNull View itemView) {
        super(itemView);

        layout = itemView.findViewById(R.id.linearLayoutConversa);
         imagem = itemView.findViewById(R.id.profile_imageConversa);
         textViewNome = itemView.findViewById(R.id.textViewNomeConversa);
         textViewData = itemView.findViewById(R.id.textViewDataConversa);
}

    public void bind(Conversa conversa, AcaoListener<Conversa> listener){
        Glide.with(itemView.getContext()).load(conversa.getImagemUsuario()).into(imagem);
        textViewNome.setText(conversa.getNome());
        textViewData.setText(conversa.getData_create());

        layout.setOnClickListener(v ->  listener.onClick(conversa) );
    }

}
