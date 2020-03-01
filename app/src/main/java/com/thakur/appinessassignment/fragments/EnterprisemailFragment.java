package com.thakur.appinessassignment.fragments;


import android.app.Application;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.thakur.appinessassignment.R;
import com.thakur.appinessassignment.activities.MainActivity;
import com.thakur.appinessassignment.adapters.ListAdapter;
import com.thakur.appinessassignment.infrastructure.Comman;
import com.thakur.appinessassignment.models.ApiResponse;
import com.thakur.appinessassignment.viewmodel.ListModel;
import com.thakur.appinessassignment.viewmodelproviders.ListModelProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnterprisemailFragment extends Fragment {
    @BindView(R.id.rvList)
    RecyclerView rvList;
    @BindView(R.id.editTextSearch)
    EditText editTextSearch;
    private View rootView;
    private Application application;
    private Retrofit retrofit;
    private ListAdapter listAdapter;
   public List<ApiResponse> imageResult1;
    public EnterprisemailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_enterprisemail, container, false);
        ButterKnife.bind(this, rootView);
        init();
        return rootView;
    }

    private void init() {
        application = ((MainActivity) getActivity()).application;
        retrofit = ((MainActivity) getActivity()).retrofit;

        searchView();
        ListModel imageViewModel = ViewModelProviders.of(this, new ListModelProvider(application, retrofit, "api.json")).get(ListModel.class);

        if (Comman.getInstance(getActivity()).isConnectingToInternet(getActivity())) {

            imageViewModel.apiResponseLiveData().observe(this, new Observer<List<ApiResponse>>() {
                @Override
                public void onChanged(@Nullable List<ApiResponse> imageResult) {

                    imageResult1 = imageResult;
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    rvList.setLayoutManager(linearLayoutManager);
                    Collections.sort(imageResult, new Comparator<ApiResponse>() {
                        @Override
                        public int compare(ApiResponse o1, ApiResponse o2) {
                            return o1.getTitle().compareTo(o2.getTitle());
                        }
                    });
                    listAdapter = new ListAdapter(getActivity(), EnterprisemailFragment.this, (ArrayList<ApiResponse>) imageResult);
                    rvList.setAdapter(listAdapter);

                }
            });
        }

        else{
            Comman.getInstance(getActivity()).showDialog(getActivity(), getString(R.string.no_internetConnection));

        }
    }

    private void searchView() {
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString());
            }
        });
    }

    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<ApiResponse> filterdTitle = new ArrayList<>();

        //looping through existing elements
        for (ApiResponse s : imageResult1) {
            //if the existing elements contains the search input
            if (s.getTitle().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdTitle.add(s);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        listAdapter.filterList(filterdTitle);
    }

}
