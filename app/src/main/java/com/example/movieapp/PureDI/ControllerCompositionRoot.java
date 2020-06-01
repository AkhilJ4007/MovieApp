package com.example.movieapp.PureDI;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.lifecycle.LifecycleOwner;

import com.example.movieapp.Factories.CallableFactory;
import com.example.movieapp.Factories.TaskFactory;
import com.example.movieapp.Factories.UseCaseFactory;
import com.example.movieapp.Factories.ViewModelFactory;
import com.example.movieapp.Repository.MovieRepo;
import com.example.movieapp.RoomDB.MovieDatabase;
import com.example.movieapp.Threading.MovieExecutors;
import com.example.movieapp.model.MovieService;

public class ControllerCompositionRoot {
    private  Context context;
    private MVCViewFactory mvcViewFactory;
    private CompositionRoot compositionRoot;
    private MovieRepo movieRepo;
    private LifecycleOwner lifecycleOwner;

    public ControllerCompositionRoot(Context context, CompositionRoot compositionRoot, LifecycleOwner lifecycleOwner) {
        this.context = context;
        this.compositionRoot = compositionRoot;
        this.lifecycleOwner = lifecycleOwner;
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
          movieRepo =  new MovieRepo(getExecuters(),getDB(),getTaskFactory(),lifecycleOwner);
        }
        return movieRepo;
    }

    private TaskFactory getTaskFactory() {
        return new TaskFactory();
    }


    private MovieDatabase getDB(){
       return MovieDatabase.getDB(context);
    }

    private MovieExecutors getExecuters() {
        return compositionRoot.getExecuters();
    }



}
