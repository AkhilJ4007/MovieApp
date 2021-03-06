package com.example.movieapp.RoomDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movieItem")
public class MovieItemEntity {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "releaseDate")
    private String releaseDate;
    @ColumnInfo(name = "overview")
    private String overview;
    @ColumnInfo(name = "backdrop_path")
    private String backdrop_path;

    public MovieItemEntity(Integer id, String title, String releaseDate, String overview, String backdrop_path) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.backdrop_path = backdrop_path;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }
}
