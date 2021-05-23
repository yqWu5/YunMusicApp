package com.example.yunmusicapp.adapter.userCloud;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yunmusicapp.fragment.userCloud.UserCloudFragment;

public class UserCloudViewPagerAdapter extends FragmentPagerAdapter {

    public UserCloudViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new UserCloudFragment();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
