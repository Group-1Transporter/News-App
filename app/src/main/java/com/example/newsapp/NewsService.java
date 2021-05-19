package com.example.newsapp;

import com.example.newsapp.Bean.NewsResult;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.GET;

public class NewsService {
    String url = "https://newsapi.org/v2/";
    public static Service service;
    private static NewsService newsApi;
    private NewsService(){

        //Code For Headers
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        //Network Call
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        service = retrofit.create(Service.class);
    }
    public static NewsService getInstance(){
        //singalton Class
        if (newsApi == null){
            newsApi = new NewsService();
        }
        return newsApi;
    }

    public Observable<NewsResult> getFullNews(String q ,String apiKey){
        //Dynamic Header
        return service.allNewsList("Here I can Pass Dynamic Hader",q,apiKey);
    }

    public Observable<NewsResult> getTopNews(String country,String apiKey){
        //HeaderMap data
        Map<String,String> headers = new HashMap<>();
        headers.put("Header1","111");
        headers.put("Header","hhhe");
        return service.topHeadLineNews(headers,country, apiKey);
    }

}
