package com.thakur.appinessassignment;

import android.app.Application;

import com.thakur.appinessassignment.apicomponent.ApiComponent;
import com.thakur.appinessassignment.apicomponent.DaggerApiComponent;
import com.thakur.appinessassignment.module.ApiModule;
import com.thakur.appinessassignment.module.AppModule;


public class MyApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://www.enterprisesmail.com/json/"))
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }
}
