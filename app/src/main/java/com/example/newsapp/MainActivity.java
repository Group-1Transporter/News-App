package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.newsapp.Adapters.FragementAdapter;
import com.example.newsapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();

        binding.viewPager.setAdapter(new FragementAdapter(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewPager);
    }
}