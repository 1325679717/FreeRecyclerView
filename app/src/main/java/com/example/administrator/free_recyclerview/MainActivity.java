package com.example.administrator.free_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    FreeRecyclerView rv;
    private List<Data> objects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wide_main);
        rv = (FreeRecyclerView) findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rv.setLayoutManager(layoutManager);
        objects = new ArrayList<Data>();
        for (int i = 0;i <100; i++){
            Data data = new Data();
            data.setName("iphone "+ (i+1));
            String[] strs = {"A1","A2","A3","A4","A5","A6","A7","A8","A9","A10","A11"};
            data.setArray(strs);
            objects.add(data);
        }
        TabAdapter adapter = new TabAdapter(objects,rv);
        HeaderWrapper headerWrapper = new HeaderWrapper(rv,adapter);


        View view = View.inflate(this,R.layout.wide_item,null);
        view.setBackgroundColor(getResources().getColor(R.color.colorGary_1));
        TextView textView = (TextView) view.findViewById(R.id.tv);
        textView.setText("设备");
        textView.setBackgroundColor(getResources().getColor(R.color.colorGary_1));

        LinearLayout tab_root = (LinearLayout) view.findViewById(R.id.tab_root);
        addTitle(tab_root);

        headerWrapper.addHeaderView(view);
        rv.setAdapter(headerWrapper);
        rv.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.HORIZONTAL_LIST));
    }
    private void addTitle(ViewGroup viewGroup){
        int len = 11;
        String[] strs = {"cpu1","cpu2","cpu3","cpu4","cpu5","cpu6","cpu7","cpu8","cpu9","cpu10","cpu11"};
        for (int i = 0;i< len;i++){
            View v = View.inflate(this,R.layout.wide_table,null);
            TextView textView = (TextView) v.findViewById(R.id.wide_content);
            textView.setText(strs[i]);
            viewGroup.addView(v);
        }
    }

}
