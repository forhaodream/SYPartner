package com.land.ch.sypartner.首页;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.land.ch.sypartner.R;
import com.yyydjk.library.BannerLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import ch.chtool.base.BaseActivity;

public class 共享房源 extends BaseActivity implements View.OnClickListener {

    private ImageView mLayoutTitleBack;
    private TextView mLayoutTitleText;
    private AutoRelativeLayout mLayoutTitleRlc;
    private BannerLayout mBannerLayout;
    private Spinner m区域Sp;
    private TextView mTitleText;
    private RecyclerView mRecyclerView;

    @Override
    public int initLayout() {
        return R.layout.activity_share;
    }

    @Override
    public void initView() {
        mLayoutTitleBack = (ImageView) findViewById(R.id.layout_title_back);
        mLayoutTitleBack.setOnClickListener(this);
        mLayoutTitleText = (TextView) findViewById(R.id.layout_title_text);
        mLayoutTitleText.setText("共享房源");
        mLayoutTitleRlc = (AutoRelativeLayout) findViewById(R.id.layout_title_rlc);
        mBannerLayout = (BannerLayout) findViewById(R.id.BannerLayout);
        m区域Sp = (Spinner) findViewById(R.id.区域Sp);
        mTitleText = (TextView) findViewById(R.id.title_text);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
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
        }
    }
}
