package com.bergburg.chatjavamvp.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bergburg.chatjavamvp.R;
import com.bergburg.chatjavamvp.databinding.FragmentContatosBinding;
import com.bergburg.chatjavamvp.model.entities.Contato;
import com.bergburg.chatjavamvp.presenter.ContatoPresenter;
import com.bergburg.chatjavamvp.view.adapter.ContatoAdapter;
import com.bergburg.chatjavamvp.view.interfaces.ContatoView;

import java.util.List;

public class ContatosFragment extends Fragment implements ContatoView {
    private FragmentContatosBinding binding;
    private ContatoPresenter presenter;
    private ContatoAdapter adapter;

    public ContatosFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentContatosBinding.inflate(getLayoutInflater(), container, false);
        presenter = new ContatoPresenter(this);
        configurarRecycleview();

        return binding.getRoot();
    }

    private void  configurarRecycleview(){
        adapter = new ContatoAdapter();
        binding.recyclerViewContatos.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerViewContatos.setAdapter(adapter);

    }

    @Override
    public void exibirContatos(List<Contato> contatos) {
        if(contatos != null){
            adapter.attackContatos(contatos);
        }

    }

    @Override
    public void mensagem(String mensagem) {
        Toast.makeText(getActivity(), mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.exibirContatos();
    }
}