package com.example.yunmusicapp.bottomView;

import android.view.View;
import android.widget.TextView;

import com.example.yunmusicapp.R;

import me.shaohui.bottomdialog.BaseBottomDialog;

//歌单底部栏
public class PlayListBottomView extends BaseBottomDialog {
    private static PlayListBottomView playListBottomView = null;
    private static String Title = null;

    public static void setTitle(String title) {
        Title = title;
    }

    //单例模式
    public static synchronized PlayListBottomView getPlayListBottomView() {
        if(playListBottomView == null){
            return new PlayListBottomView();
        }else{
            return playListBottomView;
        }
    }

    @Override
    public int getLayoutRes() {
        return R.layout.playlist_bottom_view;
    }

    //操作数据
    @Override
    public void bindView(View v) {
        TextView playlist_bottom_view_Title = v.findViewById(R.id.playlist_bottom_view_Title);
        playlist_bottom_view_Title.setText(Title);
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
