package com.example.android.kotlingraphql

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import kotlinx.android.synthetic.main.activity_movies_list.*
import okhttp3.OkHttpClient

class MoviesListActivity : AppCompatActivity(), MoviesListAdapter.MovieOnClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)


        // Initialize apolloclient with our server url
        val apolloClient = ApolloClient.builder()
                .serverUrl("https://api.graph.cool/simple/v1/cjcujyx5f07p801916rjjigz7")
                .okHttpClient(OkHttpClient.Builder().build()).build()

        // query our server for response
        apolloClient.query(MovieQuery.builder().build())
                .enqueue(object : ApolloCall.Callback<MovieQuery.Data>() {

            override fun onResponse(response: Response<MovieQuery.Data>) {
                Log.d("TAG", response.errors().toString())
                runOnUiThread {
                    setupRecyclerView(response.data()!!.allMovies())
                }
            }

            override fun onFailure(e: ApolloException) {
                Log.d("TAG", e.message)
            }

        })

    }

    override fun movieOnClick(movie: MovieQuery.AllMovie) {
        val intent = Intent(this,MovieDetailsActivity::class.java)
                .putExtra("movie_id",movie.id)
                .putExtra("movie_title",movie.title)
                .putExtra("movie_overview",movie.overview)

        startActivity(intent)
    }

    private fun setupRecyclerView(list: List<MovieQuery.AllMovie>) {
        val adapter = MoviesListAdapter(list,this)
        recyclerView.layoutManager= GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
    }


}
