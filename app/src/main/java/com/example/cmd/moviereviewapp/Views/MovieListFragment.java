package com.example.cmd.moviereviewapp.Views;

import android.support.v4.app.Fragment;

/**
 * Created by cmd on 17.03.18.
 */

public class MovieListFragment extends Fragment {
    private static final String TAG = "MovieListFragment";

    private static MovieListFragment sMovieListFragment;

    public static MovieListFragment getInstance() {
        if (sMovieListFragment == null) {
            sMovieListFragment = new MovieListFragment();
        }
        return sMovieListFragment;
    }


}
