package com.example.newsapp.Fragements;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.Adapters.FullNewsAdapter;
import com.example.newsapp.Bean.ArticlesBean;
import com.example.newsapp.Bean.NewsResult;
import com.example.newsapp.NewsService;
import com.example.newsapp.R;

import com.example.newsapp.databinding.FragmentFullNewsBinding;
import com.example.newsapp.databinding.FullNewsLayoutBinding;

import com.example.newsapp.viewmodels.ViewModelFullNews;
import com.example.newsapp.viewmodels.ViewModelTopNews;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FullNewsFragment extends Fragment {
    public static final String TAG = "FullNewsFragment";
FragmentFullNewsBinding binding;
ViewModelFullNews viewModelFullNews;


    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        viewModelFullNews = new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()).create(ViewModelFullNews.class);

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelFullNews.getData().observe(getActivity(), articlesBeans -> {
            FullNewsAdapter adapter = new FullNewsAdapter(articlesBeans,getContext());
            binding.rvFullnews.setAdapter(adapter);
            binding.rvFullnews.setLayoutManager(new LinearLayoutManager(getContext()));
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding = FragmentFullNewsBinding.inflate(LayoutInflater.from(getContext()));
        return binding.getRoot();
    }

}