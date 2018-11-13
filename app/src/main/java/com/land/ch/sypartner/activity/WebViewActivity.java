package com.land.ch.sypartner.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.land.ch.sypartner.R;
import com.zhy.autolayout.AutoRelativeLayout;

/**
 * Created by CH
 * on 2018/11/13 13:41
 */
public class WebViewActivity extends Activity implements View.OnClickListener {
    private String title = "";
    private String webUrl = "";
    private ImageView mLayoutTitleBack;
    private TextView mLayoutTitleText;
    private AutoRelativeLayout mLayoutTitleRlc;
    private WebView mWebview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        initView();
        Intent intent = getIntent();
        title = intent.getStringExtra("title_str");
        webUrl = intent.getStringExtra("web_url");

    }

    private void initView() {
        mLayoutTitleBack = (ImageView) findViewById(R.id.layout_title_back);
        mLayoutTitleBack.setOnClickListener(this);
        mLayoutTitleText = (TextView) findViewById(R.id.layout_title_text);
        mLayoutTitleText.setText(title);
        mLayoutTitleRlc = (AutoRelativeLayout) findViewById(R.id.layout_title_rlc);
        mWebview = (WebView) findViewById(R.id.webview);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_title_back:
                finish();
                break;
        }
    }
}
