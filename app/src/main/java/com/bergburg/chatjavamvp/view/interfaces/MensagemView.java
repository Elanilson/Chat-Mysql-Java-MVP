package com.bergburg.chatjavamvp.view.interfaces;

import com.bergburg.chatjavamvp.model.entities.Mensagem;

import java.util.List;

public interface MensagemView {
    public void exibirMensagens(List<Mensagem> mensagens);
    public void mensagem(String mensagem);
}
