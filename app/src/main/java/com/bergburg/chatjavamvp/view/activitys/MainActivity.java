package com.bergburg.chatjavamvp.view.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.bergburg.chatjavamvp.R;
import com.bergburg.chatjavamvp.databinding.ActivityMainBinding;
import com.bergburg.chatjavamvp.view.fragment.ContatosFragment;
import com.bergburg.chatjavamvp.view.fragment.ConversasFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private  Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        configuracaoBottonNavigation();
    }

    private void configuracaoBottonNavigation() {

        getSupportFragmentManager().beginTransaction().replace(R.id.bodyRelativeLayout, new ContatosFragment()).commit();
        binding.bottomNavigation.setSelectedItemId(R.id.contatos);
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.contatos:
                        fragment = new ContatosFragment();
                        break;
                    case R.id.conversas:
                        fragment = new ConversasFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.bodyRelativeLayout, fragment).commit();
                return  true;
            }
        });
    }
}