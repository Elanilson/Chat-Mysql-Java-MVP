package com.bergburg.chatjavamvp.presenter;

import com.bergburg.chatjavamvp.model.entities.Dados;
import com.bergburg.chatjavamvp.model.interfaces.APIListener;
import com.bergburg.chatjavamvp.model.repositorio.MensagensRepositorio;
import com.bergburg.chatjavamvp.view.interfaces.MensagemView;

public class MensagemPresenter {
    private MensagemView view;
    private MensagensRepositorio repositorio = new MensagensRepositorio();

    public MensagemPresenter(MensagemView view) {
        this.view = view;
    }

    public void getMensagens(Long idUsuario){
        APIListener<Dados> listener = new APIListener<Dados>() {
            @Override
            public void onSuccess(Dados result) {
                view.exibirMensagens(result.getMensagens());
            }

            @Override
            public void onFailures(String mensagem) {
                view.mensagem(mensagem);
            }
        };

        repositorio.getMensagens(listener,idUsuario);
    }

    public void enviarMensagem(Long idUsuario, Long idConversa, String texto){
        APIListener<Dados> listener = new APIListener<Dados>() {
            @Override
            public void onSuccess(Dados result) {
                if(result.getStatus()){
                    view.mensagem("Sucesso");
                }else{
                    view.mensagem("Não foi possível enviar");
                }
            }

            @Override
            public void onFailures(String mensagem) {
                view.mensagem(mensagem);
            }
        };

        repositorio.enviarMensagem(listener,idUsuario,texto,idConversa);
    }
}
