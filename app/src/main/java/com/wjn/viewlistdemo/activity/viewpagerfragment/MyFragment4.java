package com.wjn.viewlistdemo.activity.viewpagerfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wjn.viewlistdemo.R;

public class MyFragment4 extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("TAG","MyFragment4执行onAttach方法");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG","MyFragment4执行onCreate方法");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content4, container, false);
        Log.d("TAG","MyFragment4执行onCreateView方法");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("TAG","MyFragment4执行onActivityCreated方法");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG","MyFragment4执行onPause方法");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG","MyFragment4执行onStop方法");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TAG","MyFragment4执行onDestroyView方法");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG","MyFragment4执行onDestroy方法");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("TAG","MyFragment4执行onDetach方法");
    }

}
