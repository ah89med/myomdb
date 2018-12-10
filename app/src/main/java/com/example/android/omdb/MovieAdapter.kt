package com.example.android.omdb

import android.content.Intent
import android.graphics.Movie
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    val moviesList: List<MoviesClass>

    constructor(cityList: List<MoviesClass>) {
        this.moviesList = cityList

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {

        holder.setMovie(moviesList[position])
    }

    inner class MovieViewHolder : RecyclerView.ViewHolder {
        val view: View


        constructor(view: View) : super(view) {

            this.view = view
            this.view.setOnClickListener {
                val movie = moviesList[layoutPosition]
                val url = movie.url

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                it.context.startActivity(intent)
            }

        }

        fun setMovie(movie: MoviesClass) {
            view.searchEditText.text = movie.title
            view.ddd.text = movie.type
              Picasso.get().load(movie.imageURL).into(view.animeImageView)
        }
    }


}





