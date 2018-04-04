package com.example.cmd.moviereviewapp.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cmd.moviereviewapp.R;

/**
 * Created by cmd on 1.04.18.
 */

public class SingleViewFragment extends Fragment {
    private static final String TAG = "SingleViewFragment";

    private static SingleViewFragment singleViewFramgnet;

    public static SingleViewFragment getInstance() {
        if (singleViewFramgnet== null) {
            singleViewFramgnet = new SingleViewFragment();
        }
        return singleViewFramgnet;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.single_movie_fragment,container,false);
        return v;
    }
}
