package com.land.ch.sypartner.个人;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liquorslib.view.LEditSingleView;
import com.land.ch.sypartner.R;
import com.zhy.autolayout.AutoRelativeLayout;

import ch.chtool.base.BaseActivity;

public class 修改个人资料 extends BaseActivity implements View.OnClickListener {

    private ImageView mLayoutTitleBack;
    private TextView mLayoutTitleCenter;
    private TextView mLayoutTitleRight;
    private AutoRelativeLayout mLayoutTitleRlc;
    private LEditSingleView m昵称LEV;
    private LEditSingleView m性别LEV;
    private LEditSingleView m手机号LEV;
    private LEditSingleView m账号类型LEV;


    @Override
    public int initLayout() {
        return R.layout.activity_xiugaiziliao;
    }


    @Override
    public void initView() {
        mLayoutTitleBack = (ImageView) findViewById(R.id.layout_title_back);
        mLayoutTitleBack.setOnClickListener(this);
        mLayoutTitleCenter = (TextView) findViewById(R.id.layout_title_center);
        mLayoutTitleRight = (TextView) findViewById(R.id.layout_title_right);
        mLayoutTitleRight.setOnClickListener(this);
        mLayoutTitleRight.setText("确定");
        mLayoutTitleRlc = (AutoRelativeLayout) findViewById(R.id.layout_title_rlc);
        mLayoutTitleRlc.setOnClickListener(this);
        m昵称LEV = (LEditSingleView) findViewById(R.id.昵称LEV);
        m性别LEV = (LEditSingleView) findViewById(R.id.性别LEV);
        m手机号LEV = (LEditSingleView) findViewById(R.id.手机号LEV);
        m账号类型LEV = (LEditSingleView) findViewById(R.id.账号类型LEV);
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
            case R.id.layout_title_rlc:
                break;
        }
    }
}
