package com.wjn.viewlistdemo.activity.viewpagerfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wjn.viewlistdemo.R;
import com.wjn.viewlistdemo.activity.recyclerview.MyRecycleViewAdapter;
import com.wjn.viewlistdemo.activity.recyclerview.Student;

import java.util.ArrayList;
import java.util.List;


public class MyFragment1 extends Fragment {

    private RecyclerView recyclerView;
    private MyRecycleViewAdapter adapter;
    private List<Student> list;

    /**
     * onCreateView方法
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content1, container, false);
        initView(view);//初始化View
        return view;
    }

    /**
     * 初始化各种View
     * */

    private void initView(View view) {
        recyclerView=view.findViewById(R.id.fragment_content1_recycleview);
        list = new ArrayList<>();
        Student student1 = new Student();
        student1.setName("詹姆斯");
        student1.setDescribe(student1.getName() + "：很懒什么也没留下！");

        Student student2 = new Student();
        student2.setName("韦德");
        student2.setDescribe(student2.getName() + "：很懒什么也没留下！");

        Student student3 = new Student();
        student3.setName("山东鲁能");
        student3.setDescribe(student3.getName() + "：很懒什么也没留下！");

        Student student4 = new Student();
        student4.setName("保罗");
        student4.setDescribe(student4.getName() + "：很懒什么也没留下！");

        Student student5 = new Student();
        student5.setName("安东尼");
        student5.setDescribe(student5.getName() + "：很懒什么也没留下！");

        Student student6 = new Student();
        student6.setName("蒿俊闵");
        student6.setDescribe(student6.getName() + "：很懒什么也没留下！");

        Student student7 = new Student();
        student7.setName("李霄鹏");
        student7.setDescribe(student7.getName() + "：很懒什么也没留下！");

        for (int i = 0; i < 30; i++) {
            list.add(student1);
            list.add(student2);
            list.add(student3);
            list.add(student4);
            list.add(student5);
            list.add(student6);
            list.add(student7);
        }

        //2.设置LinearLayoutManager ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //3.设置ItemAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //4.设置固定大小
        recyclerView.setHasFixedSize(true);
        adapter = new MyRecycleViewAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);

        Log.d("TAG","MyFragment1加载数据！！！");
    }

}
