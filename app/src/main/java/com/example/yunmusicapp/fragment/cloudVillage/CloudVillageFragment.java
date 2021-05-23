package com.example.yunmusicapp.fragment.cloudVillage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.yunmusicapp.R;
import com.example.yunmusicapp.cloudVillage.CloudVillageViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class CloudVillageFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cloudvillage_fragment, container, false);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){
        TabLayout CloudVillage_TabLayout = view.findViewById(R.id.CloudVillage_TabLayout);
        ViewPager CloudVillage_ViewPager = view.findViewById(R.id.CloudVillage_ViewPager);

        CloudVillage_ViewPager.setAdapter(new CloudVillageViewPagerAdapter(getParentFragmentManager()));
        CloudVillage_TabLayout.setupWithViewPager(CloudVillage_ViewPager);
    }
}
