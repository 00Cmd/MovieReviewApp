package com.example.cmd.moviereviewapp.FragmentContainers;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.cmd.moviereviewapp.Contractors.IFragmentInitiator;
import com.example.cmd.moviereviewapp.Listeners.IOnDataCallback;
import com.example.cmd.moviereviewapp.NetworkInteractors.ServerMovieCall;
import com.example.cmd.moviereviewapp.POJO.Movies.Movie;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieListModel;
import com.example.cmd.moviereviewapp.R;
import com.example.cmd.moviereviewapp.Views.MovieListFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IFragmentInitiator {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        * Movie this inside a InteractorListener and listen for calls.
         */

        initFragment(MovieListFragment.getInstance());
    }

    @Override
    public void initFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer,fragment,fragment.getTag()).commit();
    }
}
