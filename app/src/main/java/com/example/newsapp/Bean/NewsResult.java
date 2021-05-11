package com.example.newsapp.Bean;

import java.util.ArrayList;

public class NewsResult {
    private String status;
    private Long totalResults;
    private ArrayList<ArticlesBean> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<ArticlesBean> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ArticlesBean> articles) {
        this.articles = articles;
    }
}
