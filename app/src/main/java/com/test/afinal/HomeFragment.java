package com.test.afinal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.content.ContentValues.TAG;

public class HomeFragment extends Fragment{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private VIewPagerAdapter adapter;
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_home,null);
        tabLayout=v.findViewById(R.id.table_layout);
        viewPager=v.findViewById(R.id.view_pager);
        adapter=new VIewPagerAdapter(getChildFragmentManager());
        adapter.AddFragment(new CategoriesFragment(),"Categories");
        adapter.AddFragment(new DestinationFragment(),"Destination");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        Log.i(TAG, "onCreateView:");
        return v;
    }


}
