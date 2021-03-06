package com.example.movieapp.PureDI;

import com.example.movieapp.Factories.CallableFactory;
import com.example.movieapp.Factories.UseCaseFactory;
import com.example.movieapp.Threading.MovieExecutors;
import com.example.movieapp.model.MovieService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {

    private Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public MovieService getMovieService(){
       return getRetrofit().create(MovieService.class);
    }


    public MovieExecutors getExecuters() {
        return new MovieExecutors(getCallableFactory(),getUseCaseFactory());
    }

    private UseCaseFactory getUseCaseFactory() {
        return new UseCaseFactory(getMovieService());
    }

    private CallableFactory getCallableFactory() {
        return new CallableFactory();
    }


}
