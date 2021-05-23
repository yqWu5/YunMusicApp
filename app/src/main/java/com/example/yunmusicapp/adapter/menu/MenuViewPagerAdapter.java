package com.example.yunmusicapp.adapter.menu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yunmusicapp.fragment.menu.MenuFragment;

public class MenuViewPagerAdapter extends FragmentPagerAdapter {
    public MenuViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public MenuViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new MenuFragment();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
