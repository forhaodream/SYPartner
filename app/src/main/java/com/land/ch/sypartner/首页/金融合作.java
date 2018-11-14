package com.land.ch.sypartner.首页;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.land.ch.sypartner.R;
import com.yyydjk.library.BannerLayout;

import ch.chtool.base.BaseActivity;

public class 金融合作 extends BaseActivity implements View.OnClickListener {

    private BannerLayout mBanner;
    private RecyclerView mRecyclerView;
    private ImageView mLayoutTitleBack;
    private TextView mLayoutTitleRight;
    private TextView mLayoutTitleCenter;


    @Override
    public int initLayout() {
        return R.layout.activity_jinronghezuo;
    }

    @Override
    public void initView() {
        mBanner = (BannerLayout) findViewById(R.id.banner);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mLayoutTitleBack = findViewById(R.id.layout_title_back);
        mLayoutTitleBack.setOnClickListener(this);
        mLayoutTitleRight = findViewById(R.id.layout_title_right);
        mLayoutTitleRight.setOnClickListener(this);
        mLayoutTitleRight.setText("+");
        mLayoutTitleRight.setTextSize(22);
        mLayoutTitleCenter = findViewById(R.id.layout_title_center);
        mLayoutTitleCenter.setText("金融合作");
    }

    @Override
    public void initData() {

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
