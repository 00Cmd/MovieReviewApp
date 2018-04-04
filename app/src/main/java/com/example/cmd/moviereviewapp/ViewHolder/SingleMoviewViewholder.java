package com.example.cmd.moviereviewapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cmd.moviereviewapp.Contractor.IViewHolderContractor;
import com.example.cmd.moviereviewapp.POJO.Movie.MovieListModel;
import com.example.cmd.moviereviewapp.R;

/**
 * Created by cmd on 1.04.18.
 */

public class SingleMoviewViewholder extends RecyclerView.ViewHolder implements IViewHolderContractor, View.OnClickListener {
    private TextView mTitle;
    public ImageView mImage;

    public SingleMoviewViewholder(View itemView) {
        super(itemView);
        mTitle = (TextView)itemView.findViewById(R.id.singleViewTitle);
        mImage = (ImageView) itemView.findViewById(R.id.singleViewImage);
    }

    @Override
    public void setValue(MovieListModel object) {
        mTitle.setText(object.getTitle());
    }

    @Override
    public void onClick(View v) {

    }
}
