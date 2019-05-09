package com.wjn.viewlistdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.wjn.viewlistdemo.R;
import com.wjn.viewlistdemo.activity.recyclerview.RecyclerViewActivity;
import com.wjn.viewlistdemo.activity.tablayout.TabLayoutActivity;
import com.wjn.viewlistdemo.activity.textview.TextViewActivity;
import com.wjn.viewlistdemo.activity.textview.TextViewMaxActivity;
import com.wjn.viewlistdemo.activity.textview.TextViewRollingActivity;
import com.wjn.viewlistdemo.activity.viewpagerfragment.MainVFActivity;
import com.wjn.viewlistdemo.activity.viewpagertablayout.ViewPagerTabLayoutActivity;
import com.wjn.viewlistdemo.utils.StatusBarUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //根据状态栏颜色来决定 状态栏背景 用黑色还是白色 true:是否修改状态栏字体颜色
        StatusBarUtil.setStatusBarMode(this, false, false, R.color.colorPrimary);

        //TextView显示最大行
        TextView textView00 = findViewById(R.id.activity_main_textview00);
        textView00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TextViewMaxActivity.class);
                startActivity(intent);
            }
        });

        //TextView绚丽多彩
        TextView textView0 = findViewById(R.id.activity_main_textview0);
        textView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TextViewActivity.class);
                startActivity(intent);
            }
        });

        //TextView仿支付宝滚动效果
        TextView textView000 = findViewById(R.id.activity_main_textview000);
        textView000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TextViewRollingActivity.class);
                startActivity(intent);
            }
        });

        //TabLayout
        TextView textView1 = findViewById(R.id.activity_main_textview1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TabLayoutActivity.class);
                startActivity(intent);
            }
        });

        //RecyclerView
        TextView textView2 = findViewById(R.id.activity_main_textview2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        //ViewPager+Fragment
        TextView textView3 = findViewById(R.id.activity_main_textview3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainVFActivity.class);
                startActivity(intent);
            }
        });

    }

}
