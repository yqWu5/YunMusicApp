package com.example.yunmusicapp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.palette.graphics.Palette;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.Set;

public class SetColor {
    /**
     * 使用Glide获取网络图片并转换为Bitmap
     *
     * @param path 图片地址
     */
    public static void asBitmap(String path, Context context, ConstraintLayout layout) {
        Glide.with(context).asBitmap()
                .load(path).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap>
                            transition) {
                        paletteBitmap(bitmap, layout);
                    }
                });
    }

    /**
     * 异步抽取图片色调方法
     *
     * @param bitmap Bitmap对象
     */
    public static void paletteBitmap(@NonNull Bitmap bitmap, ConstraintLayout layout) {
        Palette.from(bitmap)//创建Palette.Builder
                .generate(new Palette.PaletteAsyncListener() {//异步抽取图片色调方法
                    @Override
                    public void onGenerated(@NonNull Palette palette) {
//                        //获取到充满活力的这种色调
//                        Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
//                        if (vibrantSwatch != null) {
//                            Log.e("Zorro", "===vibrantSwatch=1=" + vibrantSwatch.getRgb());
//                            layout.setBackgroundColor(vibrantSwatch.getRgb());
//                        }
//                        //获取充满活力的黑
//                        Palette.Swatch darkVibrantSwatch = palette.getDarkVibrantSwatch();
//                        if (darkVibrantSwatch != null) {
//                            Log.e("Zorro", "===darkVibrantSwatch=2=" + darkVibrantSwatch.getRgb());
//                            layout.setBackgroundColor(darkVibrantSwatch.getRgb());
//                        }
//                        //获取充满活力的亮
//                        Palette.Swatch lightVibrantSwatch = palette.getLightVibrantSwatch();
//                        if (lightVibrantSwatch != null) {
//                            Log.e("Zorro", "===lightVibrantSwatch=3=" + lightVibrantSwatch.getRgb());
//                            layout.setBackgroundColor(lightVibrantSwatch.getRgb());
//                        }
//                        //获取柔和的色调
//                        Palette.Swatch mutedSwatch = palette.getMutedSwatch();
//                        if (mutedSwatch != null) {
//                            layout.setBackgroundColor(mutedSwatch.getRgb());
//                        }
//                        //获取柔和的黑
//                        Palette.Swatch darkMutedSwatch = palette.getDarkMutedSwatch();
//                        if (darkMutedSwatch != null) {
//                            Log.e("Zorro", "===darkMutedSwatch=5=" + darkMutedSwatch.getRgb());
//                            layout.setBackgroundColor(darkMutedSwatch.getRgb());
//                        }
//                        //获取柔和的亮
                        Palette.Swatch lightMutedSwatch = palette.getLightMutedSwatch();
                        if (lightMutedSwatch != null) {
                            layout.setBackgroundColor(lightMutedSwatch.getRgb());

                        }
//                        //获得主色调
//                        Palette.Swatch dominant = palette.getDominantSwatch();
//                        if(dominant != null){
//                            layout.setBackgroundColor(dominant.getRgb());
//                        }
                    }
                });
    }
}
