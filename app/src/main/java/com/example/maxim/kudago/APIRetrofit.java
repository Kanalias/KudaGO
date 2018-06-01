package com.example.maxim.kudago;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRetrofit {
    @GET("public-api/v1.2/locations/?lang=ru")
    Call<List<City>> getData();
}
