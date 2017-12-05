package com.ty.sharedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;

public class GoodsDetailActivity extends AppCompatActivity {

    private static final String TAG = "GoodsDetailActivity";
    private static ArrayList<String> mList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private GoodsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new GoodsAdapter();
        mRecyclerView.setAdapter(mAdapter);

        checkUrl();
    }


    public void checkUrl() {
        Intent intent = getIntent();
        if (intent != null) {
            String action = intent.getAction();
            String type = intent.getType();
            if (!TextUtils.isEmpty(action) && !TextUtils.isEmpty(type)) {
                if (action.equals(Intent.ACTION_SEND) && type.equals("text/plain")) {
                    String str = intent.getStringExtra(Intent.EXTRA_TEXT);
                    Log.e(TAG, "分享过来的内容：" + str);
                    mList.add(str);
                    mAdapter.addList(mList);

                    /*Pattern pattern = Pattern.compile("(http://|ftp://|https://|www){0,1}[^\u4e00-\u9fa5\\s]*?\\.(com|net|cn|me|tw|fr)[^\u4e00-\u9fa5\\s]*");
                    Matcher matcher = null;
                    if (pattern != null) {
                        matcher = pattern.matcher(str);
                    }
                    if (matcher != null) {
                        String url = "";
                        while (matcher.find()) {
                            url = matcher.group(0);
                        }
                        Log.e(TAG, "正则获取分享过来的链接: " + url);
                    }*/
                }
            }
        }
    }


    @Override
    protected void onRestart() {
        super.onRestart();

        Log.e(TAG, "onRestart: ");

        checkUrl();
    }
}
