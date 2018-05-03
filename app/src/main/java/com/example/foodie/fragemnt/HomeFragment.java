package com.example.foodie.fragemnt;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;

import com.allure.lbanners.LMBanners;
import com.example.foodie.R;
import com.example.foodie.adapter.LocalImgAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    @InjectView(R.id.banners)
    LMBanners banners;
    @InjectView(R.id.searchView)
    SearchView editText;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, view);
        List list = new ArrayList();
        list.add(R.mipmap.banner1);
        list.add(R.mipmap.banner2);
        list.add(R.mipmap.banner3);
        banners.setAdapter(new LocalImgAdapter(getActivity()), list);
        init();
        return view;
    }
   private void init() {
        banners.setAutoPlay(true);//自动播放
        banners.setVertical(false);//是否可以垂直
        banners.setScrollDurtion(222);//两页切换时间
        banners.setCanLoop(true);//循环播放
        banners.setSelectIndicatorRes(R.drawable.page_indicator_select);//选中的原点
        banners.setUnSelectUnIndicatorRes(R.drawable.page_indicator_unselect);//未选中的原点
        banners.setDurtion(2000);//切换时间
        banners.hideIndicatorLayout();//隐藏原点
        banners.showIndicatorLayout();//显示原点
        banners.setIndicatorPosition(LMBanners.IndicaTorPosition.BOTTOM_MID);//设置原点显示位置
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
