package com.example.yunmusicapp.adapter.fansFollowed;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yunmusicapp.fragment.fansFollowed.FansFragment;
import com.example.yunmusicapp.fragment.fansFollowed.FollowedFragment;
import com.example.yunmusicapp.fragment.mine.CreateListFragment;
import com.example.yunmusicapp.fragment.mine.KeepListFragment;
import com.example.yunmusicapp.fragment.mine.ListAssistFragment;

public class FansFollowedViewPagerAdapter extends FragmentPagerAdapter {
    private static final String[] PAGE_TITLE = {"关注", "粉丝"};

    public FansFollowedViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch (position){
            case 0: f = new FollowedFragment(); break;
            case 1: f = new FansFragment(); break;
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
