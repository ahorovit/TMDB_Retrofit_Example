package com.drspaceman.tmdb_retrofit_example.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drspaceman.tmdb_retrofit_example.data.TmdbMovie
import com.drspaceman.tmdb_retrofit_example.service.ApiFactory
import com.drspaceman.tmdb_retrofit_example.service.MovieRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository: MovieRepository = MovieRepository(ApiFactory.tmdbApi)

    private val _popularMovies = MutableLiveData<List<TmdbMovie>>()

    val popularMovies: LiveData<List<TmdbMovie>>
        get() = _popularMovies

    private val _selectedMovie = MutableLiveData<TmdbMovie>()

    val selectedMovie: LiveData<TmdbMovie>
        get() = _selectedMovie

    fun fetchMovies() = viewModelScope.launch {
        _popularMovies.postValue(repository.getPopularMovies())
    }

    fun fetchMovie(movieId: Int) = viewModelScope.launch {
        _selectedMovie.postValue(repository.getSelectedMovie(movieId))
    }
}