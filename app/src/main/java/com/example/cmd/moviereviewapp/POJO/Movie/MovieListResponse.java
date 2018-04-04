package com.example.cmd.moviereviewapp.POJO.Movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cmd on 17.03.18.
 */

public class MovieListResponse {
    @SerializedName("results")
    private List<MovieListModel> movies;

    public List<MovieListModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieListModel> movies) {
        this.movies = movies;
    }
}
