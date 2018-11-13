package com.land.ch.sypartner.个人;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liquorslib.view.LEditSingleView;
import com.land.ch.sypartner.R;
import com.lljjcoder.citypickerview.widget.CityPicker;
import com.zhy.autolayout.AutoRelativeLayout;

public class 编辑地址 extends AppCompatActivity implements View.OnClickListener {

    private ImageView mLayoutTitleBack;
    private TextView mLayoutTitleCenter;
    private TextView mLayoutTitleRight;
    private AutoRelativeLayout mLayoutTitleRlc;
    private LEditSingleView m收货人LEV;
    private LEditSingleView m电话LEV;
    private LEditSingleView m收货地址LEV;
    private LEditSingleView m详细地址LEV;
    private Button m保存btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bianjidizhi);
        initView();
    }

    private void initView() {
        mLayoutTitleBack = findViewById(R.id.layout_title_back);
        mLayoutTitleBack.setOnClickListener(this);
        mLayoutTitleCenter = findViewById(R.id.layout_title_center);
        mLayoutTitleCenter.setText("编辑地址");
        mLayoutTitleRight = findViewById(R.id.layout_title_right);
        mLayoutTitleRight.setText("删除");
        mLayoutTitleRight.setOnClickListener(this);
        mLayoutTitleRlc = findViewById(R.id.layout_title_rlc);
        m收货人LEV = findViewById(R.id.收货人LEV);
        m电话LEV = findViewById(R.id.电话LEV);
        m收货地址LEV = findViewById(R.id.收货地址LEV);
        m收货地址LEV.setOnClickListener(this);
        m详细地址LEV = findViewById(R.id.详细地址LEV);
        m保存btn = findViewById(R.id.保存btn);
        m保存btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_title_back:
                finish();
                break;
            case R.id.收货地址LEV:
                initCity();
                break;
            case R.id.layout_title_right:
                // 走接口
                finish();
                break;
            case R.id.保存btn:
                break;

        }
    }

    private void initCity() {
        CityPicker cityPicker = new CityPicker.Builder(this)
                .textSize(14)
                .title("地址选择")
                .titleBackgroundColor("#FFFFFF")
                .confirTextColor("#696969")
                .cancelTextColor("#696969")
                .province("辽宁省")
                .city("沈阳市")
                .district("沈河区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(false)
                .build();
        cityPicker.show();
        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省份
                String province = citySelected[0];
                //城市
                String city = citySelected[1];
                //区县（如果设定了两级联动，那么该项返回空）
                String district = citySelected[2];
                //邮编
                String code = citySelected[3];
                //为TextView赋值
                m收货地址LEV.setValue(province.trim() + "-" + city.trim() + "-" + district.trim());
            }
        });
    }


}
