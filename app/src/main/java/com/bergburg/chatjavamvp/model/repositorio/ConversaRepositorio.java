package com.bergburg.chatjavamvp.model.repositorio;

import com.bergburg.chatjavamvp.model.entities.Dados;
import com.bergburg.chatjavamvp.model.interfaces.APIListener;
import com.bergburg.chatjavamvp.model.remoto.RetrofitClient;
import com.bergburg.chatjavamvp.model.remoto.services.ChatService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConversaRepositorio {

    private ChatService service = RetrofitClient.classService(ChatService.class);

    public void carregarConversas(APIListener<Dados> listener ){
        Call<Dados> call = service.getConversas();
        call.enqueue(new Callback<Dados>() {
            @Override
            public void onResponse(Call<Dados> call, Response<Dados> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Dados> call, Throwable t) {
                listener.onFailures(t.getMessage().toString());
            }
        });

    }
}
