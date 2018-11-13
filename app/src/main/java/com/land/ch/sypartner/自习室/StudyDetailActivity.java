package com.land.ch.sypartner.自习室;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.land.ch.sypartner.R;
import com.zhy.autolayout.AutoRelativeLayout;

public class StudyDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mLayoutTitleBack;
    private TextView mLayoutTitleText;
    private AutoRelativeLayout mLayoutTitleRlc;
    private ImageView mActivityStudyDetailImg;
    private TextView mActivityStudyDetailInclude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_detail);
        initView();
    }

    private void initView() {
        mLayoutTitleBack = (ImageView) findViewById(R.id.layout_title_back);
        mLayoutTitleBack.setOnClickListener(this);
        mLayoutTitleText = (TextView) findViewById(R.id.layout_title_text);
        mLayoutTitleRlc = (AutoRelativeLayout) findViewById(R.id.layout_title_rlc);
        mActivityStudyDetailInclude = (TextView) findViewById(R.id.activity_study_detail_include);
     //   mDetailPlayer = findViewById(R.id.detail_player);
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
