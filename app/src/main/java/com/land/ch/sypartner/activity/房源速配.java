package com.land.ch.sypartner.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.land.ch.sypartner.R;
import com.yyydjk.library.BannerLayout;
import com.zhy.autolayout.AutoRelativeLayout;

public class 房源速配 extends AppCompatActivity implements View.OnClickListener {

    private ImageView mLayoutTitleBack;
    private TextView mLayoutTitleText;
    private AutoRelativeLayout mLayoutTitleRlc;
    private BannerLayout mBanner;
    private ImageView m客配房img;
    private TextView m客配房tv;
    private ImageView m房配客img;
    private TextView m房配客tv;
    private TextView mTitleText;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fangyuansupei);
        initView();
    }

    private void initView() {
        mLayoutTitleBack = (ImageView) findViewById(R.id.layout_title_back);
        mLayoutTitleBack.setOnClickListener(this);
        mLayoutTitleText = (TextView) findViewById(R.id.layout_title_text);
        mLayoutTitleRlc = (AutoRelativeLayout) findViewById(R.id.layout_title_rlc);
        mBanner = (BannerLayout) findViewById(R.id.banner);
        m客配房img = (ImageView) findViewById(R.id.客配房img);
        m客配房img.setOnClickListener(this);
        m客配房tv = (TextView) findViewById(R.id.客配房tv);
        m客配房tv.setOnClickListener(this);
        m房配客img = (ImageView) findViewById(R.id.房配客img);
        m房配客img.setOnClickListener(this);
        m房配客tv = (TextView) findViewById(R.id.房配客tv);
        m房配客tv.setOnClickListener(this);
        mTitleText = (TextView) findViewById(R.id.title_text);
        mTitleText.setText("房源速配");
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_title_back:
                finish();
                break;
            case R.id.客配房img:
                break;
            case R.id.客配房tv:
                break;
            case R.id.房配客img:
                break;
            case R.id.房配客tv:
                break;
        }
    }
}
