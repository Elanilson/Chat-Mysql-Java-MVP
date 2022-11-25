package com.bergburg.chatjavamvp.view.interfaces;

import com.bergburg.chatjavamvp.model.entities.Contato;

import java.util.List;

public interface ContatoView {
    public void exibirContatos(List<Contato> contatos);
    public void mensagem(String mensagem);
}
