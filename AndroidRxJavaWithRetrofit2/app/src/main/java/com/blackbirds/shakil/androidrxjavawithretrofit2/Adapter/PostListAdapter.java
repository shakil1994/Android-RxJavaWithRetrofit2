package com.blackbirds.shakil.androidrxjavawithretrofit2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blackbirds.shakil.androidrxjavawithretrofit2.Model.PostModel;
import com.blackbirds.shakil.androidrxjavawithretrofit2.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.MyViewHolder> {

    Context context;
    List<PostModel> postModelList;

    public PostListAdapter(Context context, List<PostModel> postModelList) {
        this.context = context;
        this.postModelList = postModelList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.txtTitle.setText(String.valueOf(postModelList.get(position).getTitle()));
        holder.txtContent.setText(new StringBuilder(postModelList.get(position).getBody().substring(0, 20))
        .append("...").toString());
        holder.txtAuthor.setText(String.valueOf(postModelList.get(position).getUserId()));
    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtContent, txtAuthor;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtContent = itemView.findViewById(R.id.txtContent);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
        }
    }
}
