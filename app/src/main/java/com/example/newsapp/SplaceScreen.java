package com.example.newsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.newsapp.NetworkCheck.NetworkUtility;
import com.example.newsapp.databinding.ActivitySplaceScreenBinding;


public class SplaceScreen extends AppCompatActivity {
    ActivitySplaceScreenBinding binding;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplaceScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        if (!NetworkUtility.checkInternetConnection(this)) {
            //Toast.makeText(this, "Please enable internet connection", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SplaceScreen.this, NoInternetActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        } else {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    boolean isConnected = NetworkUtility.checkInternetConnection(SplaceScreen.this);
                    Intent intent = new Intent(SplaceScreen.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }


            }, 3000);

        }
    }

}

