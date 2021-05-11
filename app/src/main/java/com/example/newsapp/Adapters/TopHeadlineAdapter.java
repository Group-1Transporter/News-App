package com.example.newsapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Bean.ArticlesBean;
import com.example.newsapp.databinding.TopNewsLayoutBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TopHeadlineAdapter extends RecyclerView.Adapter<TopHeadlineAdapter.TopHeadlineViewHolder>  {
   ArrayList<ArticlesBean>al;
   Context context;

    public TopHeadlineAdapter(ArrayList<ArticlesBean> al, Context context) {
        this.al = al;
        this.context = context;
    }

    @Override
    public TopHeadlineViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        TopNewsLayoutBinding binding = TopNewsLayoutBinding.inflate(LayoutInflater.from(context));
        return new TopHeadlineViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TopHeadlineAdapter.TopHeadlineViewHolder holder, int position) {
        ArticlesBean topHeadlineBean = al.get(position);
        holder.binding.tvAuthor.setText(topHeadlineBean.getAuthor());
        holder.binding.tvTitle.setText(topHeadlineBean.getTitle());
        holder.binding.tvPublishDate.setText(topHeadlineBean.getPublishedAt());
        holder.binding.tvDescription.setText(topHeadlineBean.getDescription());
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class TopHeadlineViewHolder extends RecyclerView.ViewHolder {
        TopNewsLayoutBinding binding;
        public TopHeadlineViewHolder(TopNewsLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
