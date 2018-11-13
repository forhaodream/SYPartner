package com.land.ch.sypartner.首页;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.liquorslib.view.ToolbarView;
import com.land.ch.sypartner.R;
import com.yyydjk.library.BannerLayout;

public class 行业招聘 extends AppCompatActivity {

    private ToolbarView m行业招聘tbv;
    private BannerLayout mBanner;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangyezhaopin);
        initView();
    }

    private void initView() {
        m行业招聘tbv = (ToolbarView) findViewById(R.id.行业招聘tbv);
        m行业招聘tbv.setOnViewClickListener(new ToolbarView.OnLeftClickListener() {
            @Override
            public void onClick() {
                finish();
            }
        });
        mBanner = (BannerLayout) findViewById(R.id.banner);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
    }
}
