package com.example.yunmusicapp.mineView;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.LinearLayoutManager;

public class MeasureLinearLayoutManager extends LinearLayoutManager {
    private int maxHeight;

    public MeasureLinearLayoutManager(Context context) {
        super(context);
    }

    public MeasureLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public MeasureLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public void setMeasuredDimension(int widthSize, int heightSize) {
        if (maxHeight == 0) {
            super.setMeasuredDimension(widthSize, heightSize);
        } else {
            super.setMeasuredDimension(
                    widthSize, heightSize < maxHeight ? heightSize : maxHeight);
        }
    }
}

