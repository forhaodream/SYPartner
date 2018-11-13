package com.land.ch.sypartner.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.land.ch.sypartner.R;
import com.yyydjk.library.BannerLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import ch.chtool.base.BaseActivity;

public class 公共分类界面 extends BaseActivity implements View.OnClickListener {

    private ImageView mLayoutTitleBack;
    private TextView mLayoutTitleText;
    private AutoRelativeLayout mLayoutTitleRlc;
    private BannerLayout mBanner;
    private RecyclerView m筛选区rlc;
    private RecyclerView m房源展示rlc;
    private TextView mTitleText;
    private String title = "";

    @Override
    public int initLayout() {
        return R.layout.activity_new_house_detial;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title_str");
        mLayoutTitleBack = (ImageView) findViewById(R.id.layout_title_back);
        mLayoutTitleBack.setOnClickListener(this);
        mLayoutTitleText = (TextView) findViewById(R.id.layout_title_text);
        mLayoutTitleRlc = (AutoRelativeLayout) findViewById(R.id.layout_title_rlc);
        mBanner = (BannerLayout) findViewById(R.id.banner);
        m筛选区rlc = (RecyclerView) findViewById(R.id.筛选区rlc);
        m房源展示rlc = (RecyclerView) findViewById(R.id.房源展示rlc);
        mLayoutTitleText.setOnClickListener(this);
        mLayoutTitleRlc.setOnClickListener(this);
        mBanner.setOnClickListener(this);
        m筛选区rlc.setOnClickListener(this);
        mTitleText = (TextView) findViewById(R.id.title_text);
        mTitleText.setText(title);
        mTitleText.setOnClickListener(this);
        m房源展示rlc.setOnClickListener(this);
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
            case R.id.layout_title_text:
                break;
            case R.id.layout_title_rlc:
                break;
            case R.id.banner:
                break;
            case R.id.筛选区rlc:
                break;
            case R.id.title_text:
                break;
            case R.id.房源展示rlc:
                break;
        }
    }
}
