package com.example.yunmusicapp.adapter.musicComment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yunmusicapp.fragment.clickUserInfo.ClickUserInfoFragment;
import com.example.yunmusicapp.fragment.musicComment.MusicCommentHotFragment;

public class MusicCommentRecyclerViewPagerAdapter extends FragmentPagerAdapter {
    private static final String[] PAGE_TITLE = {"最热", "最新"};

    public MusicCommentRecyclerViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public MusicCommentRecyclerViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new MusicCommentHotFragment();
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
