package com.thakur.appinessassignment.apicomponent;



import com.thakur.appinessassignment.activities.MainActivity;
import com.thakur.appinessassignment.module.ApiModule;
import com.thakur.appinessassignment.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity activity);
}