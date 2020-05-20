package com.example.movieapp.PureDI;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import com.example.movieapp.model.MovieService;

public class ControlleCompositionRoot {
    private  Context context;
    private MVCViewFactory mvcViewFactory;
    private CompositionRoot compositionRoot;

    public ControlleCompositionRoot(Context context,CompositionRoot compositionRoot) {
        this.context = context;
        this.compositionRoot = compositionRoot;
    }


    public LayoutInflater getLayoutInflator(){
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


    public RunnableFactory getRunnableFactory(){
        return compositionRoot.getRunnableFactory();
    }

}
