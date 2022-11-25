package com.bergburg.chatjavamvp.model.entities;

public class Contato {

    private Long id;
    private Long idConversa;
    private String nome;
    private String imagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(Long idConversa) {
        this.idConversa = idConversa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
