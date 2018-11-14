package com.land.ch.sypartner.个人;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liquorslib.view.LEditSingleView;
import com.land.ch.sypartner.R;
import com.zhy.autolayout.AutoRelativeLayout;

public class 修改密码 extends AppCompatActivity implements View.OnClickListener {

    private ImageView mLayoutTitleBack;
    private TextView mLayoutTitleText;
    private AutoRelativeLayout mLayoutTitleRlc;
    private LEditSingleView m旧密码LEV;
    private LEditSingleView m新密码LEV;
    private LEditSingleView m确认密码LEV;
    /**
     * 保存
     */
    private Button m保存btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiugaimima);
        initView();
    }

    private void initView() {
        mLayoutTitleBack = findViewById(R.id.layout_title_back);
        mLayoutTitleBack.setOnClickListener(this);
        mLayoutTitleText = findViewById(R.id.layout_title_text);
        mLayoutTitleText.setText("修改密码");
        mLayoutTitleRlc = findViewById(R.id.layout_title_rlc);
        m旧密码LEV = findViewById(R.id.旧密码LEV);
        m新密码LEV = findViewById(R.id.新密码LEV);
        m确认密码LEV = findViewById(R.id.确认密码LEV);
        m保存btn = findViewById(R.id.保存btn);
        m保存btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_title_back:
                finish();
                break;
            case R.id.保存btn:
                break;
        }
    }
}
