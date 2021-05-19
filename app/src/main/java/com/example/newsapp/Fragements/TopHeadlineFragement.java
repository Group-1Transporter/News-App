package com.example.newsapp.Fragements;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.Adapters.TopHeadlineAdapter;
import com.example.newsapp.Bean.ArticlesBean;
import com.example.newsapp.Bean.NewsResult;
import com.example.newsapp.NewsService;
import com.example.newsapp.databinding.FragmentTopHeadingBinding;
import com.example.newsapp.viewmodels.ViewModelTopNews;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TopHeadlineFragement extends Fragment {
    public static final String TAG = "TopHeadlineFragement";
    FragmentTopHeadingBinding binding;
    ViewModelTopNews viewModelTopNews;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        viewModelTopNews = new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()).create(ViewModelTopNews.class);
        Log.e("Object ","++++++++++++"+viewModelTopNews);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTopHeadingBinding.inflate(LayoutInflater.from(getContext()));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelTopNews.getList().observe(getActivity(), new Observer<List<ArticlesBean>>() {
            @Override
            public void onChanged(List<ArticlesBean> articlesBeans) {
                TopHeadlineAdapter adapter = new TopHeadlineAdapter(articlesBeans, getContext());
                binding.rvTopNews.setAdapter(adapter);
                binding.rvTopNews.setLayoutManager(new LinearLayoutManager(getContext()));

            }
        });

    }

}