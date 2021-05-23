package com.example.yunmusicapp.adapter.singerDetail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yunmusicapp.fragment.singerDetail.SingerDetaiMusicFragment;

public class SingerDetailViewPagerAdapter extends FragmentPagerAdapter {
    private static final String[] PAGE_TITLE = {"专辑", "视频"};

    public SingerDetailViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new SingerDetaiMusicFragment();
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
