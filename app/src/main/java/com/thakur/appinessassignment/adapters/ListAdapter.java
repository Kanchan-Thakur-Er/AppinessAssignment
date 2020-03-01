package com.thakur.appinessassignment.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.thakur.appinessassignment.R;
import com.thakur.appinessassignment.fragments.EnterprisemailFragment;
import com.thakur.appinessassignment.models.ApiResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    Context context;
    Fragment savedIdeaFragment;
    View view;
    ArrayList<ApiResponse> apiResponseArrayList;

    public ListAdapter(Context context, EnterprisemailFragment fragment, ArrayList<ApiResponse> imageArrayList) {
        this.context = context;
        this.savedIdeaFragment = fragment;
        this.apiResponseArrayList = imageArrayList;

    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.row_list, viewGroup, false);
        return new ListAdapter.ViewHolder(view);
    }
    //This method will filter the list
    //here we are passing the filtered data
    //and assigning it to the list with notifydatasetchanged method
    public void filterList(ArrayList<ApiResponse> filterdNames) {
        this.apiResponseArrayList = filterdNames;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        ApiResponse apiResponse = apiResponseArrayList.get(position);
        holder.tvTitle.setText(apiResponse.getTitle());
        Log.d("data",apiResponse.getNumbackers());
        holder.tvNoofBackers.setText(apiResponse.getNumbackers());

    }

    @Override
    public int getItemCount() {
        return apiResponseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvNoofBackers)
        TextView tvNoofBackers;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

}
