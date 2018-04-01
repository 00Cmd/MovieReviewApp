package com.example.cmd.moviereviewapp.Contractors;

import android.content.Context;

import com.example.cmd.moviereviewapp.ApiCalls.IServerMovieApiHelper;
import com.example.cmd.moviereviewapp.NetworkInteractors.ServerMovieCall;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieLatest;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieListModel;
import com.example.cmd.moviereviewapp.ViewHolders.MovieListViewHolder;

import java.util.List;

import retrofit2.Retrofit;

/**
 * Created by cmd on 17.03.18.
 */

public interface IMovieContarctor {
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
    }

    public interface MovieListView {
        void onDataChange(List<MovieListModel> data,String message);
        void onDataFailure(String message);
    }
}
