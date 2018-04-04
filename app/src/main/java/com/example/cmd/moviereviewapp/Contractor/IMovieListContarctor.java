package com.example.cmd.moviereviewapp.Contractor;

import com.example.cmd.moviereviewapp.POJO.Movie.MovieListModel;
import com.example.cmd.moviereviewapp.ViewHolder.MovieListViewHolder;

import java.util.List;

/**
 * Created by cmd on 17.03.18.
 */

public interface IMovieListContarctor {
    public interface MovieListInteractor {
        List<MovieListModel> getMovieList();
        MovieListModel getMovie(int pos);
        String getMoviePosterPath(int pos);
    }

    public interface MovieListPresenter {
        void bindAtPosition(int position, MovieListViewHolder holder);
        String getMoviePosterPath(int pos);
        int getSize();
        void getData();
        int getMoviePos(int pos);
    }

    public interface MovieListView {
        void onDataChange(List<MovieListModel> data,String message);
        void onDataFailure(String message);
    }
}
