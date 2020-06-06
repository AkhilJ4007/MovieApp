package com.example.movieapp.MovieDetails;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.target.Target;
import com.example.horizontalrecyclerview.MovieReviewListPkg.MovieReviewsAdapter;
import com.example.horizontalrecyclerview.MovieSimilarList.SimilarMoviesAdapter;
import com.example.horizontalrecyclerview.views.BaseObservableViewMvc;


public class MovieDetailsMVC extends BaseObservableViewMvc<MovieDetailsMVCInter.Listener> implements MovieDetailsMVCInter,MovieReviewsAdapter.Listener,SimilarMoviesAdapter.Listener {
    private ImageView movieImage;
    private TextView movieTitle;
    private TextView overviewText;
    private RecyclerView movieReviewsList;
    private RecyclerView similarMoviesList;
    public MovieDetailsMVC(LayoutInflater inflater, ViewGroup parent) {

        setRootView(inflater.inflate(R.layout.movie_details_layout,parent,false));
        movieImage = findViewById(R.id.detailImageView);
        movieTitle = findViewById(R.id.detailMovieTitle);
        overviewText = findViewById(R.id.overviewText);
        movieReviewsList = findViewById(R.id.ReviewList);
        similarMoviesList = findViewById(R.id.similarMoviesList);
        MovieReviewsAdapter movieReviewsAdapter = new MovieReviewsAdapter(this,inflater);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        movieReviewsList.setAdapter(movieReviewsAdapter);
        movieReviewsList.setLayoutManager(layoutManager);
        SimilarMoviesAdapter similarMoviesAdapter = new SimilarMoviesAdapter(this,inflater);
        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        similarMoviesList.setAdapter(similarMoviesAdapter);
        similarMoviesList.setLayoutManager(layoutManager2);

        Glide.with(getRootView()).load("https://image.tmdb.org/t/p/w780/5BwqwxMEjeFtdknRV792Svo0K1v.jpg").override(Target.SIZE_ORIGINAL).fitCenter().transition(DrawableTransitionOptions.withCrossFade()).into(movieImage);




    }






    // from activity
    @Override
    public void bindData() {

    }
    // reviews click
    @Override
    public void OnClick() {

    }

// similar clik
    @Override
    public void OnClickSimilar() {

    }
}


