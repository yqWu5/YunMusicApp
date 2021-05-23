package com.example.yunmusicapp.adapter.mine;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.fragment.mine.CreateListFragment;
import com.example.yunmusicapp.fragment.mine.KeepListFragment;
import com.example.yunmusicapp.fragment.mine.ListAssistFragment;

public class CreateListAdapterViewPager extends FragmentPagerAdapter {
    private static final String[] PAGE_TITLE = {"创建歌单", "收藏歌单", "歌单助手"};

    public CreateListAdapterViewPager(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch (position){
            case 0: f = new CreateListFragment(); break;
            case 1: f = new KeepListFragment(); break;
            case 2: f = new ListAssistFragment(); break;
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
