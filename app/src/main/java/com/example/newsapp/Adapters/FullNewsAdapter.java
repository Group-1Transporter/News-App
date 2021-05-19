package com.example.newsapp.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideContext;
import com.example.newsapp.Bean.ArticlesBean;
import com.example.newsapp.databinding.FullNewsLayoutBinding;
import com.example.newsapp.databinding.TestLayoutBinding;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FullNewsAdapter extends RecyclerView.Adapter<FullNewsAdapter.FullNewsHolder> {
    List<ArticlesBean> fullNewsList;
    Context context;

    public FullNewsAdapter(List<ArticlesBean> fullNewsList, Context context) {
        this.fullNewsList = fullNewsList;
        this.context = context;
    }

    @Override
    public FullNewsHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        FullNewsLayoutBinding binding = FullNewsLayoutBinding.inflate(LayoutInflater.from(context));
        return new FullNewsHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FullNewsAdapter.FullNewsHolder holder, int position) {
        ArticlesBean fullNewsBean = fullNewsList.get(position);
        holder.binding.tvAuthor.setText(fullNewsBean.getAuthor());
        holder.binding.tvDate.setText(fullNewsBean.getPublishedAt());
        holder.binding.tvTitle.setText(fullNewsBean.getTitle());
        holder.binding.tvDescription.setText(fullNewsBean.getDescription());
        Log.e("Image Url ", "==>>   "+fullNewsBean.getUrlToImage());
        Picasso.get().load(fullNewsBean.getUrlToImage()).into(holder.binding.ivImage);
        //Toast.makeText(context, "" + fullNewsBean.getDescription(), Toast.LENGTH_LONG).show();
        holder.binding.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullNewsList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return fullNewsList.size();
    }

    public class FullNewsHolder extends RecyclerView.ViewHolder {
        FullNewsLayoutBinding binding;

        public FullNewsHolder(FullNewsLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
