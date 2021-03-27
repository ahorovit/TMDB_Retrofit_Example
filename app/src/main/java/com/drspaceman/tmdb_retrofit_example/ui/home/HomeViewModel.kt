package com.drspaceman.tmdb_retrofit_example.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drspaceman.tmdb_retrofit_example.data.TmdbMovie
import com.drspaceman.tmdb_retrofit_example.service.ApiFactory
import com.drspaceman.tmdb_retrofit_example.service.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeViewModel : ViewModel() {

//    private val parentJob = Job()

//    private val coroutineContext: CoroutineContext
//        get() = parentJob + Dispatchers.Default
//
//    private val scope = CoroutineScope(coroutineContext)

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

    // @Todo remove
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    val text: LiveData<String> = _text






}