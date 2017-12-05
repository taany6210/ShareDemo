package com.ty.sharedemo;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @ 文件名:   GoodsAdapter
 * @ 创建者:   ty
 * @ 时间:    2017/12/4 上午10:30
 * @ 描述:
 */
public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsViewHolder> {

    private List<String> mList = new ArrayList<>();

    public List<String> getList() {
        return mList;
    }

    public void setList(List<String> list) {
        mList.clear();
        addList(list);
    }

    public void addList(List<String> list) {
        if (list != null) {
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override
    public GoodsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods, parent, false);
        return new GoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GoodsViewHolder holder, int position) {
        holder.bindData("第" + (position + 1) + "次: " + mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class GoodsViewHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView mTitle;

        public GoodsViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_title);
        }

        public void bindData(String title) {
            mTitle.setText(title);
        }
    }
}
