package com.land.ch.sypartner.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.land.ch.sypartner.R;
import com.land.ch.sypartner.activity.公共分类界面;
import com.land.ch.sypartner.bean.HomeTypeBean;
import com.land.ch.sypartner.首页.共享房源;
import com.land.ch.sypartner.首页.学区房搜索;
import com.land.ch.sypartner.首页.行业招聘;
import com.land.ch.sypartner.首页.金融合作;
import com.yyydjk.library.BannerLayout;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

import ch.chtool.base.BaseFragment;
import ch.chtool.utils.RecyclerAdapter;
import ch.chtool.utils.RecyclerViewHolder;

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
    private List<HomeTypeBean> mHomeTypes;
    private int typeImg[] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private String typeTitle[] = {"学区房搜索", "共享房源", "地铁房搜索", "金融合作", "行业招聘"};


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
        initRecyclerView();
    }

    private void initRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 5);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mHomeTypes = new ArrayList<>();
        for (int i = 0; i < typeImg.length; i++) {
            mHomeTypes.add(new HomeTypeBean(typeTitle[i], typeImg[i]));
        }
        RecyclerAdapter recycleAdapter = new RecyclerAdapter<HomeTypeBean>(getActivity(), R.layout.item_home_type, mHomeTypes) {
            @Override
            public void convert(RecyclerViewHolder holder, final HomeTypeBean itemData, final int position) {
                AutoLinearLayout autoLinearLayout = holder.getView(R.id.type_ll);
                ImageView imageView = holder.getView(R.id.item_mine_type_img);
                TextView textView = holder.getView(R.id.item_mine_type_text);
                autoLinearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (position == 0) {
                            startActivity(new Intent(getActivity(), 学区房搜索.class));
                        } else if (position == 1) {
                            startActivity(new Intent(getActivity(), 共享房源.class));
                        } else if (position == 2) {
                            Intent intent = new Intent(getActivity(), 公共分类界面.class);
                            intent.putExtra("title_str", "地铁房搜索");
                            startActivity(intent);
                        } else if (position == 3) {
                            startActivity(new Intent(getActivity(), 金融合作.class));
                        } else if (position == 4) {
                            startActivity(new Intent(getActivity(), 行业招聘.class));
                        }
                    }
                });
                imageView.setImageResource(itemData.getImg());
                textView.setText(itemData.getTitle());
            }
        };
        mRecyclerView.setAdapter(recycleAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.新房展示img:
                Intent intent = new Intent(getActivity(), 公共分类界面.class);
                intent.putExtra("title_str", "新房展示");
                startActivity(intent);
                break;
            case R.id.个人房源img:
                Intent intent1 = new Intent(getActivity(), 公共分类界面.class);
                intent1.putExtra("title_str", "个人房源");
                startActivity(intent1);
                break;
            case R.id.房源速配img:
                Intent intent2 = new Intent(getActivity(), 公共分类界面.class);
                intent2.putExtra("title_str", "房源速配");
                startActivity(intent2);
                break;
            case R.id.房源订阅img:
                break;
        }
    }
}
