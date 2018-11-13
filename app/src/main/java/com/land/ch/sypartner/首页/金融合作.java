package com.land.ch.sypartner.首页;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.liquorslib.view.ToolbarView;
import com.land.ch.sypartner.R;
import com.yyydjk.library.BannerLayout;

import ch.chtool.base.BaseActivity;

public class 金融合作 extends BaseActivity {

    private ToolbarView m金融合作tbv;
    private BannerLayout mBanner;
    private RecyclerView mRecyclerView;


    @Override
    public int initLayout() {
        return R.layout.activity_jinronghezuo;
    }

    @Override
    public void initView() {
        m金融合作tbv = (ToolbarView) findViewById(R.id.金融合作tbv);
        m金融合作tbv.setOnViewClickListener(new ToolbarView.OnRightClickListener() {
            @Override
            public void onClick() {

            }
        });
        m金融合作tbv.setOnViewClickListener(new ToolbarView.OnLeftClickListener() {
            @Override
            public void onClick() {

            }
        });
        mBanner = (BannerLayout) findViewById(R.id.banner);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
    }

    @Override
    public void initData() {

    }


}
