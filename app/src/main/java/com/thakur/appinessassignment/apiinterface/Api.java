package com.thakur.appinessassignment.apiinterface;


import com.thakur.appinessassignment.models.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Api {




    @GET
    Call<List<ApiResponse>> getList(@Url String url);


 }
