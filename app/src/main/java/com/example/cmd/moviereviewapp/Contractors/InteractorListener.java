package com.example.cmd.moviereviewapp.Contractors;

import java.util.List;

/**
 * Created by cmd on 18.03.18.
 */

public interface InteractorListener<T> {
    void onSuccess(List<T> data, String msg);
    void onFailure(String msg);
}
