package com.example.cmd.moviereviewapp.Interactor;

import com.example.cmd.moviereviewapp.Contractor.IMovieListContarctor;
import com.example.cmd.moviereviewapp.Contractor.InteractorListener;
import com.example.cmd.moviereviewapp.Listener.IOnDataCallback;
import com.example.cmd.moviereviewapp.NetworkInteractor.ServerMovieCall;
import com.example.cmd.moviereviewapp.POJO.Movie.MovieListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmd on 17.03.18.
 */

public class MovieListInteractor implements IMovieListContarctor.MovieListInteractor {
    private InteractorListener mListener;
    private List<MovieListModel> mList;


    public MovieListInteractor(InteractorListener mListener) {
        this.mListener = mListener;
    }

    public int getMovieSize() {
        return mList.size();
    }


    @Override
    public String getMoviePosterPath(int pos) {
        return mList.get(pos).getPosterPath();
    }

    @Override
    public MovieListModel getMovie(int pos) {
        return mList.get(pos);
    }

    @Override
    public List<MovieListModel> getMovieList() {
        if (mList == null) mList = new ArrayList<>();
        ServerMovieCall mCall = new ServerMovieCall();
        mCall.getMovieList(new IOnDataCallback<List<MovieListModel>>() {
            @Override
            public void onSuccess(List<MovieListModel> data) {
                mList.addAll(data);
                mListener.onSuccess(data, "Data passed " + mList.size());
            }

            @Override
            public void onFailure(String message) {
                mListener.onFailure(message);
            }
        });
        return mList;
    }
}
