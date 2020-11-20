package com.example.mvvmsample.networkUtils;

import com.example.mvvmsample.models.CatImage;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Api {

    @GET("search")
    Call<ArrayList<CatImage>> getCatImage(@Header("Content-Type") String content_type);
}
