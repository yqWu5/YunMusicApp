package com.example.yunmusicapp.adapter.clickUserInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yunmusicapp.fragment.clickUserInfo.ClickUserInfoFragment;
import com.example.yunmusicapp.fragment.fansFollowed.FansFragment;
import com.example.yunmusicapp.fragment.fansFollowed.FollowedFragment;
import com.example.yunmusicapp.fragment.userInfo.UserInfoDynamicFragment;

public class ClickUserInfoViewPagerAdapter extends FragmentPagerAdapter {
    private static final String[] PAGE_TITLE = {"主页", "动态"};

    public ClickUserInfoViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0: fragment = new ClickUserInfoFragment(); break;
            case 1: fragment = new UserInfoDynamicFragment(); break;
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
