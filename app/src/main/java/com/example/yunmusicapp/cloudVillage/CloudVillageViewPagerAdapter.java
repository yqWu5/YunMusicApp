package com.example.yunmusicapp.cloudVillage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yunmusicapp.fragment.cloudVillage.CloudVillageRecommendFragment;
import com.example.yunmusicapp.fragment.mine.MineFragment;

public class CloudVillageViewPagerAdapter extends FragmentPagerAdapter {
    private static final String[] PAGE_TITLE = {"推荐", "关注"};

    public CloudVillageViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new CloudVillageRecommendFragment();
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
