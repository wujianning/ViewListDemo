package com.wjn.viewlistdemo.activity.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.wjn.viewlistdemo.R;
import com.wjn.viewlistdemo.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_SETTLING;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRecycleViewAdapter adapter;
    private List<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        //根据状态栏颜色来决定 状态栏背景 用黑色还是白色 true:是否修改状态栏字体颜色
        StatusBarUtil.setStatusBarMode(this, false, false, R.color.colorPrimary);

        initView();

    }

    /**
     * 初始化各种View
     * */

    private void initView(){
        recyclerView=findViewById(R.id.activity_recyclerview_recycleview);
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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //3.设置ItemAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //4.设置固定大小
        recyclerView.setHasFixedSize(true);
        adapter = new MyRecycleViewAdapter(this, list);
        recyclerView.setAdapter(adapter);

        /**
         * RecycleView滚动监听
         * */

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case SCROLL_STATE_SETTLING://滚动

                        break;
                    case SCROLL_STATE_DRAGGING://拖动

                        break;
                    case SCROLL_STATE_IDLE://空闲

                        break;
                    default://其他

                        break;
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        /**
         * Item点击以及长按监听
         * */

        if (null != adapter) {
            adapter.setRecycleViewItemClickAndLongClick(new RecycleViewAdapterInterface() {
                @Override
                public void OnItemCilck(View view, int position) {
                    if (null != list) {
                        String name = list.get(position).getName();
                        Toast.makeText(RecyclerViewActivity.this, "点击：" + name, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void OnItemLongCilck(View view, int position) {
                    if (null != list) {
                        String name = list.get(position).getName();
                        Toast.makeText(RecyclerViewActivity.this, "长按：" + name, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

}
