package com.thakur.appinessassignment.viewmodelproviders;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.thakur.appinessassignment.viewmodel.ListModel;

import retrofit2.Retrofit;

public class ListModelProvider implements ViewModelProvider.Factory {
    private Application mApplication;
    private Retrofit retrofit;
    String url;


    public ListModelProvider(Application application, Retrofit param, String url) {
        this.mApplication = application;
        this.retrofit = param;
        this.url=url;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new ListModel(mApplication, retrofit,url);
    }
}


