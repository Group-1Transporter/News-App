package com.example.newsapp;

import com.example.newsapp.Bean.NewsResult;

import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Service {

    @GET("top-headlines")
    Observable<NewsResult> topHeadLineNews(@HeaderMap Map< String, String > headerMap, @Query("country") String country, @Query("apiKey") String apikey);

    @Headers({"Static-Header: 1 ", "Static-Header: static header"})
    @GET("everything")
    Observable<NewsResult> allNewsList(@Header("Dynamic-Header") String headrer, @Query("q") String q, @Query("apiKey") String apiKey);

    //api for my reference
    //https://newsapi.org/v2/everything?q=bitcoin&apiKey=21eeca3f4cd84a819ea861d45ee36cab
    //"top-headlines?country=us&apiKey=21eeca3f4cd84a819ea861d45ee36cab"
}
