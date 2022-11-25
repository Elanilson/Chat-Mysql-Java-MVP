package com.bergburg.chatjavamvp.model.entities;

import java.util.List;

public class Dados {

    private Boolean status = false;
    private List<Contato> contatos;
    private List<Conversa> conversas;
    private List<Mensagem> mensagens;
    private Mensagem mensagem;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Conversa> getConversas() {
        return conversas;
    }

    public void setConversas(List<Conversa> conversas) {
        this.conversas = conversas;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }
}
