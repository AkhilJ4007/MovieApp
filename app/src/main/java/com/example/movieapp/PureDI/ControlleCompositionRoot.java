package com.example.movieapp.PureDI;

import android.content.Context;
import android.view.LayoutInflater;

import com.example.movieapp.Factories.CallableFactory;
import com.example.movieapp.Factories.UseCaseFactory;
import com.example.movieapp.Factories.ViewModelFactory;
import com.example.movieapp.Repository.MovieRepo;
import com.example.movieapp.Threading.MovieExecutors;
import com.example.movieapp.model.MovieService;

public class ControlleCompositionRoot {
    private  Context context;
    private MVCViewFactory mvcViewFactory;
    private CompositionRoot compositionRoot;
    private MovieRepo movieRepo;

    public ControlleCompositionRoot(Context context,CompositionRoot compositionRoot) {
        this.context = context;
        this.compositionRoot = compositionRoot;
    }


    private LayoutInflater getLayoutInflator(){
        return LayoutInflater.from(context);
    }

    public MVCViewFactory getMVCViewFactory(){
        if(mvcViewFactory == null){
            mvcViewFactory = new MVCViewFactory(getLayoutInflator());
        }
        return mvcViewFactory;
    }


    public MovieService getMovieService(){
        return compositionRoot.getMovieService();
    }


    public ViewModelFactory getViewModelFactory(){
        return new ViewModelFactory(getRepo());
    }

    private MovieRepo getRepo() {
        if (movieRepo == null) {
          movieRepo =  new MovieRepo(getExecuters());
        }
        return movieRepo;
    }

    private MovieExecutors getExecuters() {
        return compositionRoot.getExecuters();
    }

}
