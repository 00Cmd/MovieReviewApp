package com.example.cmd.moviereviewapp.Contractor;

import com.example.cmd.moviereviewapp.POJO.Movie.MovieListModel;

import java.util.List;

/**
 * Created by cmd on 18.03.18.
 */

public interface InteractorListener {
    void onSuccess(List<MovieListModel> data, String msg);
    void onFailure(String msg);

    interface SingleMovieInteractorListener {
        void onSuccess(MovieListModel model, String msg);
        void onFailure(String msg);
    }
}
