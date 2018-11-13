package com.land.ch.sypartner.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.land.ch.sypartner.R;
import com.zhy.autolayout.AutoRelativeLayout;

import ch.chtool.base.BaseFragment;

/**
 * Created by CH
 * on 2018/11/7 14:45
 */
public class 糖果屋 extends BaseFragment implements View.OnClickListener {
    private View view;
    /**
     * 糖果屋
     */
    private TextView mLayoutTitleText;
    /**
     * 使用说明
     */
    private TextView m使用说明text;
    private AutoRelativeLayout mLayoutTitleRlc;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected int setView() {
        return R.layout.fragment_candy;
    }

    @Override
    protected void initView(View view) {

        mLayoutTitleText = (TextView) view.findViewById(R.id.layout_title_text);
        m使用说明text = (TextView) view.findViewById(R.id.使用说明text);
        m使用说明text.setOnClickListener(this);
        mLayoutTitleRlc = (AutoRelativeLayout) view.findViewById(R.id.layout_title_rlc);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.SwipeRefreshLayout);
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.使用说明text:
                break;
        }
    }
}
