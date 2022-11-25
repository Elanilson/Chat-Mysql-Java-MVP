package com.bergburg.chatjavamvp.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bergburg.chatjavamvp.R;
import com.bergburg.chatjavamvp.databinding.FragmentConversasBinding;
import com.bergburg.chatjavamvp.model.entities.Conversa;
import com.bergburg.chatjavamvp.presenter.ConversaPresenter;
import com.bergburg.chatjavamvp.view.activitys.ChatActivity;
import com.bergburg.chatjavamvp.view.adapter.ConversaAdapter;
import com.bergburg.chatjavamvp.view.interfaces.ConversaView;
import com.bergburg.chatjavamvp.view.listernes.AcaoListener;

import java.util.List;

public class ConversasFragment extends Fragment  implements ConversaView {
    private FragmentConversasBinding binding;
    private ConversaPresenter presenter;
    private ConversaAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentConversasBinding.inflate(getLayoutInflater(), container, false);
        configurarRecycleview();
        presenter = new ConversaPresenter(this);
        AcaoListener<Conversa> listener = new AcaoListener<Conversa>() {
            @Override
            public void onClick(Conversa objeto) {
                Bundle bundle = new  Bundle();
                bundle.putLong("idUsuario",objeto.getIdUsuario());
                bundle.putLong("idConversa",objeto.getId());
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };
        adapter.attackListener(listener);
        return binding.getRoot();
    }

    private void  configurarRecycleview(){
        adapter = new ConversaAdapter();
        binding.recyclerViewConversa.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerViewConversa.setAdapter(adapter);

    }

    @Override
    public void exibirConversas(List<Conversa> conversas) {
       if(conversas != null){
           adapter.attackConversas(conversas);
       }
    }

    @Override
    public void mensagem(String mensagem) {
        Toast.makeText(getActivity(), mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.exibirConversas();
    }
}