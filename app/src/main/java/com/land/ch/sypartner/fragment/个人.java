package com.land.ch.sypartner.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.land.ch.sypartner.R;
import com.land.ch.sypartner.个人.SettingActivity;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zhy.autolayout.AutoRelativeLayout;

import ch.chtool.base.BaseFragment;

/**
 * Created by CH
 * on 2018/11/7 14:52
 */
public class 个人 extends BaseFragment implements View.OnClickListener {
    private View mView;
    private View view;
    private RoundedImageView mFragmentMineHead;
    private TextView mFragmentMineName;
    private TextView mFragmentMinePhone;
    private ImageView mFragmentMineSetting;
    private TextView m战旗数tv;
    private TextView m糖果数tv;
    private AutoRelativeLayout m会员充值rlc;
    private AutoRelativeLayout m糖果充值rlc;
    private RecyclerView mOrderRv;
    private RecyclerView mKindRv;
    private TextView mFragmentMineMore;

    @Override
    protected int setView() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view) {

        mFragmentMineHead = (RoundedImageView) view.findViewById(R.id.fragment_mine_head);
        mFragmentMineHead.setOnClickListener(this);
        mFragmentMineName = (TextView) view.findViewById(R.id.fragment_mine_name);
        mFragmentMinePhone = (TextView) view.findViewById(R.id.fragment_mine_phone);
        mFragmentMineSetting = (ImageView) view.findViewById(R.id.fragment_mine_setting);
        mFragmentMineSetting.setOnClickListener(this);
        m战旗数tv = (TextView) view.findViewById(R.id.战旗数tv);
        m糖果数tv = (TextView) view.findViewById(R.id.糖果数tv);
        m会员充值rlc = (AutoRelativeLayout) view.findViewById(R.id.会员充值rlc);
        m会员充值rlc.setOnClickListener(this);
        m糖果充值rlc = (AutoRelativeLayout) view.findViewById(R.id.糖果充值rlc);
        m糖果充值rlc.setOnClickListener(this);
        mOrderRv = (RecyclerView) view.findViewById(R.id.order_rv);
        mKindRv = (RecyclerView) view.findViewById(R.id.kind_rv);
        mFragmentMineMore = (TextView) view.findViewById(R.id.fragment_mine_more);
        mFragmentMineMore.setOnClickListener(this);
    }

    @Override
    protected void initData(Bundle bundle) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_mine_head:
                break;
            case R.id.fragment_mine_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            case R.id.会员充值rlc:
                break;
            case R.id.糖果充值rlc:
                break;
            case R.id.fragment_mine_more:
                break;
        }
    }
}
