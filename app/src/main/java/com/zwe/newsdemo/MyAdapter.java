package com.zwe.newsdemo;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Asus on 2017/4/2.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<NewsList> mNewsLists;

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout mLinearLayout;
        ImageView imgHead;
        TextView tvTime;
        TextView tvTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            mLinearLayout= (LinearLayout) itemView.findViewById(R.id.ll);
            imgHead= (ImageView) itemView.findViewById(R.id.imgHead);
            tvTime= (TextView) itemView.findViewById(R.id.tvTime);
            tvTitle= (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }

    public MyAdapter(List<NewsList> mNewsLists){
        this.mNewsLists=mNewsLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String url=mNewsLists.get(position).getUrl();
        String time=mNewsLists.get(position).getTime();
        String title=mNewsLists.get(position).getTitle();
        final String newsUri=mNewsLists.get(position).getNewsUrl();
        Glide.with(holder.imgHead.getContext()).load(url).into(holder.imgHead);
        holder.tvTime.setText(time);
        holder.tvTitle.setText(title);
        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(),DocActivity.class);
                intent.putExtra("newsUrl",newsUri);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewsLists.size();
    }
}
