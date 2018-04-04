package com.example.cmd.moviereviewapp.NetworkInteractor;

import android.content.Context;

import com.example.cmd.moviereviewapp.ApiCall.IServerMovieApiHelper;
import com.example.cmd.moviereviewapp.Constant.Constants;
import com.example.cmd.moviereviewapp.Listener.IOnDataCallback;
import com.example.cmd.moviereviewapp.POJO.Movie.Movie;
import com.example.cmd.moviereviewapp.POJO.Movie.MovieLatest;
import com.example.cmd.moviereviewapp.POJO.Movie.MovieListModel;
import com.example.cmd.moviereviewapp.POJO.Movie.MovieListResponse;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cmd on 17.03.18.
 */

public class ServerMovieCall {
    private Retrofit retrofit;
    private static ServerMovieCall mInstance;
    private Context ctx;

    public static ServerMovieCall getInstance() {
        if (mInstance == null) {
            mInstance = new ServerMovieCall();
        }
        return mInstance;
    }


    public ServerMovieCall() {
        configureClient();
    }

    private void configureClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        HttpUrl url = request.url()
                                .newBuilder()
                                .addQueryParameter("api_key", Constants.API_KEY)
                                .build();
                        request = request.newBuilder()
                                .url(url)
                                .build();

                        return chain.proceed(request);
                    }
                })
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getMovieList(final IOnDataCallback<List<MovieListModel>> onDataCallback) {
        IServerMovieApiHelper iMovieReviewApiService = retrofit.create(IServerMovieApiHelper.class);
        Call<MovieListResponse> call = iMovieReviewApiService.getMovieList();
        call.enqueue(new Callback<MovieListResponse>() {
            @Override
            public void onResponse(Call<MovieListResponse> call, Response<MovieListResponse> response) {
                if (response.isSuccessful()) {
                    onDataCallback.onSuccess(response.body().getMovies());
                } else {
                    onDataCallback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<MovieListResponse> call, Throwable t) {
                onDataCallback.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public void getMovieById(int id, final IOnDataCallback<Movie> onDataCallback) {
        IServerMovieApiHelper iMovieReviewApiService = retrofit.create(IServerMovieApiHelper.class);
        Call<Movie> call = iMovieReviewApiService.getMovieById(id);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    onDataCallback.onSuccess(response.body());
                } else {
                    onDataCallback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                onDataCallback.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public void getLatestMovies(final IOnDataCallback<MovieLatest> onDataCallback) {
        IServerMovieApiHelper iMovieReviewApiService = retrofit.create(IServerMovieApiHelper.class);
        Call<MovieLatest> call = iMovieReviewApiService.getLatestMovies();
        call.enqueue(new Callback<MovieLatest>() {
            @Override
            public void onResponse(Call<MovieLatest> call, Response<MovieLatest> response) {
                if (response.isSuccessful()) {
                    onDataCallback.onSuccess(response.body());
                } else {
                    onDataCallback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<MovieLatest> call, Throwable t) {
                onDataCallback.onFailure(t.getLocalizedMessage());
            }
        });
    }

}
