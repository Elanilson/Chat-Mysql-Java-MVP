package com.bergburg.chatjavamvp.presenter;

import com.bergburg.chatjavamvp.model.entities.Dados;
import com.bergburg.chatjavamvp.model.interfaces.APIListener;
import com.bergburg.chatjavamvp.model.repositorio.ConversaRepositorio;
import com.bergburg.chatjavamvp.view.interfaces.ConversaView;

public class ConversaPresenter {
    private ConversaView view;
    private ConversaRepositorio repositorio = new ConversaRepositorio();

    public ConversaPresenter(ConversaView view) {
        this.view = view;
    }

    public void exibirConversas(){
        APIListener<Dados> listener = new APIListener<Dados>() {
            @Override
            public void onSuccess(Dados result) {
                view.exibirConversas(result.getConversas());
            }

            @Override
            public void onFailures(String mensagem) {
                view.mensagem(mensagem);
            }
        };
        repositorio.carregarConversas(listener);

    }
}
