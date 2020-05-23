package com.example.movieapp.Factories;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.movieapp.Repository.MovieRepo;
import com.example.movieapp.ViewModel.MovieViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

   private MovieRepo movieRepo;

    public ViewModelFactory(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

      if(modelClass == MovieViewModel.class){
          return (T) new MovieViewModel(movieRepo);
      }
      else {
          throw new RuntimeException("View model class not available");
      }
    }
}
