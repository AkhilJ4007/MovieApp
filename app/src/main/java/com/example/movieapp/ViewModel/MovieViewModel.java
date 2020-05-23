package com.example.movieapp.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.Repository.MovieRepo;
import com.example.movieapp.model.MovieItem;

import java.util.List;

public class MovieViewModel extends ViewModel {

   private MovieRepo movieRepo;

    public MovieViewModel(MovieRepo movieRepo) {
        super();
        this.movieRepo = movieRepo;
    }



    public MutableLiveData<List<MovieItem>> getMovieList(){
       return movieRepo.getMovieLists();
    }



}
