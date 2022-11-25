package com.bergburg.chatjavamvp.view.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Toast;

import com.bergburg.chatjavamvp.databinding.ActivityChatBinding;
import com.bergburg.chatjavamvp.model.entities.Mensagem;
import com.bergburg.chatjavamvp.presenter.MensagemPresenter;
import com.bergburg.chatjavamvp.view.adapter.MensagemAdapter;
import com.bergburg.chatjavamvp.view.interfaces.MensagemView;

import java.util.Calendar;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements MensagemView {
    private ActivityChatBinding binding;
    private MensagemPresenter presenter;
    private MensagemAdapter adapter;
    private Long idUsuario = 1L;
    private Long idRemetente = 1L;
    private Long idConversa = 0L;
    private String texto;


    private Runnable runnable;
    private Handler handler = new Handler();
    private Boolean ticker = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new MensagemPresenter(this);
        adapter = new MensagemAdapter();

        binding.imageButtonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = binding.editTextMensagem.getText().toString();
                presenter.enviarMensagem(idRemetente,idConversa,texto);
                binding.editTextMensagem.setText("");
            }
        });
        configurarRecycleview();
    }

    private void startClock(){
        final Calendar calendar = Calendar.getInstance();
        this.runnable = new Runnable() {
            @Override
            public void run() {
                if(!ticker){
                    return;
                }

                presenter.getMensagens(idUsuario);

                Long now = SystemClock.uptimeMillis();
                Long next = now + (1000 - (now % 1000));
                handler.postAtTime(runnable,next);



            }
        };
        this.runnable.run();
    }

    private void  configurarRecycleview(){
        binding.recyclerViewChat.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewChat.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            idUsuario =  bundle.getLong("idUsuario");
            idConversa =  bundle.getLong("idConversa");
            presenter.getMensagens(idUsuario);
            ticker = true;
            startClock();
        }





    }

    @Override
    protected void onStop() {
        super.onStop();
        ticker = false;
    }

    @Override
    public void exibirMensagens(List<Mensagem> mensagens) {

        if(mensagens != null){
            adapter.attackConversas(mensagens);
        }

    }

    @Override
    public void mensagem(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();

    }
}