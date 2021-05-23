package com.example.yunmusicapp.adapter.mine;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yunmusicapp.fragment.cloudVillage.CloudVillageFragment;
import com.example.yunmusicapp.fragment.discovery.DiscoveryFragment;
import com.example.yunmusicapp.fragment.mine.MineFragment;

public class MineViewPagerAdapter extends FragmentPagerAdapter {
    private static final String[] PAGE_TITLE = {"我的", "发现","云村"};
    public MineViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch (position){
            case 0: f = new MineFragment(); break;
            case 1: f = new DiscoveryFragment(); break;
            case 2: f = new CloudVillageFragment(); break;
        }
        return f;
    }

    @Override
    public int getCount() {
        return PAGE_TITLE.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  PAGE_TITLE[position];
    }
}
