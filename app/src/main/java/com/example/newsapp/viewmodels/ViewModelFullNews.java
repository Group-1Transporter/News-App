package com.example.newsapp.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.Bean.ArticlesBean;
import com.example.newsapp.Bean.NewsResult;
import com.example.newsapp.NewsService;
import com.example.newsapp.Service;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.adapter.rxjava3.Result;

public class ViewModelFullNews extends ViewModel {
    //View Model And Live Data Code
    MutableLiveData<List<ArticlesBean>> list;
    final CompositeDisposable disposable = new CompositeDisposable();

    //Rx Java Code
    public MutableLiveData<List<ArticlesBean>> getData(){
        if(list == null){
            list = new MutableLiveData<>();
/*For my understanding
            NewsService.NewsApi newsApi = NewsService.getNewsApi();
            newsApi.allNewsList().enqueue(new Callback<NewsResult>() {
                @Override
                public void onResponse(Call<NewsResult> call, Response<NewsResult> response) {
                    if (response.code() == 200){
                        ArrayList<ArticlesBean> data = response.body().getArticles();
                        list.setValue(data);
                    }
                }

                @Override
                public void onFailure(Call<NewsResult> call, Throwable t) {

                }
            });*/

            //Dynamic Url
            NewsService.getInstance().getFullNews("bitcoin","21eeca3f4cd84a819ea861d45ee36cab")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<NewsResult>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {
                            disposable.add(d);
                        }

                        @Override
                        public void onNext(@NonNull NewsResult newsResult) {
                            ArrayList<ArticlesBean> fullNews = new ArrayList<>();
                            fullNews = newsResult.getArticles();
                            list.setValue(fullNews);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            Log.e("Error in View Model ","=== "+e.toString());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });

        }
        return list;
    }
}
