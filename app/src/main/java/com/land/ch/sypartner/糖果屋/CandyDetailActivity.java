package com.land.ch.sypartner.糖果屋;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.land.ch.sypartner.R;
import com.yyydjk.library.BannerLayout;
import com.zhy.autolayout.AutoRelativeLayout;

public class CandyDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mLayoutTitleBack;
    private TextView mLayoutTitleText;
    private AutoRelativeLayout mLayoutTitleRlc;
    private BannerLayout mBanner;
    /**
     * 商品名称
     */
    private TextView m商品名称tv;
    /**
     * 8000糖果
     */
    private TextView m价格tv;
    /**
     * 截止日期: 10-30
     */
    private TextView m截止日期tv;
    private String title = "";
    private Button m点击兑换btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candy_detail);
        initView();
        Intent intent = getIntent();
        title = intent.getStringExtra("title_str");
    }

    private void initView() {
        mLayoutTitleBack = (ImageView) findViewById(R.id.layout_title_back);
        mLayoutTitleBack.setOnClickListener(this);
        mLayoutTitleText = (TextView) findViewById(R.id.layout_title_text);
        mLayoutTitleText.setText(title);
        mLayoutTitleRlc = (AutoRelativeLayout) findViewById(R.id.layout_title_rlc);
        mBanner = (BannerLayout) findViewById(R.id.banner);
        m商品名称tv = (TextView) findViewById(R.id.商品名称tv);
        m价格tv = (TextView) findViewById(R.id.价格tv);
        m截止日期tv = (TextView) findViewById(R.id.截止日期tv);
        m点击兑换btn = (Button) findViewById(R.id.点击兑换btn);
        m点击兑换btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_title_back:
                finish();
                break;
            case R.id.点击兑换btn:
                break;
        }
    }
}
