package com.example.android.kotlingraphql

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class MovieDetailAdapter(private var reviewList: List<ReviewQuery.Review>) : RecyclerView.Adapter<MovieDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_item_movie_details,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(reviewList[position])
    }

    inner class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {

        var reviewContent: TextView = itemView!!.findViewById(R.id.review_content)
        fun bindView(currentReview: ReviewQuery.Review) = with(itemView){
            reviewContent.text = currentReview.content
        }
    }
}