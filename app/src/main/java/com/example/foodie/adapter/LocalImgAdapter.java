package com.example.foodie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.allure.lbanners.LMBanners;
import com.allure.lbanners.adapter.LBaseAdapter;
import com.example.foodie.R;

/**
 * Created by Administrator on 2017\12\7 0007.
 */

public class LocalImgAdapter implements LBaseAdapter<Integer> {
    Context mContext;

    public LocalImgAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View getView(LMBanners lBanners, Context context, int position, Integer data) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.item,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.id_image);
        //可行选择喜欢的图片加载库。
        imageView.setImageResource(data);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}
