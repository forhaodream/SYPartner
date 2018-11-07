package com.land.ch.sypartner.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.liquorslib.view.ToolbarView;
import com.land.ch.sypartner.R;

import ch.chtool.base.BaseFragment;
import ch.chtool.utils.LastItem;

/**
 * Created by CH
 * on 2018/11/7 14:49
 */
public class 自习室 extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private View view;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected int setView() {
        return R.layout.fragment_study_room;
    }

    @Override
    protected void initView(View view) {
        mRecyclerView = view.findViewById(R.id.RecyclerView);
        mSwipeRefreshLayout = view.findViewById(R.id.SwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    protected void initData(Bundle bundle) {


    }


    @Override
    public void onRefresh() {

    }
}
