package com.land.ch.sypartner.首页;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.land.ch.sypartner.R;
import com.yyydjk.library.BannerLayout;

public class 行业招聘 extends AppCompatActivity implements View.OnClickListener {

    private BannerLayout mBanner;
    private RecyclerView mRecyclerView;
    private ImageView mLayoutTitleBack;
    private TextView mLayoutTitleRight;
    private TextView mLayoutTitleCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangyezhaopin);
        initView();
    }

    private void initView() {
        mBanner = (BannerLayout) findViewById(R.id.banner);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mLayoutTitleBack = findViewById(R.id.layout_title_back);
        mLayoutTitleBack.setOnClickListener(this);
        mLayoutTitleRight = findViewById(R.id.layout_title_right);
        mLayoutTitleRight.setOnClickListener(this);
        mLayoutTitleRight.setText("");
        mLayoutTitleCenter = findViewById(R.id.layout_title_center);
        mLayoutTitleCenter.setText("行业招聘");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_title_back:
                finish();
                break;
            case R.id.layout_title_right:
                break;
        }
    }
}
