package com.bergburg.chatjavamvp.view.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bergburg.chatjavamvp.R;
import com.bergburg.chatjavamvp.databinding.ActivityEntradaBinding;

public class EntradaActivity extends AppCompatActivity {
    private ActivityEntradaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEntradaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.buttonIniciar.setOnClickListener(v -> proximaTela());
    }

    private void proximaTela() {
        startActivity(new Intent(this, MainActivity.class));
    }
}