package com.thakur.appinessassignment.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thakur.appinessassignment.apiinterface.Api;
import com.thakur.appinessassignment.models.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListModel extends ViewModel {
    Application application;
    Retrofit retrofit;
    String url;
    private MutableLiveData<List<ApiResponse>> apiResponse;

    public ListModel(Application application, Retrofit retrofit, String url) {
        this.application = application;
        this.retrofit = retrofit;
        this.url=url;
    }


    public LiveData<List<ApiResponse>> apiResponseLiveData() {

        if (apiResponse == null) {
            apiResponse = new MutableLiveData<List<ApiResponse>>();

            getImage();
        }


        return apiResponse;
    }

    private void getImage() {
        Api api = retrofit.create(Api.class);
        Call<List<ApiResponse>> call = api.getList(url);

        call.enqueue(new Callback<List<ApiResponse>>() {
            @Override
            public void onResponse(Call<List<ApiResponse>> call, Response<List<ApiResponse>> response) {
              //  Log.d("data",response.body().toString());
                apiResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ApiResponse>> call, Throwable t) {
                Log.d("data",t.getMessage()+""
                );

            }
        });
    }
}
