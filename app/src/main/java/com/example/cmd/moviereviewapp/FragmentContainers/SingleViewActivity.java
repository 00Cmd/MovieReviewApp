package com.example.cmd.moviereviewapp.FragmentContainers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.cmd.moviereviewapp.Contractors.IFragmentInitiator;
import com.example.cmd.moviereviewapp.R;

/**
 * Created by cmd on 1.04.18.
 */

public class SingleViewActivity extends AppCompatActivity implements IFragmentInitiator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_view_activity);
//        initFragment();
    }

    @Override
    public void initFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainer,fragment,fragment.getTag()).commit();
    }
}
