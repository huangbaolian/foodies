package com.example.foodie;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.foodie.activity.MainActivity;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity{
    private static int[] imgs = {R.mipmap.wel1, R.mipmap.wel2, R.mipmap.wel3,R.mipmap.wel4};

    private ArrayList<ImageView> imageViews;
    private ImageView[] dotViews;
    private WelViewPager welViewPager;

    @InjectView(R.id.dot_linear)
    LinearLayout dotLinear;
    @InjectView(R.id.wel_Page_ViewPager)
    ViewPager welPageViewPager;
    @InjectView(R.id.btn_Begin)
    Button btnBegin;
    @InjectView(R.id.activity_welcome)
    RelativeLayout activityWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.inject(this);
        initImages();
        initDots();
        welViewPager = new WelViewPager();
        welPageViewPager.setAdapter(welViewPager);
        welPageViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotViews.length; i++) {
                    if (position == i) {
                        dotViews[i].setSelected(true);
                    } else {
                        dotViews[i].setSelected(false);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //判断SDK版本是否大于等于4.4  因为该属性只有19版本才能设置
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS |
                    localLayoutParams.flags);
        }
    }

    @OnClick(R.id.btn_Begin)
    public void onViewClicked() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    /**
     * 初始化图片的配置
     */
    private void initImages() {
        //设置每一张图片都填充窗口
        ViewPager.LayoutParams mParams = new ViewPager.LayoutParams();
        imageViews = new ArrayList<ImageView>();
        for (int i = 0; i < imgs.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mParams);//设置布局
            iv.setImageResource(imgs[i]);//为ImageView添加图片资源
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);//这里也是一个图片的适配
            imageViews.add(iv);

        }
    }

    /**
     * 初始化小圆点
     */
    private void initDots() {
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(20,20);
        mParams.setMargins(10,0,10,0);
        dotViews = new ImageView[imgs.length];
        for (int i=0;i<imageViews.size();i++){
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(mParams);
            imageView.setImageResource(R.drawable.dotselect);
            if(i== 0)
            {
                imageView.setSelected(true);//默认启动时，选中第一个小圆点
            }
            else {
                imageView.setSelected(false);
            }
            dotViews[i] = imageView;//得到每个小圆点的引用，用于滑动页面时，（onPageSelected方法中）更改它们的状态。
            dotLinear.addView(imageView);//添加到布局里面显示
        }
    }

     class WelViewPager extends PagerAdapter {

        @Override
        public int getCount() {
            return imageViews.size();
        }

        /**
         * 判断是否用对象生成界面
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == object;
        }

        /**
         * 从ViewGroup中移除当前对象（图片）
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position));
        }

        /**
         * 当前要显示的对象（图片）
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }
    }


}
