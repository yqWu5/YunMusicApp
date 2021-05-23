package com.example.yunmusicapp.cloudVillage.recommend;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yunmusicapp.fragment.cloudVillage.recommend.RecommendMvFragment;
import com.example.yunmusicapp.fragment.cloudVillage.recommend.RecommendSquareFragment;
import com.example.yunmusicapp.fragment.mine.MineFragment;

public class RecommendViewPagerAdapter extends FragmentPagerAdapter {
    private static final String[] PAGE_TITLE = {"广场", "MV", "网易出品MV"};

    public RecommendViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0: fragment = new RecommendSquareFragment(); break;
            case 1: fragment = new RecommendMvFragment(); break;
            case 2: fragment = new RecommendMvFragment(); break;
        }
        return fragment;
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
