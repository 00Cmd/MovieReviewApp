package com.example.cmd.moviereviewapp.Contractors;

import com.example.cmd.moviereviewapp.POJO.Movies.MovieLatest;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieListModel;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieListResponse;

import java.util.List;

/**
 * Created by cmd on 18.03.18.
 */

public interface InteractorListener {
    void onSuccess(List<MovieListModel> data, String msg);
    void onFailure(String msg);

    interface InteractorLayerListener {
        void onSuccess(MovieListModel model, String msg);
        void onFailure(String msg);
    }
}
