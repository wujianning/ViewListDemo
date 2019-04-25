package com.wjn.viewlistdemo.activity.textview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wjn.viewlistdemo.R;
import com.wjn.viewlistdemo.utils.StatusBarUtil;

public class TextViewMaxActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private boolean isimageview=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textviewmax);
        //根据状态栏颜色来决定 状态栏背景 用黑色还是白色 true:是否修改状态栏字体颜色
        StatusBarUtil.setStatusBarMode(this, false, false, R.color.colorPrimary);

        initView();

    }

    /**
     * 初始化各种View
     * */

    private void initView(){
        textView=findViewById(R.id.activity_textviewmax_textview);
        imageView=findViewById(R.id.activity_textviewmax_imageview);
        textView.setText(StringUtils.string1);
//        textView.setText(StringUtils.string2);
        textView.post(new Runnable() {
            @Override
            public void run() {
                boolean b=isTextView(textView);
                if(b){
                    imageView.setVisibility(View.VISIBLE);
                }else{
                    imageView.setVisibility(View.GONE);
                }
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isimageview){
                    imageView.setBackgroundResource(R.mipmap.downs);
                    textView.setMaxLines(10000);

                    isimageview=true;
                }else{
                    imageView.setBackgroundResource(R.mipmap.up);
                    textView.setMaxLines(3);
                    isimageview=false;
                }
            }
        });
    }

    private boolean isTextView(TextView textView){
        float m=textView.getPaint().measureText(textView.getText().toString());
        float n=3*(textView.getWidth()-textView.getPaddingRight()-textView.getPaddingLeft());
        return m>n;
    }

}
