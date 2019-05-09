package com.wjn.viewlistdemo.activity.viewpagerfragment;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wjn.viewlistdemo.R;
import com.wjn.viewlistdemo.utils.StatusBarUtil;

public class MainVFActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener{

    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private ViewPagerSlide viewPager;
    private MyFragmentPagerAdapter mAdapter;
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;
    private long mExitTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainvf);
        //根据状态栏颜色来决定 状态栏背景 用黑色还是白色 true:是否修改状态栏字体颜色
        StatusBarUtil.setStatusBarMode(this, false, false, R.color.colorPrimary);
        initView();
    }

    /**
     * 初始化各种View
     */

    public void initView() {
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        radioGroup = (RadioGroup) findViewById(R.id.activity_main_radiogroup);
        radioButton1 = (RadioButton) findViewById(R.id.activity_main_channel1);
        radioButton2 = (RadioButton) findViewById(R.id.activity_main_channel2);
        radioButton3 = (RadioButton) findViewById(R.id.activity_main_channel3);
        radioButton4 = (RadioButton) findViewById(R.id.activity_main_channel4);
        viewPager = (ViewPagerSlide) findViewById(R.id.activity_main_viewpager);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(4);//左右缓存各4个Fragment的View
        viewPager.setScanScroll(false);//不可滑动
        radioGroup.setOnCheckedChangeListener(this);
        radioButton1.setChecked(true);//默认首页选中
    }

    /**
     * RadioGroup Item监听
     */

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.activity_main_channel1:
                viewPager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.activity_main_channel2:
                viewPager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.activity_main_channel3:
                viewPager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.activity_main_channel4:
                viewPager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    /**
     * onPageScrolled ViewPager方法
     */

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * onPageSelected ViewPager方法
     */

    @Override
    public void onPageSelected(int position) {

    }

    /**
     * onPageScrollStateChanged ViewPager方法
     * state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
     */

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == 2) {
            switch (viewPager.getCurrentItem()) {
                case PAGE_ONE:
                    radioButton1.setChecked(true);
                    break;
                case PAGE_TWO:
                    radioButton2.setChecked(true);
                    break;
                case PAGE_THREE:
                    radioButton3.setChecked(true);
                    break;
                case PAGE_FOUR:
                    radioButton4.setChecked(true);
                    break;
            }
        }
    }

    /**
     * onKeyDown方法
     * */

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if((System.currentTimeMillis()-mExitTime)>2000){
                Toast.makeText(MainVFActivity.this,"再按一次离开",Toast.LENGTH_LONG).show();
                mExitTime=System.currentTimeMillis();
            }else{
                finish();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

}
