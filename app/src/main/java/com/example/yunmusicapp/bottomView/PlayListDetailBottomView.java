package com.example.yunmusicapp.bottomView;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.R;
import com.example.yunmusicapp.bottomView.adapter.PlayListDetailBottomViewAdapter;

import me.shaohui.bottomdialog.BaseBottomDialog;

public class PlayListDetailBottomView extends BaseBottomDialog {
    private static PlayListDetailBottomView playListDetailBottomView = null;
    private static String Title = null;

    public static void setTitle(String title) {
        Title = title;
    }

    //单例模式
    public static synchronized PlayListDetailBottomView getPlayListDetailBottomView() {
        if(playListDetailBottomView == null){
            return new PlayListDetailBottomView();
        }else{
            return playListDetailBottomView;
        }
    }

    @Override
    public int getLayoutRes() {
        return R.layout.playlistdetail_bottom_view;
    }

    //操作数据
    @Override
    public void bindView(View v) {
        RecyclerView PlayListDetail_Bottom_View_Recycler = v.findViewById(R.id.PlayListDetail_Bottom_View_Recycler);
        PlayListDetail_Bottom_View_Recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        PlayListDetail_Bottom_View_Recycler.setAdapter(new PlayListDetailBottomViewAdapter(getContext()));
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }
    //背景深度 默认0.2
    @Override
    public float getDimAmount() {
        return 0.2f;
    }
    //点击区域外是否消失  true-消失 false-不消失
    @Override
    public boolean getCancelOutside() {
        return true;
    }

    //标题
    @Override
    public String getFragmentTag() {
        return super.getFragmentTag();
    }
}
