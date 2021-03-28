package com.drspaceman.tmdb_retrofit_example.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drspaceman.tmdb_retrofit_example.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var popularRecyclerView: RecyclerView
    private lateinit var popularAdapter: MovieRecyclerviewAdapter


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        preparePopularMoviesRecyclerView(root)

        homeViewModel.fetchMovies()

        homeViewModel.popularMovies.observe(viewLifecycleOwner, Observer {
            popularAdapter.movieList = it
            popularAdapter.notifyDataSetChanged()
        })

        return root
    }

    private fun preparePopularMoviesRecyclerView(root: View) {
        popularAdapter = MovieRecyclerviewAdapter()
        popularRecyclerView = root.findViewById(R.id.recyclerview_home_popularmovies)
        popularRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        popularRecyclerView.itemAnimator = DefaultItemAnimator()
        popularRecyclerView.adapter = popularAdapter
    }
}