package com.example.cmd.moviereviewapp.POJO.Event;

import com.example.cmd.moviereviewapp.POJO.Movie.MovieListModel;

public class MessageEvent {
    private MovieListModel model;

    public MovieListModel getModel() {
        return model;
    }

    public void setModel(MovieListModel model) {
        this.model = model;
    }
}
