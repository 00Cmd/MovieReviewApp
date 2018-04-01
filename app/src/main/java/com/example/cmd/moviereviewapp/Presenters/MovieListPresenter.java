package com.example.cmd.moviereviewapp.Presenters;

import com.example.cmd.moviereviewapp.Contractors.IMovieContarctor;
import com.example.cmd.moviereviewapp.Contractors.InteractorListener;
import com.example.cmd.moviereviewapp.Interactors.MovieListInteractor;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieListModel;
import com.example.cmd.moviereviewapp.ViewHolders.MovieListViewHolder;
import com.example.cmd.moviereviewapp.Views.MovieListFragment;

import java.util.List;

/**
 * Created by cmd on 17.03.18.
 */

public class MovieListPresenter implements IMovieContarctor.MovieListPresenter, InteractorListener {

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
        mView.onDataChange(data, msg);
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









