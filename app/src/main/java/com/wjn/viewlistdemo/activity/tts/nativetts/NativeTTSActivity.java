package com.wjn.viewlistdemo.activity.tts.nativetts;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wjn.viewlistdemo.R;
import com.wjn.viewlistdemo.activity.viewpagerfragment.MyFragment1;
import com.wjn.viewlistdemo.utils.StatusBarUtil;

import java.util.Locale;

public class NativeTTSActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nativetts);

        //根据状态栏颜色来决定 状态栏背景 用黑色还是白色 true:是否修改状态栏字体颜色
        StatusBarUtil.setStatusBarMode(this, false, false, R.color.colorPrimary);

        //初始化View
        initView();
    }

    private void initView() {
        textToSpeech = new TextToSpeech(NativeTTSActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == textToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.ENGLISH);
                    if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE
                            && result != TextToSpeech.LANG_AVAILABLE) {
                        Toast.makeText(NativeTTSActivity.this, "TTS暂时不支持这种语音的朗读！",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak("I Love LuNengTaiShan", TextToSpeech.QUEUE_ADD, null);
            }
        });
    }

}
