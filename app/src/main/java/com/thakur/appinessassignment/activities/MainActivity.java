package com.thakur.appinessassignment.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.thakur.appinessassignment.MyApplication;
import com.thakur.appinessassignment.R;
import com.thakur.appinessassignment.fragments.EnterprisemailFragment;
import com.thakur.appinessassignment.models.ApiResponse;
import com.thakur.appinessassignment.viewmodel.ListModel;
import com.thakur.appinessassignment.viewmodelproviders.ListModelProvider;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    @Inject
    public Retrofit retrofit;
    @Inject
    public Application application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MyApplication) getApplication()).getNetComponent().inject(this);
        init();
    }

    private void init() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new EnterprisemailFragment()).commit();

    }
}
