package com.land.ch.sypartner.首页;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.land.ch.sypartner.R;
import com.zhy.autolayout.AutoRelativeLayout;

import ch.chtool.base.BaseActivity;

public class 学区房搜索 extends BaseActivity implements View.OnClickListener {

    private ImageView mLayoutTitleBack;
    private TextView mLayoutTitleText;
    private AutoRelativeLayout mLayoutTitleRlc;
    private Spinner m区域选择Sp;
    private Spinner m学级划分Sp;
    private Spinner m学校选择Sp;
    private Spinner m价格Sp;
    private Spinner m面积Sp;
    private Spinner m功能Sp;
    /**
     * 搜索
     */
    private Button m搜索btn;


    @Override
    public int initLayout() {
        return R.layout.activity_xuequfangsousuo;
    }

    @Override
    public void initView() {
        mLayoutTitleBack = (ImageView) findViewById(R.id.layout_title_back);
        mLayoutTitleBack.setOnClickListener(this);
        mLayoutTitleText = (TextView) findViewById(R.id.layout_title_text);
        mLayoutTitleText.setText("学区房");
        mLayoutTitleRlc = (AutoRelativeLayout) findViewById(R.id.layout_title_rlc);
        m区域选择Sp = (Spinner) findViewById(R.id.区域选择Sp);
        m学级划分Sp = (Spinner) findViewById(R.id.学级划分Sp);
        m学校选择Sp = (Spinner) findViewById(R.id.学校选择Sp);
        m价格Sp = (Spinner) findViewById(R.id.价格Sp);
        m面积Sp = (Spinner) findViewById(R.id.面积Sp);
        m功能Sp = (Spinner) findViewById(R.id.功能Sp);
        m搜索btn = (Button) findViewById(R.id.搜索btn);
        m搜索btn.setOnClickListener(this);
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
            case R.id.搜索btn:
                break;
        }
    }
}
