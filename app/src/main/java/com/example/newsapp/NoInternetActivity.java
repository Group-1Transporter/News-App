package com.example.newsapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newsapp.NetworkCheck.NetworkUtility;
import com.example.newsapp.databinding.ActivityNoInternetBinding;

public class NoInternetActivity extends AppCompatActivity {
    ActivityNoInternetBinding binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        binding = ActivityNoInternetBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

    }

    @Override
    protected void onStart() {
        super.onStart();
        binding.tvRetry.setOnClickListener(view -> {
            if (!NetworkUtility.checkInternetConnection(this)) {
                Toast.makeText(NoInternetActivity.this, "Retry", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(NoInternetActivity.this, MainActivity.class);
                startActivity(intent);
                fileList();
            }
        });

    }
}
