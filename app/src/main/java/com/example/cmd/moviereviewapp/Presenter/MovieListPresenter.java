package com.example.cmd.moviereviewapp.Presenter;

import android.util.Log;

import com.example.cmd.moviereviewapp.Contractor.IMovieListContarctor;
import com.example.cmd.moviereviewapp.Contractor.InteractorListener;
import com.example.cmd.moviereviewapp.Interactor.MovieListInteractor;
import com.example.cmd.moviereviewapp.POJO.Movie.MovieListModel;
import com.example.cmd.moviereviewapp.ViewHolder.MovieListViewHolder;
import com.example.cmd.moviereviewapp.View.MovieListFragment;

import java.util.List;

/**
 * Created by cmd on 17.03.18.
 */

public class MovieListPresenter implements IMovieListContarctor.MovieListPresenter, InteractorListener {
    private static final String TAG = "MovieListPresenter";

    private MovieListFragment mView;
    private MovieListInteractor mInteractor;
    private List<MovieListModel> mList;


    public MovieListPresenter(MovieListFragment mView) {
        this.mView = mView;
        mInteractor = new MovieListInteractor(this);
        getData();

    }

    //TODO: Add functionality so that the view could call mView.refreshAdapterList
    //TODO: And from the view - adapter.notifiyDataSetChange;


    @Override
    public void onSuccess(List<MovieListModel> data, String msg) {
        mList = data;
        mView.onDataChange(data, msg);
    }

    @Override
    public int getMoviePos(int pos) {
        Log.d(TAG, "getMoviePos: " + pos);
        return pos;
    }

    @Override
    public void onFailure(String msg) {
        mView.onDataFailure(msg);
    }


    @Override
    public void bindAtPosition(int position, MovieListViewHolder holder) {
        holder.setValue(mInteractor.getMovie(position));
    }

    @Override
    public void getData() {
        mList = mInteractor.getMovieList();
    }

    @Override
    public String getMoviePosterPath(int pos) {
        return mInteractor.getMoviePosterPath(pos);
    }

    @Override
    public int getSize() {
        return mInteractor.getMovieSize();
    }
}









