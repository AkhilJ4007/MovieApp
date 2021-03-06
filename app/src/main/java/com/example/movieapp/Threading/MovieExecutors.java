package com.example.movieapp.Threading;

import android.util.Log;

import com.example.movieapp.Callables.MovieListCallable;
import com.example.movieapp.Factories.CallableFactory;
import com.example.movieapp.Factories.UseCaseFactory;
import com.example.movieapp.RoomDB.MovieItem;
import com.example.movieapp.RoomDB.MovieItemEntity;
import com.example.movieapp.model.MovieItemSchema;
import com.example.movieapp.movieList.MovieListUseCase;
import com.example.movieapp.movieList.MovieListUseCaseInter;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MovieExecutors implements MovieListUseCaseInter.Listener {

    public interface Listener{
        void movieListSuccess(List<MovieItemEntity> movieItems);
    }

    private ExecutorService executor = Executors.newFixedThreadPool(5);
    private UseCaseFactory useCaseFactory;
    private Listener listener;
    private CallableFactory callableFactory;
    private MovieListUseCase movieListUseCase;

    public MovieExecutors(CallableFactory callableFactory, UseCaseFactory useCaseFactory) {
        this.useCaseFactory = useCaseFactory;
        this.callableFactory = callableFactory;
        movieListUseCase = useCaseFactory.getMovieListUseCase();
        movieListUseCase.registerListener(this);
    }

    public void registerListener(Listener listener){
        this.listener = listener;
    }

    public void getMovies(){
        movieListUseCase.getMovieList();
    }


// from use case
    @Override
    public void moviesSuccess(List<MovieItemSchema> movieItems) {
        Log.d("in movieSuccess",movieItems.get(0).getId().toString());
         MovieListCallable movieListCallable = callableFactory.getListCallable(movieItems);
        Future<List<MovieItemEntity>> future = executor.submit(movieListCallable);

            try {
                listener.movieListSuccess(future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    // from repo
}
