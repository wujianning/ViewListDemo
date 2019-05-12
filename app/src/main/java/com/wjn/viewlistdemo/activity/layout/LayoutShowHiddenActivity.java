package com.wjn.viewlistdemo.activity.layout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.wjn.viewlistdemo.R;
import com.wjn.viewlistdemo.activity.textview.NumberRunningTextView;
import com.wjn.viewlistdemo.utils.StatusBarUtil;

public class LayoutShowHiddenActivity extends AppCompatActivity {

    //八大分类模块
    private Animation mainanimation;
    private RelativeLayout courselayout;
    private RelativeLayout positionlayout;
    private RelativeLayout elitelayout;
    private RelativeLayout projectlayout;
    private RelativeLayout hotlayout;
    private RelativeLayout guidelayout;
    private RelativeLayout squarelayout;
    private RelativeLayout huaweilayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutshowhidden);
        //根据状态栏颜色来决定 状态栏背景 用黑色还是白色 true:是否修改状态栏字体颜色
        StatusBarUtil.setStatusBarMode(this, false, false, R.color.colorPrimary);

        initView();

    }

    /**
     * 初始化各种View
     */

    private void initView() {
        mainanimation = AnimationUtils.loadAnimation(this, R.anim.main_in);
        courselayout = (RelativeLayout) findViewById(R.id.activity_indextab_courselayout);
        positionlayout = (RelativeLayout) findViewById(R.id.activity_indextab_positionlayout);
        elitelayout = (RelativeLayout) findViewById(R.id.activity_indextab_elitelayout);
        projectlayout = (RelativeLayout) findViewById(R.id.activity_indextab_projectlayout);
        hotlayout = (RelativeLayout) findViewById(R.id.activity_indextab_hotlayout);
        guidelayout = (RelativeLayout) findViewById(R.id.activity_indextab_guidelayout);
        squarelayout = (RelativeLayout) findViewById(R.id.activity_indextab_squarelayout);
        huaweilayout = (RelativeLayout) findViewById(R.id.activity_indextab_huaweilayout);
        courselayout.setAnimation(mainanimation);
        positionlayout.setAnimation(mainanimation);
        elitelayout.setAnimation(mainanimation);
        projectlayout.setAnimation(mainanimation);
        hotlayout.setAnimation(mainanimation);
        guidelayout.setAnimation(mainanimation);
        squarelayout.setAnimation(mainanimation);
        huaweilayout.setAnimation(mainanimation);
    }

}
