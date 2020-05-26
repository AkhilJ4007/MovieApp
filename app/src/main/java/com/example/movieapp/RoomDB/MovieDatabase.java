package com.example.movieapp.RoomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {MovieItemEntity.class}, version = 2, exportSchema = false)

public abstract class MovieDatabase extends RoomDatabase {

private static String DB_Name = "MovieDB";

private static MovieDatabase movieDatabase;

public static synchronized MovieDatabase getDB(Context context){
    if (movieDatabase==null){
        movieDatabase = Room.databaseBuilder(context,MovieDatabase.class,DB_Name).fallbackToDestructiveMigration().build();
    }
    return movieDatabase;
}

public abstract MovieDAO movieDAO();


}
