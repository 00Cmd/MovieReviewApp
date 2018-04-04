package com.example.cmd.moviereviewapp.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cmd.moviereviewapp.Adapter.MovieListAdapter;
import com.example.cmd.moviereviewapp.Contractor.IMovieListContarctor;
import com.example.cmd.moviereviewapp.POJO.Movie.MovieListModel;
import com.example.cmd.moviereviewapp.Presenter.MovieListPresenter;
import com.example.cmd.moviereviewapp.R;

import java.util.List;

/**
 * Created by cmd on 17.03.18.
 */

public class MovieListFragment extends Fragment implements IMovieListContarctor.MovieListView {
    private static final String TAG = "MovieListFragment";
    private MovieListPresenter mPresenter;
    private MovieListAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private TextView mTest;


    private static MovieListFragment sMovieListFragment;

    public static MovieListFragment getInstance() {
        if (sMovieListFragment == null) {
            sMovieListFragment = new MovieListFragment();
        }
        return sMovieListFragment;
    }

    public MovieListFragment() {
        mPresenter = new MovieListPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.movie_list_fragment,container,false);
        mRecyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new MovieListAdapter(mPresenter,getActivity());
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

    //TODO: Add functionality - adapter.notifiyDataSetChange;
    /**
        Guess who LIKES TO OVERTHINK???? Give this hosting activity a 2nd fragment to host and see
        how that will work and ofc google before you start trying it out, if it does go as planned
        resume testing out EventBus :)
     */



    @Override
    public void onDataChange(List<MovieListModel> data, String message) {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDataFailure(String message) {

    }
}
