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

public class MyVerticalAdapter extends RecyclerView.Adapter<MyVerticalAdapter.MyViewHolder> {
    Context context;
    ArrayList<MyVerticalModel> myVerticalModel;

    public MyVerticalAdapter(Context context, ArrayList<MyVerticalModel> verticalModel){

        this.context = context;
        this.myVerticalModel = verticalModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.verticalrecycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.VerticalName.setText(myVerticalModel.get(position).getVerticalTitle());
        holder.VerticalDescription.setText(myVerticalModel.get(position).getVerticalDescription());
        holder.imageView.setImageResource(myVerticalModel.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return myVerticalModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView VerticalName, VerticalDescription;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.verticalNewsImage);
            VerticalDescription = itemView.findViewById(R.id.verticalNewsDescription);
            VerticalName = itemView.findViewById(R.id.verticalNewsTitle);
        }
    }
}
