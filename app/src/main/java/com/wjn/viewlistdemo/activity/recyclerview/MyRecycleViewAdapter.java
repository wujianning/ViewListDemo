package com.wjn.viewlistdemo.activity.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wjn.viewlistdemo.R;

import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder>{

    private Context context;
    private List<Student> list;
    private LayoutInflater mInflater;

    private RecycleViewAdapterInterface recycleViewAdapterInterface=null;
    public void setRecycleViewItemClickAndLongClick(RecycleViewAdapterInterface recycleViewAdapterInterface){
        this.recycleViewAdapterInterface=recycleViewAdapterInterface;
    }


    public MyRecycleViewAdapter(Context context, List<Student> list){
        this.context=context;
        this.list=list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view=mInflater.inflate(R.layout.recyclerview_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.textView1.setText(list.get(i).getName() + "【" + (i + 1) + "】");
        viewHolder.textView2.setText(list.get(i).getDescribe());
        viewHolder.circleImageView.setBackgroundResource(R.mipmap.patient_ava);

        /**
         * 捕获RecycleView的Item点击以及长按事件
         * */

        final int clickposition=i;
        //Item点击
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null!=recycleViewAdapterInterface){
                    recycleViewAdapterInterface.OnItemCilck(v,clickposition);
                }
            }
        });
        //Item长按
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(null!=recycleViewAdapterInterface){
                    recycleViewAdapterInterface.OnItemLongCilck(v,clickposition);
                }
                return true;
            }
        });
    }

    /**
     * ViewHolder类
     * */

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView circleImageView;
        private TextView textView1;
        private TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.recycleview_circleimageview);
            textView1 = itemView.findViewById(R.id.recycleview_item_textview1);
            textView2 = itemView.findViewById(R.id.recycleview_item_textview2);
        }
    }

    /**
     * 添加数据
     * */

    public void addData(Student student,int position) {
        list.add(position, student);
        notifyItemInserted(position);
        notifyItemRangeChanged(position,list.size());
    }

    /**
     * 删除数据
     * */

    public void removeData(int position) {
        list.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,list.size());
    }


}
