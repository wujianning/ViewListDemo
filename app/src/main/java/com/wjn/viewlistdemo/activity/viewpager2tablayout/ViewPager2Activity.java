package com.wjn.viewlistdemo.activity.viewpager2tablayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wjn.viewlistdemo.R;
import com.wjn.viewlistdemo.utils.StatusBarUtil;

public class ViewPager2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager2);
        //根据状态栏颜色来决定 状态栏背景 用黑色还是白色 true:是否修改状态栏字体颜色
        StatusBarUtil.setStatusBarMode(this, false,false, R.color.colorPrimary);
    }
}
