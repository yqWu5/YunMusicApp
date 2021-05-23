package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.adapter.menu.MenuViewPagerAdapter;
import com.example.yunmusicapp.adapter.mine.MineViewPagerAdapter;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.mineView.VerticalViewPager;
import com.example.yunmusicapp.utils.BarTransparent;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    public VerticalViewPager viewPager;
    public TabLayout tabLayout;
    public DrawerLayout drawerLayout;
    public ImageView button;
    public VerticalViewPager Main_Menu;
    public ImageView MainMenu_img;
    public TextView MainMenu_Name;
    private EditText Main_Edit;
    private ImageView Main_Search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BarTransparent.makeStatusBarTransparent(MainActivity.this);
        BarTransparent.setAndroidNativeLightStatusBar(MainActivity.this, true);

        Main_Edit = findViewById(R.id.Main_Edit);
        Main_Search = findViewById(R.id.Main_Search);
        drawerLayout = findViewById(R.id.Main_Layout);
        viewPager = findViewById(R.id.Main_ViewPager);
        tabLayout = findViewById(R.id.Main_TabLayout);
        button = findViewById(R.id.Main_showMore);
        Main_Menu = findViewById(R.id.Main_Menu);
        MainMenu_img = findViewById(R.id.MainMenu_img);
        MainMenu_Name = findViewById(R.id.MainMenu_Name);

        MineViewPagerAdapter adapter = new MineViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(5);
        adapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(viewPager);

        //侧滑菜单开关
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else{
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        //侧滑栏相关设置
        Glide.with(this).load(InfoTmp.getUserDetail().getProfile().getAvatarUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(MainMenu_img);
        MainMenu_Name.setText(InfoTmp.getUserDetail().getProfile().getNickname());
        Main_Menu.setAdapter(new MenuViewPagerAdapter(getSupportFragmentManager()));

        Main_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        Main_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    //关于侧滑菜单的///
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.openmenu:
                drawerLayout.openDrawer(GravityCompat.END);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}