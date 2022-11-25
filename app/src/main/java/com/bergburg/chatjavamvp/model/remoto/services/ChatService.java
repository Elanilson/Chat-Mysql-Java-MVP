package com.bergburg.chatjavamvp.model.remoto.services;

import com.bergburg.chatjavamvp.model.entities.Dados;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ChatService {

    @GET("getUsuarios.php")
    Call<Dados> getContatos();
    @GET("getConversas.php")
    Call<Dados> getConversas() ;

    @POST("getMensagens.php/")
    @FormUrlEncoded
    Call<Dados> getMensagens(@Field("idUsuario")Long idUsuario);

    @POST("salvarMensagem.php/")
    @FormUrlEncoded
    Call<Dados> enviarMensagem(
            @Field("idUsuario") Long idUsuario,
            @Field("texto") String texto,
            @Field("idConversa") Long idConversa
    );
}
