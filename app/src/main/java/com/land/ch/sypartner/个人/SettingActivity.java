package com.land.ch.sypartner.个人;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liquorslib.view.LTextView;
import com.land.ch.sypartner.R;
import com.land.ch.sypartner.activity.WebViewActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import ch.chtool.base.BaseActivity;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mLayoutTitleBack;
    private TextView mLayoutTitleText;
    private AutoRelativeLayout mLayoutTitleRlc;
    private LTextView m个人资料修改LTV;
    private LTextView m收货地址LTV;
    private LTextView m修改密码LTV;
    private LTextView m常见问题LTV;
    private LTextView m关于我们LTV;
    private LTextView m客服电话LTV;
    private Button m退出登录btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    @Override
    public int initLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        mLayoutTitleBack = (ImageView) findViewById(R.id.layout_title_back);
        mLayoutTitleBack.setOnClickListener(this);
        mLayoutTitleText = (TextView) findViewById(R.id.layout_title_text);
        mLayoutTitleText.setText("设置");
        mLayoutTitleRlc = (AutoRelativeLayout) findViewById(R.id.layout_title_rlc);
        mLayoutTitleRlc.setOnClickListener(this);
        m个人资料修改LTV = (LTextView) findViewById(R.id.个人资料修改LTV);
        m个人资料修改LTV.setOnClickListener(this);
        m收货地址LTV = (LTextView) findViewById(R.id.收货地址LTV);
        m收货地址LTV.setOnClickListener(this);
        m修改密码LTV = (LTextView) findViewById(R.id.修改密码LTV);
        m修改密码LTV.setOnClickListener(this);
        m常见问题LTV = (LTextView) findViewById(R.id.常见问题LTV);
        m常见问题LTV.setOnClickListener(this);
        m关于我们LTV = (LTextView) findViewById(R.id.关于我们LTV);
        m关于我们LTV.setOnClickListener(this);
        m客服电话LTV = (LTextView) findViewById(R.id.客服电话LTV);
        m客服电话LTV.setOnClickListener(this);
        m退出登录btn = (Button) findViewById(R.id.退出登录btn);
        m退出登录btn.setOnClickListener(this);
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
            case R.id.layout_title_rlc:
                break;
            case R.id.个人资料修改LTV:
                startActivity(new Intent(SettingActivity.this, 编辑地址.class));
                break;
            case R.id.收货地址LTV:
                startActivity(new Intent(SettingActivity.this, 收货地址.class));
                break;
            case R.id.修改密码LTV:
                startActivity(new Intent(SettingActivity.this, 修改密码.class));
                break;
            case R.id.常见问题LTV:
                Intent toQues = new Intent(SettingActivity.this, WebViewActivity.class);
                toQues.putExtra("title_str", "常见问题");
                toQues.putExtra("web_url", "");
                startActivity(toQues);
                break;
            case R.id.关于我们LTV:
                Intent toAbout = new Intent(SettingActivity.this, WebViewActivity.class);
                toAbout.putExtra("title_str", "关于我们");
                toAbout.putExtra("web_url", "");
                startActivity(toAbout);
                break;
            case R.id.客服电话LTV:
                showNormalDialog();
                break;
            case R.id.退出登录btn:
                break;
        }
    }

    private void showNormalDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle("确认拨打电话?");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:4006060279"));
                        startActivity(intent);
                    }
                });
        normalDialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
        // 显示
        normalDialog.show();
    }
}
