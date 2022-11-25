package com.bergburg.chatjavamvp.presenter;

import com.bergburg.chatjavamvp.model.entities.Dados;
import com.bergburg.chatjavamvp.model.interfaces.APIListener;
import com.bergburg.chatjavamvp.model.repositorio.ContatoRepositorio;
import com.bergburg.chatjavamvp.view.interfaces.ContatoView;

public class ContatoPresenter {
    private ContatoView view;
    private ContatoRepositorio repositorio = new ContatoRepositorio();

    public ContatoPresenter(ContatoView view) {
        this.view = view;
    }

    public void exibirContatos(){
        APIListener<Dados> listener = new APIListener<Dados>() {
            @Override
            public void onSuccess(Dados result) {
                view.exibirContatos(result.getContatos());
            }

            @Override
            public void onFailures(String mensagem) {
                view.mensagem(mensagem);
            }
        };

        repositorio.carregarContatos(listener);
    }
}
