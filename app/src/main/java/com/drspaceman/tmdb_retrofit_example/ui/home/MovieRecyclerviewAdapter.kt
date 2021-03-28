package com.drspaceman.tmdb_retrofit_example.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drspaceman.tmdb_retrofit_example.R
import com.drspaceman.tmdb_retrofit_example.data.TmdbMovie

class MovieRecyclerviewAdapter: RecyclerView.Adapter<MovieViewHolder>() {

    var movieList: List<TmdbMovie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_home_movie, parent, false)

        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
//        holder.image.setImageResource(movie.poster_path) // @todo: call API for image, load via Glide
        holder.title.text = movie.title
        holder.year.text = movie.release_date
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val image: ImageView = itemView.findViewById(R.id.imageview_home_movieposter)
    val title: TextView = itemView.findViewById(R.id.textview_home_movietitle)
    val year: TextView = itemView.findViewById(R.id.textview_home_movieyear)
}
