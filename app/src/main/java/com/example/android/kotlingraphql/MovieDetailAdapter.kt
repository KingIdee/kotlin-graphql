package com.example.android.kotlingraphql

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class MovieDetailAdapter(/*private var movieList: List<ReviewQuery.AllReview>*/) : RecyclerView.Adapter<MovieDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_item_movie_details,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.bindView(movieList[position])
    }

    inner class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {

        //var movieTextview: TextView = itemView!!.findViewById(R.id.movie_title)
        //var movieImage: ImageView = itemView!!.findViewById(R.id.movie_image)
        /*fun bindView(currentMovie: ReviewQuery.AllReview) = with(itemView){
            *//*Glide.with(this).load(currentMovie.imageUrl).into(movieImage)
            movieTextview.text = currentMovie.title*//*
        }*/
    }
}