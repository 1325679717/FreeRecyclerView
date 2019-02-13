package com.example.free_recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.free_recyclerview.R;
import com.example.free_recyclerview.bean.Data;
import com.example.free_recyclerview.view.AnimateScrollView;

import java.util.List;

/**
 * Created by myt on 2017/5/30.
 */
public class TabAdapter extends RecyclerView.Adapter<TabAdapter.AdapterViewHolder>{

    private List<Data> datas;
    private RecyclerView recyclerView;
    public TabAdapter(List<Data> datas, RecyclerView recyclerView) {
        this.datas = datas;
        this.recyclerView = recyclerView;
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new AdapterViewHolder(View.inflate(parent.getContext(), R.layout.wide_item, null));
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        Data data = datas.get(position);

        holder.textView.setText(data.getName());

        int count = holder.tabTv.length;
        for (int i = 0;i< count;i++){
            TextView v = holder.tabTv[i];
            String str = data.getArray()[i];
            v.setText(str);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    public class AdapterViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        AnimateScrollView anScrView;
        LinearLayout tabRoot;
        TextView[] tabTv;
        private int len = 11;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv);
            anScrView = (AnimateScrollView) itemView.findViewById(R.id.scrollView);
            tabRoot = (LinearLayout) itemView.findViewById(R.id.tab_root);
            anScrView.setTag(recyclerView);
            tabTv = new TextView[len];
            addRow(tabRoot,tabTv,len);
        }

    }
    private void addRow(LinearLayout linearLayout, TextView[] textViews, int size){
        linearLayout.removeAllViews();
        for (int i = 0; i < size; i++){
            View v = View.inflate(linearLayout.getContext(),R.layout.wide_table,null);
            TextView con =  (TextView) v.findViewById(R.id.wide_content);
            textViews[i] = con;
            linearLayout.addView(v);
        }
    }

}
