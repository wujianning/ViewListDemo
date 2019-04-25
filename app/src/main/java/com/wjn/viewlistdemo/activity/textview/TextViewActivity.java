package com.wjn.viewlistdemo.activity.textview;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wjn.viewlistdemo.R;
import com.wjn.viewlistdemo.utils.StatusBarUtil;

public class TextViewActivity extends AppCompatActivity {

    private TextView textView1, textView2, textView3, textView4, textView5, textView6,
            textView7, textView8, textView9, textView10, textView11, textView12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        //根据状态栏颜色来决定 状态栏背景 用黑色还是白色 true:是否修改状态栏字体颜色
        StatusBarUtil.setStatusBarMode(this, false, false, R.color.colorPrimary);

        initView();

    }

    /**
     * 初始化各种View
     */

    private void initView() {
        textView1 = findViewById(R.id.textview1);
        textView2 = findViewById(R.id.textview2);
        textView3 = findViewById(R.id.textview3);
        textView4 = findViewById(R.id.textview4);
        textView5 = findViewById(R.id.textview5);
        textView6 = findViewById(R.id.textview6);
        textView7 = findViewById(R.id.textview7);
        textView8 = findViewById(R.id.textview8);
        textView9 = findViewById(R.id.textview9);
        textView10 = findViewById(R.id.textview10);
        textView11 = findViewById(R.id.textview11);
        textView12 = findViewById(R.id.textview12);

        //设置文本字体颜色
        SpannableString spannableString1 = new SpannableString("设置文字的前景色为淡蓝色");
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spannableString1.setSpan(colorSpan1, 9, spannableString1.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView1.setText(spannableString1);


        //设置文本背景颜色
        SpannableString spannableString2 = new SpannableString("设置文字的背景色为淡绿色");
        BackgroundColorSpan colorSpan2 = new BackgroundColorSpan(Color.parseColor("#AC00FF30"));
        spannableString2.setSpan(colorSpan2, 9, spannableString2.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView2.setText(spannableString2);


        //为文本设置下划线
        SpannableString spannableString3 = new SpannableString("为文字设置下划线");
        UnderlineSpan underlineSpan3 = new UnderlineSpan();
        spannableString3.setSpan(underlineSpan3, 5, spannableString3.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView3.setText(spannableString3);


        //为文本设置图片
        SpannableString spannableString4 = new SpannableString("在文本中添加表情（表情）");
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0, 0, 42, 42);
        ImageSpan imageSpan4 = new ImageSpan(drawable);
        spannableString4.setSpan(imageSpan4, 6, 8, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView4.setText(spannableString4);


        //为文本设置点击事件
        SpannableString spannableString5 = new SpannableString("为文字设置点击事件");
        MyClickableSpan clickableSpan5 = new MyClickableSpan("https://blog.csdn.net/weixin_37730482");
        spannableString5.setSpan(clickableSpan5, 5, spannableString5.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView5.setMovementMethod(LinkMovementMethod.getInstance());
        textView5.setHighlightColor(Color.parseColor("#36969696"));
        textView5.setText(spannableString5);


        //为文本设置上标
        SpannableString spannableString6 = new SpannableString("为文字设置上标");
        SuperscriptSpan superscriptSpan6 = new SuperscriptSpan();
        spannableString6.setSpan(superscriptSpan6, 5, spannableString6.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView6.setText(spannableString6);


        //为文本设置下标
        SpannableString spannableString7 = new SpannableString("为文字设置下标");
        SubscriptSpan subscriptSpan7 = new SubscriptSpan();
        spannableString7.setSpan(subscriptSpan7, 5, spannableString7.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView7.setText(spannableString7);


        //为文本设置粗体斜体等风格
        SpannableString spannableString8 = new SpannableString("为文字设置粗体、斜体风格");
        StyleSpan styleSpan_B = new StyleSpan(Typeface.BOLD);
        StyleSpan styleSpan_I = new StyleSpan(Typeface.ITALIC);
        spannableString8.setSpan(styleSpan_B, 5, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString8.setSpan(styleSpan_I, 8, 10, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView8.setHighlightColor(Color.parseColor("#36969696"));
        textView8.setText(spannableString8);


        //为文本设置超链接
        SpannableString spannableString9 = new SpannableString("为文字设置超链接");
        URLSpan urlSpan9 = new URLSpan("https://blog.csdn.net/weixin_37730482");
        spannableString9.setSpan(urlSpan9, 5, spannableString9.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView9.setMovementMethod(LinkMovementMethod.getInstance());
        textView9.setHighlightColor(Color.parseColor("#36969696"));
        textView9.setText(spannableString9);


        //为文本设置相对大小
        SpannableString spannableString10 = new SpannableString("万丈高楼平地起");
        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(1.2f);
        RelativeSizeSpan sizeSpan02 = new RelativeSizeSpan(1.4f);
        RelativeSizeSpan sizeSpan03 = new RelativeSizeSpan(1.6f);
        RelativeSizeSpan sizeSpan04 = new RelativeSizeSpan(1.8f);
        RelativeSizeSpan sizeSpan05 = new RelativeSizeSpan(1.6f);
        RelativeSizeSpan sizeSpan06 = new RelativeSizeSpan(1.4f);
        RelativeSizeSpan sizeSpan07 = new RelativeSizeSpan(1.2f);
        spannableString10.setSpan(sizeSpan01, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString10.setSpan(sizeSpan02, 1, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString10.setSpan(sizeSpan03, 2, 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString10.setSpan(sizeSpan04, 3, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString10.setSpan(sizeSpan05, 4, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString10.setSpan(sizeSpan06, 5, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString10.setSpan(sizeSpan07, 6, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView10.setText(spannableString10);


        //为文本设置中划线
        SpannableString spannableString11 = new SpannableString("为文字设置删除线");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString11.setSpan(strikethroughSpan, 5, spannableString11.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView11.setText(spannableString11);


        //SpannableStringBuilder拼接多种类型
        //为文本设置上标
        SpannableString spannableString61 = new SpannableString("为文字设置上标");
        SuperscriptSpan superscriptSpan61 = new SuperscriptSpan();
        spannableString61.setSpan(superscriptSpan61, 5, spannableString61.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);


        //为文本设置下标
        SpannableString spannableString71 = new SpannableString("为文字设置下标");
        SubscriptSpan subscriptSpan71 = new SubscriptSpan();
        spannableString71.setSpan(subscriptSpan71, 5, spannableString71.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);


        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(spannableString61);
        spannableStringBuilder.append(spannableString71);
        textView12.setText(spannableStringBuilder);

    }

    /**
     * 为文本设置的点击事件
     */

    class MyClickableSpan extends ClickableSpan {

        private String content;

        public MyClickableSpan(String content) {
            this.content = content;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(View widget) {
            Toast.makeText(TextViewActivity.this, content, Toast.LENGTH_LONG).show();
        }
    }


}
