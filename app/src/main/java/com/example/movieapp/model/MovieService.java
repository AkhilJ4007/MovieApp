package com.example.movieapp.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET("3/trending/movie/day")
    Call<MovieResponseSchema> listMovies(@Query("api_key") String apiKey);


}
