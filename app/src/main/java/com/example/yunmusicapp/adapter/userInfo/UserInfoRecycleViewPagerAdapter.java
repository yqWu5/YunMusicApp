package com.example.yunmusicapp.adapter.userInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yunmusicapp.fragment.userInfo.UserInfoDynamicFragment;
import com.example.yunmusicapp.fragment.userInfo.UserInfoFragment;

public class UserInfoRecycleViewPagerAdapter extends FragmentPagerAdapter {
    private static final String[] PAGE_TITLE = {"主页", "动态"};

    public UserInfoRecycleViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch (position){
            case 0: f = new UserInfoFragment(); break;
            case 1: f= new UserInfoDynamicFragment(); break;
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
