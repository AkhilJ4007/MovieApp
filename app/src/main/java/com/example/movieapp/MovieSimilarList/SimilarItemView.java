package com.example.movieapp.MovieSimilarList;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.movieapp.R;
import com.example.movieapp.views.BaseObservableViewMvc;


public class SimilarItemView extends BaseObservableViewMvc<SimilarItemInter.Listener> implements SimilarItemInter {

    ImageView imageView;

    public SimilarItemView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        setRootView(layoutInflater.inflate(R.layout.similar_movies_item,viewGroup,false));
        imageView = findViewById(R.id.similarImageView);


    }


    @Override
    public void bindData() {
        Log.d("bindData", "in here");

            Glide.with(getRootView()).load("https://image.tmdb.org/t/p/w185/hTBueN0Ru3R7brwtONenDyEMNYe.jpg").transition(DrawableTransitionOptions.withCrossFade()).into(imageView);

    }
}
