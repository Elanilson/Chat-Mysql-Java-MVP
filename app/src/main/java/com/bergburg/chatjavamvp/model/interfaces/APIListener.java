package com.bergburg.chatjavamvp.model.interfaces;

public interface APIListener<T>{
    void onSuccess(T result);
    void onFailures(String mensagem);

}