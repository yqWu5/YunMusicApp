package com.example.yunmusicapp.adapter.playList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.yunmusicapp.entity.tmp.PlayListTmp;
import com.example.yunmusicapp.fragment.playList.PlayListFragment;

public class PlayListDetailViewPagerAdapter extends FragmentPagerAdapter {
    private PlayListTmp tmp;

    public PlayListDetailViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void setTmp(PlayListTmp tmp){
        this.tmp = tmp;
    }

    public PlayListTmp getTmp(){
        return tmp;
    }

    public PlayListDetailViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        PlayListFragment f = new PlayListFragment();
        f.setTmp(tmp);
        return f;
    }

    @Override
    public int getCount() {
        return 1;
    }
}
