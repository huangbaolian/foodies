package com.example.foodie.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.foodie.R;
import com.example.foodie.fragemnt.HomeFragment;
import com.example.foodie.fragemnt.PersoncenterFragment;
import com.example.foodie.fragemnt.SchoolFragment;
import com.example.foodie.fragemnt.ShoppingFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("首页",R.mipmap.home_off, HomeFragment.class)
                .addTabItem("学校",R.mipmap.noth_off, SchoolFragment.class)
                .addTabItem("购物车",R.mipmap.home_off, ShoppingFragment.class)
                .addTabItem("我的",R.mipmap.user_off, PersoncenterFragment.class);
    }


}
