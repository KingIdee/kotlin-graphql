package com.example.android.kotlingraphql

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

/**
 * Created by idorenyin on 2/2/18.
 */

class MoviesListAdapter(private var movieList: List<MovieQuery.AllMovie>, private var myClickInterface:MovieOnClick ) : RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {

    var clickInterface:MovieOnClick = myClickInterface

    interface MovieOnClick{
        fun movieOnClick(movie:MovieQuery.AllMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_item_movie_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(movieList[position])
    }

    inner class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView) {

        var movieTextview: TextView = itemView!!.findViewById(R.id.movie_title)
        var movieImage: ImageView= itemView!!.findViewById(R.id.movie_image)
        fun bindView(currentMovie: MovieQuery.AllMovie) = with(itemView){
            itemView.setOnClickListener {
                clickInterface.movieOnClick(currentMovie)
            }
            Glide.with(this).load(currentMovie.imageUrl).into(movieImage)
            movieTextview.text = currentMovie.title
        }
    }
}