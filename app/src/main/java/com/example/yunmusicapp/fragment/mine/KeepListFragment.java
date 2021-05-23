package com.example.yunmusicapp.fragment.mine;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.PlayListDetailActivity;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.adapter.mine.CreateListRecycleAdapter;
import com.example.yunmusicapp.adapter.mine.KeepListRecycleAdapter;
import com.example.yunmusicapp.entity.SingList;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.entity.tmp.PlayListTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;

import java.util.List;

public class KeepListFragment extends Fragment {
    private View view = null;
    private RecyclerView CreateList_Recycle;
    private ImageView CreateList_Button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(null!=view)
        {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (null != parent) {
                parent.removeView(view);
            }
        }else {
            view = inflater.inflate(R.layout.mine_createlistrecycle, container, false);
            initView();//加载控件，
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){
        CreateList_Recycle = view.findViewById(R.id.CreateList_Recycle);
        CreateList_Button = view.findViewById(R.id.CreateList_Button);
        Log.e("ChildCount > 0 ?" , String.valueOf(CreateList_Recycle.getChildCount() > 0 ? true : false));
        if(CreateList_Recycle.getChildCount() > 0){
            CreateList_Recycle.removeAllViews();
        }
        CreateList_Recycle.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        KeepListRecycleAdapter adapter = new KeepListRecycleAdapter(getContext(), getParentFragmentManager());

        List<SingList.PlaylistBean> list = InfoTmp.getKeepPlayList();
        adapter.setBaseOnClickListener(new BaseOnclickListener() {
            @Override
            public void click(int position) {
                Log.e("position", String.valueOf(position));
                Log.e("id", String.valueOf(list.get(position).getId()));
                PlayListTmp tmp = new PlayListTmp();
                tmp.setId(list.get(position).getId());
                tmp.setName(list.get(position).getName());
                tmp.setImgUrl(list.get(position).getCoverImgUrl());
                tmp.setCreator_Name(InfoTmp.getUserDetail().getProfile().getNickname());
                tmp.setCreator_ImgUrl(InfoTmp.getUserDetail().getProfile().getAvatarUrl());
                Intent intent = new Intent(getContext(), PlayListDetailActivity.class);
                intent.putExtra("playListTmp", tmp);
                startActivity(intent);
            }
        });
        CreateList_Recycle.setAdapter(adapter);

        adapter.setData(list);
    }
}
