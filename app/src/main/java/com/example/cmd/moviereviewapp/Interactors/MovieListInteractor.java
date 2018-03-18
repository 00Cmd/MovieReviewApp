package com.example.cmd.moviereviewapp.Interactors;

import com.example.cmd.moviereviewapp.Contractors.IMovieContarctor;
import com.example.cmd.moviereviewapp.Contractors.InteractorListener;
import com.example.cmd.moviereviewapp.Listeners.IOnDataCallback;
import com.example.cmd.moviereviewapp.NetworkInteractors.ServerMovieCall;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieLatest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmd on 17.03.18.
 */

public class MovieListInteractor implements IMovieContarctor.MovieListInteractor {
    private InteractorListener<MovieLatest> mListener;
    private List<MovieLatest> mList;

    public MovieListInteractor(InteractorListener<MovieLatest> mListener) {
        this.mListener = mListener;
    }


    @Override
    public void getPopularMovies() {
        if (mList == null) {
            mList = new ArrayList<>();
        } else {
            mList.clear();
        }
        ServerMovieCall.getInstance().getLatestMovies(new IOnDataCallback<MovieLatest>() {
            @Override
            public void onSuccess(MovieLatest data) {
                mList.add(data);
                mListener.onSuccess(mList,"Data successfully parsed");
            }

            @Override
            public void onFailure(String message) {
                mListener.onFailure(message);
            }
        });
    }
}
