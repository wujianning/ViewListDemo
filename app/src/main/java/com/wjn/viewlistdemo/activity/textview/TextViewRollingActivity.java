package com.wjn.viewlistdemo.activity.textview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wjn.viewlistdemo.R;
import com.wjn.viewlistdemo.utils.StatusBarUtil;

public class TextViewRollingActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private NumberRunningTextView numberRunningTextView1;
    private NumberRunningTextView numberRunningTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textviewrolling);
        //根据状态栏颜色来决定 状态栏背景 用黑色还是白色 true:是否修改状态栏字体颜色
        StatusBarUtil.setStatusBarMode(this, false, false, R.color.colorPrimary);

        initView();

    }

    /**
     * 初始化各种View
     */

    private void initView() {
        swipeRefreshLayout=findViewById(R.id.activity_textviewrolling_swiperefreshlayout);
        numberRunningTextView1 = findViewById(R.id.activity_textviewrolling_textview1);
        numberRunningTextView2 = findViewById(R.id.activity_textviewrolling_textview2);
        numberRunningTextView1.setContent("1454.95");
        numberRunningTextView2.setContent("300");
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#ff7300"));
        initListener();
    }

    /**
     * 初始化下拉监听
     * */

    private void initListener() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                numberRunningTextView1.setContent("1454.95");
                numberRunningTextView2.setContent("300");
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

}
