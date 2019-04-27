package com.test.afinal;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class VIewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList=new ArrayList<>();
    private final List<String> TitlesList=new ArrayList<>();

    public VIewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TitlesList.get(position);
    }

    @Override
    public int getCount() {
        return TitlesList.size();
    }

    public void AddFragment(Fragment fragment,String title){
        fragmentList.add(fragment);
        TitlesList.add(title);

    }
}
