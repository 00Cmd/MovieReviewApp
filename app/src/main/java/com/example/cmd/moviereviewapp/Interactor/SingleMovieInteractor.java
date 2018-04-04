package com.example.cmd.moviereviewapp.Interactor;

import com.example.cmd.moviereviewapp.Contractor.ISingleMovieContract;
import com.example.cmd.moviereviewapp.Contractor.InteractorListener;
import com.example.cmd.moviereviewapp.POJO.Event.MessageEvent;
import com.example.cmd.moviereviewapp.POJO.Movie.MovieListModel;
import com.example.cmd.moviereviewapp.Presenter.SingleMoviePresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by cmd on 1.04.18.
 */

public class SingleMovieInteractor implements ISingleMovieContract.SingleMovieInteractor {

    private InteractorListener.SingleMovieInteractorListener mListener;

    public SingleMovieInteractor(InteractorListener.SingleMovieInteractorListener mListener) {
        this.mListener = mListener;
        EventBus.getDefault().register(SingleMovieInteractor.class);
    }


    @Subscribe
    @Override
    public MovieListModel getDataFromOtherLayer(MessageEvent event) {
        return event.getModel();
    }


}
