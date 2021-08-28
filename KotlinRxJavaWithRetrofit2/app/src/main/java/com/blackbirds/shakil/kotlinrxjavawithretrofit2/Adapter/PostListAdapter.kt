package com.blackbirds.shakil.kotlinrxjavawithretrofit2.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blackbirds.shakil.kotlinrxjavawithretrofit2.Model.PostModel
import com.blackbirds.shakil.kotlinrxjavawithretrofit2.R
import java.lang.String
import java.lang.StringBuilder

class PostListAdapter(var context: Context, postModelList: List<PostModel>) :
    RecyclerView.Adapter<PostListAdapter.MyViewHolder?>() {
    var postModelList: List<PostModel>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.layout_post_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtTitle.setText(String.valueOf(postModelList[position].title))
        holder.txtContent.setText(
            StringBuilder(postModelList[position].body!!.substring(0, 20))
                .append("...").toString()
        )
        holder.txtAuthor.setText(String.valueOf(postModelList[position].userId))
    }

    override fun getItemCount(): Int {
        return postModelList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView
        var txtContent: TextView
        var txtAuthor: TextView

        init {
            txtTitle = itemView.findViewById(R.id.txtTitle)
            txtContent = itemView.findViewById(R.id.txtContent)
            txtAuthor = itemView.findViewById(R.id.txtAuthor)
        }
    }

    init {
        this.postModelList = postModelList
    }
}