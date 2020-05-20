package com.example.movieapp.PureDI;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.movieapp.R;
import com.example.movieapp.movieList.MovieItemViewMVC;
import com.example.movieapp.movieList.MovieListMVC;
import com.example.movieapp.movieList.MovieListMVCInterface;

public class MVCViewFactory {
    LayoutInflater layoutInflater;

    public MVCViewFactory(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public MovieListMVCInterface getMovieListMVC(ViewGroup viewGroup){
        return new MovieListMVC(layoutInflater,viewGroup,this);
    }

    public MovieItemViewMVC getMovieListItemView(ViewGroup viewGroup){
        return new MovieItemViewMVC(viewGroup,layoutInflater);
    }




}
