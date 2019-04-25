package com.wjn.viewlistdemo.activity.viewpagerfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wjn.viewlistdemo.R;


public class MyFragment3 extends Fragment {

    private boolean isViewCreated;//Fragment的View加载完毕的标记
    private boolean isUIVisible;//Fragment对用户可见的标记

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content3, container, false);
        isViewCreated = true;
        return view;
    }

    /**
     * setUserVisibleHint 此页面用户是否可见
     */

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isUIVisible = true;
            loadData();
        } else {
            isUIVisible = false;
        }
    }

    /**
     * 模仿加载数据
     */

    private void loadData() {
        if (isViewCreated && isUIVisible) {
            Log.d("TAG", "MyFragment3加载数据！！！");
            isViewCreated = false;
            isUIVisible = false;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isViewCreated = false;
        isUIVisible = false;
    }

}
