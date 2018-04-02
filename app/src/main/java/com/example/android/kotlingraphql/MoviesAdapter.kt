package com.example.android.kotlingraphql

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import java.util.*

/**
 * Created by idorenyin on 2/2/18.
 */

class MoviesAdapter(private var movieList: List<MovieQuery.AllMovie>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = movieList[position]
        holder.movieTextview.text = current.title()
        Glide.with(holder.itemView).load(current.imageUrl).into(holder.movieImage)

    }

    inner class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {
        var movieTextview: TextView = itemView!!.findViewById(R.id.movie_title)
        var movieImage: ImageView= itemView!!.findViewById(R.id.movie_image)
    }
}