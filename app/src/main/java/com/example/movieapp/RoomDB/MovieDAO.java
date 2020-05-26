package com.example.movieapp.RoomDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MovieDAO {

    @Query("SELECT * FROM movieItem")
    List<MovieItem> getMoviesList();

    @Query("DELETE FROM movieItem")
    void deleteAll();

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertAllMovies(MovieItemEntity... items);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(MovieItemEntity movieItemEntity);

}
