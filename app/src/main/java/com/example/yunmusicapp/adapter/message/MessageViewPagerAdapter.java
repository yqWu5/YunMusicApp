package com.example.yunmusicapp.adapter.message;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yunmusicapp.fragment.message.MessageFragment;

public class MessageViewPagerAdapter extends FragmentPagerAdapter {

    public MessageViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public MessageViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new MessageFragment();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
