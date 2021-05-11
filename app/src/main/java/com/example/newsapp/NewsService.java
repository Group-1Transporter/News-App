package com.example.newsapp;

import com.example.newsapp.Bean.NewsResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class NewsService {
    public static NewsApi newsApi;
    public static NewsApi getNewsApi(){
        String url = " https://newsapi.org/v2/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        if (newsApi==null){
            newsApi = retrofit.create(NewsApi.class);
        }
        return newsApi;

    }
    public interface NewsApi{
        @GET("everything?q=bitcoin&apiKey=21eeca3f4cd84a819ea861d45ee36cab")
        Call<NewsResult>allNewsList();

        @GET("top-headlines?country=us&apiKey=21eeca3f4cd84a819ea861d45ee36cab")
        Call<NewsResult>topHeadLineNews();
    }
}
