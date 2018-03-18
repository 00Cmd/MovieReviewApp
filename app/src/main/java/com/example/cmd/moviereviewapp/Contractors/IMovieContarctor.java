package com.example.cmd.moviereviewapp.Contractors;

import com.example.cmd.moviereviewapp.POJO.Movies.Movie;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieLatest;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieListModel;

import java.util.List;

/**
 * Created by cmd on 17.03.18.
 */

public interface IMovieContarctor {
    public interface MovieListInteractor {
        void getPopularMovies();
    }

    public interface MovieListPresenter {
        void onDataSuccess(List<MovieListModel> data, String message);
        void onDataFailed(String message);
    }
}
