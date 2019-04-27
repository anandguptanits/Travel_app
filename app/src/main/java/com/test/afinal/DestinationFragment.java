package com.test.afinal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DestinationFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private RecycleViewAdapter adapter;
    private List<CategoryImages> list;
    public DestinationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_destination,container,false);
        recyclerView=(RecyclerView)v.findViewById(R.id.categories_recycleview);
        adapter=new RecycleViewAdapter(getContext(),list);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        return v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add(new CategoryImages(R.drawable.love1));
        list.add(new CategoryImages(R.drawable.love2));
        list.add(new CategoryImages(R.drawable.love3));
        list.add(new CategoryImages(R.drawable.love4));
        list.add(new CategoryImages(R.drawable.love5));
        list.add(new CategoryImages(R.drawable.love6));
        list.add(new CategoryImages(R.drawable.love1));
        list.add(new CategoryImages(R.drawable.love2));
        list.add(new CategoryImages(R.drawable.love3));
        list.add(new CategoryImages(R.drawable.love4));

    }
}
