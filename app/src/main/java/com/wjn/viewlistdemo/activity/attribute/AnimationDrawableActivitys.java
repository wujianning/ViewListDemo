package com.wjn.viewlistdemo.activity.attribute;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wjn.viewlistdemo.R;
import com.wjn.viewlistdemo.utils.StatusBarUtil;

public class AnimationDrawableActivitys extends AppCompatActivity {

    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;
    private Button btn_five;
    private LinearLayout linearLayout;
    private int height;
    private ObjectAnimator animator1;
    private ObjectAnimator animator2;
    private ObjectAnimator animator3;
    private ObjectAnimator animator4;
    private AnimatorSet animSet;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animationdrawables);
        //根据状态栏颜色来决定 状态栏背景 用黑色还是白色 true:是否修改状态栏字体颜色
        StatusBarUtil.setStatusBarMode(this, false, false, R.color.colorPrimary);

        initView();
    }

    /**
     * 初始化各种View
     */

    private void initView() {
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        textView = (TextView) findViewById(R.id.textview);
        btn_one = (Button) findViewById(R.id.button1);
        btn_two = (Button) findViewById(R.id.button2);
        btn_three = (Button) findViewById(R.id.button3);
        btn_four = (Button) findViewById(R.id.button4);
        btn_five = (Button) findViewById(R.id.button5);
        height = linearLayout.getHeight();
        initAnimator();

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animator1.setDuration(3000l);
                animator1.start();
            }
        });


        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animator2.setDuration(3000l);
                animator2.start();
            }
        });


        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animator3.setDuration(3000l);
                animator3.start();
            }
        });


        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animator4.setDuration(3000l);
                animator4.start();
            }
        });


        btn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //将前面的动画集合到一起
                animSet = new AnimatorSet();
                animSet.play(animator4).with(animator3).with(animator2).after(animator1);
                animSet.setDuration(5000l);
                animSet.start();
            }
        });

    }

    //初始化动画
    private void initAnimator() {
        animator1 = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f, 0f, 1f);
        animator2 = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f, 0f);
        animator3 = ObjectAnimator.ofFloat(textView, "scaleX", 2f, 4f, 1f, 0.5f, 1f);
        animator4 = ObjectAnimator.ofFloat(textView, "translationY", height / 8, -100, height / 2);
    }

}
