package com.example.cmd.moviereviewapp.FragmentContainer;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cmd.moviereviewapp.Contractor.IFragmentInitiator;
import com.example.cmd.moviereviewapp.R;
import com.example.cmd.moviereviewapp.View.MovieListFragment;

public class MainActivity extends AppCompatActivity implements IFragmentInitiator {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment(MovieListFragment.getInstance());
    }

    @Override
    public void initFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer,fragment,fragment.getTag()).commit();
    }
}
