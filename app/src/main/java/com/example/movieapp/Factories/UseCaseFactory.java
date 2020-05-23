package com.example.movieapp.Factories;

import com.example.movieapp.model.MovieService;
import com.example.movieapp.movieList.MovieListUseCase;

public class UseCaseFactory {

    private MovieService movieService;
    private MovieListUseCase movieListUseCase;

    public UseCaseFactory(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieListUseCase getMovieListUseCase(){
        if(movieListUseCase == null) {
            movieListUseCase =  new MovieListUseCase(movieService);
        }
        return  movieListUseCase;
    }

}

