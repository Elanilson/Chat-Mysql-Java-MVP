package com.bergburg.chatjavamvp.view.interfaces;

import com.bergburg.chatjavamvp.model.entities.Conversa;

import java.util.List;

public interface ConversaView {
    public void exibirConversas(List<Conversa> conversas);
    public void mensagem(String mensagem);
}
