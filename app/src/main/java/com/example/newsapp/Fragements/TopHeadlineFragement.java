package com.example.newsapp.Fragements;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.Adapters.TopHeadlineAdapter;
import com.example.newsapp.Bean.ArticlesBean;
import com.example.newsapp.Bean.NewsResult;
import com.example.newsapp.NewsService;
import com.example.newsapp.databinding.FragmentTopHeadingBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TopHeadlineFragement extends Fragment {
    FragmentTopHeadingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTopHeadingBinding.inflate(LayoutInflater.from(getContext()));
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        NewsService.NewsApi news = NewsService.getNewsApi();
        news.topHeadLineNews().enqueue(new Callback<NewsResult>() {
            @Override
            public void onResponse(Call<NewsResult> call, Response<NewsResult> response) {
                if (response.code() == 200) {
                    NewsResult result = response.body();
                    ArrayList<ArticlesBean> arrayList = result.getArticles();
                    TopHeadlineAdapter adapter = new TopHeadlineAdapter(arrayList, getContext());
                    binding.rvTopNews.setAdapter(adapter);
                    binding.rvTopNews.setLayoutManager(new LinearLayoutManager(getContext()));
                }
            }

            @Override
            public void onFailure(Call<NewsResult> call, Throwable t) {

            }
        });
    }
}