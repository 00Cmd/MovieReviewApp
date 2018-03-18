package com.example.cmd.moviereviewapp.ApiCalls;

import com.example.cmd.moviereviewapp.POJO.Movies.Movie;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieLatest;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by cmd on 17.03.18.
 */

public interface IServerMovieApiHelper {
//    @GET("/genre/tv/list")
//    Call<Void> getTvList(@Field("api_key") String api_key);

    @GET("movie/popular")
    Call<MovieListResponse> getMovieList();

    @GET("movie/{id}")
    Call<Movie> getMovieById(@Path("id") int movie_id);

    @GET("movie/latest")
    Call<MovieLatest> getLatestMovies();

}
