package com.example.mynewsapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopNewsAdapter extends RecyclerView.Adapter<TopNewsAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyNewsModel> newsModels;
    public TopNewsAdapter(Context context, ArrayList<MyNewsModel> newsModels){

        this.context = context;
        this.newsModels = newsModels;
    }

    @NonNull
    @Override
    public TopNewsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from((context));
        View view = inflater.inflate(R.layout.top_stories, parent, false);
        return new TopNewsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopNewsAdapter.MyViewHolder holder, int position) {

        holder.imageView.setImageResource(newsModels.get(position).getImage());
        holder.textView.setText(newsModels.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView4);
            textView = itemView.findViewById(R.id.topTextView);

        }
    }
}
