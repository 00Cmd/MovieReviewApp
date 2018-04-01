package com.example.cmd.moviereviewapp.Interactors;

import android.content.Context;
import android.util.Log;

import com.example.cmd.moviereviewapp.ApiCalls.IServerMovieApiHelper;
import com.example.cmd.moviereviewapp.Contractors.IMovieContarctor;
import com.example.cmd.moviereviewapp.Contractors.InteractorListener;
import com.example.cmd.moviereviewapp.Listeners.IOnDataCallback;
import com.example.cmd.moviereviewapp.NetworkInteractors.ServerMovieCall;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieLatest;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieListModel;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieListResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;

/**
 * Created by cmd on 17.03.18.
 */

public class MovieListInteractor implements IMovieContarctor.MovieListInteractor {
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
            }

            @Override
            public void onFailure(String message) {
                Log.d(TAG, "onFailure: " + message);
            }
        });
        return mList;
    }
}
