package com.example.newsapp.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.Bean.ArticlesBean;
import com.example.newsapp.Bean.NewsResult;
import com.example.newsapp.NewsService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelTopNews extends ViewModel {
    //View Model And Live Data Code
    MutableLiveData<List<ArticlesBean>> list;
    final CompositeDisposable disposable = new CompositeDisposable();

   /*For My Understanding
   public ViewModelTopNews() {

       NewsService.NewsApi newsApi = NewsService.getNewsApi();
        newsApi.topHeadLineNews().enqueue(new Callback<NewsResult>() {
            @Override
            public void onResponse(Call<NewsResult> call, Response<NewsResult> response) {
                if(response.code() == 200){
                    if(response.body().getStatus().equals("ok")){
                        ArrayList<ArticlesBean> al = response.body().getArticles();
                        list.setValue(al);
                        Log.e("DAta","data===========   "+response.body().getTotalResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<NewsResult> call, Throwable t) {
                Log.e("DAta","data===========   "+t.toString());
            }
        });

    }
    */

    //Rx Java Code
    public  MutableLiveData<List<ArticlesBean>> getList() {
        if(list == null){
            list = new MutableLiveData<>();
            //Dynamic Url
            NewsService.getInstance().getTopNews("us","21eeca3f4cd84a819ea861d45ee36cab").subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<NewsResult>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {
                            disposable.add(d);
                        }

                        @Override
                        public void onNext(@NonNull NewsResult newsResult) {
                           ArrayList<ArticlesBean> topNewslist = new ArrayList<>();
                           topNewslist = newsResult.getArticles();
                           list.setValue(topNewslist);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            Log.e("Error in Top News","===========>"+e.toString());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
        return list;
    }
}
