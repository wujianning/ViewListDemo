package com.wjn.viewlistdemo.activity.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wjn.viewlistdemo.R;
import com.wjn.viewlistdemo.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout tabLayout1;
    private TabLayout tabLayout2;
    private TabLayout tabLayout3;
    private TabLayout tabLayout4;
    private TabLayout tabLayout5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        //根据状态栏颜色来决定 状态栏背景 用黑色还是白色 true:是否修改状态栏字体颜色
        StatusBarUtil.setStatusBarMode(this, false, false, R.color.colorPrimary);

        initTabLayoutView1();

        initTabLayoutView2();

        initTabLayoutView3();

        initTabLayoutView4();

        initTabLayoutView5();

    }

    /**
     * 初始化各种View
     */

    private void initTabLayoutView1() {
        tabLayout1 = findViewById(R.id.activity_tablayout_tablayout1);

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
            tabLayout1.addTab(tabLayout1.newTab().setText(name));
        }

    }

    /**
     * 初始化各种View
     */

    private void initTabLayoutView2() {
        tabLayout2 = findViewById(R.id.activity_tablayout_tablayout2);

        List<String> list = new ArrayList<>();
        list.add("鲁能");
        list.add("李霄鹏");
        list.add("蒿俊闵");
        list.add("佩莱");
        list.add("韦德");
        list.add("詹姆斯");

        List<Integer> listpic = new ArrayList<>();
        listpic.add(R.mipmap.ic_action_add);
        listpic.add(R.mipmap.ic_action_add);
        listpic.add(R.mipmap.ic_action_add);
        listpic.add(R.mipmap.ic_action_add);
        listpic.add(R.mipmap.ic_action_add);
        listpic.add(R.mipmap.ic_action_add);

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            int mipmap = listpic.get(i);
            tabLayout2.addTab(tabLayout2.newTab().setText(name).setIcon(mipmap));
        }
    }

    /**
     * 初始化各种View
     */

    private void initTabLayoutView3() {
        tabLayout3 = findViewById(R.id.activity_tablayout_tablayout3);

        List<String> list = new ArrayList<>();
        list.add("鲁能");
        list.add("李霄鹏");
        list.add("蒿俊闵");
        list.add("佩莱");
        list.add("韦德");
        list.add("詹姆斯");

        List<Integer> listpic = new ArrayList<>();
        listpic.add(R.mipmap.followupplan);
        listpic.add(R.mipmap.followupplan);
        listpic.add(R.mipmap.followupplan);
        listpic.add(R.mipmap.followupplan);
        listpic.add(R.mipmap.followupplan);
        listpic.add(R.mipmap.followupplan);

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            int mipmap = listpic.get(i);
            TabLayout.Tab tab = tabLayout3.newTab();
            View inflate = View.inflate(this, R.layout.tablayout_item, null);
            TextView textView = inflate.findViewById(R.id.tablayout_item_textview);
            textView.setText(name);
            ImageView imageView = inflate.findViewById(R.id.tablayout_item_imagview);
            imageView.setBackgroundResource(mipmap);
            tab.setCustomView(inflate);
            tabLayout3.addTab(tab);
        }
    }

    /**
     * 初始化各种View
     */

    private void initTabLayoutView4() {
        tabLayout4 = findViewById(R.id.activity_tablayout_tablayout4);

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
            //1.先赋值
            String name = list.get(i);
            tabLayout4.addTab(tabLayout4.newTab().setText(name));
            //2.获取每一个tab对象
            TabLayout.Tab tabAt = tabLayout4.getTabAt(i);
            //3.将每一个条目设置我们自定义的视图
            tabAt.setCustomView(R.layout.tablayout_item_textview);
            //4.默认选中第一个
            if (i == 0) {
                TextView textView = tabAt.getCustomView().findViewById(R.id.tablayout_item_textview_textview);
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.textview_sel));
            }
            //5.通过tab对象找到自定义视图的ID并赋值
            TextView textView = tabAt.getCustomView().findViewById(R.id.tablayout_item_textview_textview);
            textView.setText(name);//设置tab上的文字
        }

        //TabLayout 点击事件
        tabLayout4.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            //选中
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TextView textView = tab.getCustomView().findViewById(R.id.tablayout_item_textview_textview);
                textView.setTextSize(20);
                textView.setTextColor(getResources().getColor(R.color.textview_sel));
                Log.d("TAG", "onTabSelected方法！！！" + tab.getText());
            }

            //取消选中
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                TextView textView = tab.getCustomView().findViewById(R.id.tablayout_item_textview_textview);
                textView.setTextSize(14);
                textView.setTextColor(getResources().getColor(R.color.textview));
                Log.d("TAG", "onTabUnselected方法！！！" + tab.getText());
            }

            //点击已选中
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.d("TAG", "onTabReselected方法！！！" + tab.getText());
            }
        });

    }

    /**
     * 初始化各种View
     */

    private void initTabLayoutView5() {
        tabLayout5 = findViewById(R.id.activity_tablayout_tablayout5);

        List<String> list = new ArrayList<>();
        list.add("新闻");
        list.add("头条");
        list.add("中超");

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            tabLayout5.addTab(tabLayout5.newTab().setText(name));
        }

    }

}
