package com.land.ch.sypartner.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.land.ch.sypartner.R;
import com.yyydjk.library.BannerLayout;

import ch.chtool.base.BaseFragment;

/**
 * Created by CH
 * on 2018/11/7 14:00
 */
public class 首页 extends BaseFragment implements View.OnClickListener {
    private View view;
    private BannerLayout mBanner;
    private RecyclerView mRecyclerView;
    private ImageView m新房展示img;
    private ImageView m个人房源img;
    private ImageView m房源速配img;
    private ImageView m房源订阅img;
    private RecyclerView m列表rlc;

    @Override
    protected int setView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {

        mBanner = (BannerLayout) view.findViewById(R.id.banner);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        m新房展示img = (ImageView) view.findViewById(R.id.新房展示img);
        m新房展示img.setOnClickListener(this);
        m个人房源img = (ImageView) view.findViewById(R.id.个人房源img);
        m个人房源img.setOnClickListener(this);
        m房源速配img = (ImageView) view.findViewById(R.id.房源速配img);
        m房源速配img.setOnClickListener(this);
        m房源订阅img = (ImageView) view.findViewById(R.id.房源订阅img);
        m房源订阅img.setOnClickListener(this);
        m列表rlc = (RecyclerView) view.findViewById(R.id.列表rlc);
    }

    @Override
    protected void initData(Bundle bundle) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.新房展示img:
                break;
            case R.id.个人房源img:
                break;
            case R.id.房源速配img:
                break;
            case R.id.房源订阅img:
                break;
        }
    }
}
