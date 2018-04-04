package com.example.cmd.moviereviewapp.Listener;

/**
 * Created by cmd on 17.03.18.
 */

public interface IOnDataCallback<T> {
    void onSuccess(T data);
    void onFailure(String message);
}
