package com.example.newsapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Bean.ArticlesBean;
import com.example.newsapp.databinding.FullNewsLayoutBinding;
import com.example.newsapp.databinding.TestLayoutBinding;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FullNewsAdapter extends RecyclerView.Adapter<FullNewsAdapter.FullNewsHolder> {
    ArrayList<ArticlesBean> al;
    Context context;

    public FullNewsAdapter(ArrayList<ArticlesBean> al, Context context) {
        this.al = al;
        this.context = context;
    }

    @Override
    public FullNewsHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        FullNewsLayoutBinding binding = FullNewsLayoutBinding.inflate(LayoutInflater.from(context));
        return new FullNewsHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FullNewsAdapter.FullNewsHolder holder, int position) {
        ArticlesBean fullNewsBean = al.get(position);
        holder.binding.tvAuthor.setText(fullNewsBean.getAuthor());
        holder.binding.tvDate.setText(fullNewsBean.getPublishedAt());
        holder.binding.tvTitle.setText(fullNewsBean.getTitle());
        holder.binding.tvDescription.setText(fullNewsBean.getDescription());
        Picasso.get().load(fullNewsBean.getUrlToImage()).into(holder.binding.ivImage);
        //Toast.makeText(context, "" + fullNewsBean.getDescription(), Toast.LENGTH_LONG).show();
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class FullNewsHolder extends RecyclerView.ViewHolder {
        FullNewsLayoutBinding binding;

        public FullNewsHolder(FullNewsLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
