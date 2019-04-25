package com.wjn.viewlistdemo.activity.viewpagertablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wjn.viewlistdemo.R;
import com.wjn.viewlistdemo.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerTabLayoutActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpagertablayout);
        //根据状态栏颜色来决定 状态栏背景 用黑色还是白色 true:是否修改状态栏字体颜色
        StatusBarUtil.setStatusBarMode(this, false,false, R.color.colorPrimary);

        initTabLayoutView();

        initViewPager();

    }

    /**
     * 初始化TabLayout
     */

    private void initTabLayoutView() {
        tabLayout = findViewById(R.id.activity_viewpagertablayout_tablayout);

        List<String> list = new ArrayList<>();
        list.add("新闻");
        list.add("头条");
        list.add("中超");
        list.add("NBA");
        list.add("科技");
        list.add("体育");
        list.add("育儿");
        list.add("懂车帝");
        list.add("健康");
        list.add("教育");
        list.add("股票");
        list.add("漫画");

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            tabLayout.addTab(tabLayout.newTab().setText(name));
        }

    }

    /**
     * 初始化ViewPager
     * */

    private void initViewPager(){
        viewPager=findViewById(R.id.activity_viewpagertablayout_viewpager);
    }

}
