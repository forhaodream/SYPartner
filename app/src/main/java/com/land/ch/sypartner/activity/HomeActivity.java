package com.land.ch.sypartner.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.land.ch.sypartner.R;
import com.land.ch.sypartner.fragment.个人;
import com.land.ch.sypartner.fragment.战队;
import com.land.ch.sypartner.fragment.糖果屋;
import com.land.ch.sypartner.fragment.自习室;
import com.land.ch.sypartner.fragment.首页;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "HomeActivity";
    private FragmentTabHost mTabHost;
    private LinearLayout homell, carll, countryll, chatll, minell;
    //初始化标签数组
    String tabs[] = {"首页", "战队", "自习室", "糖果屋", "个人"};
    //初始化界面数组
    Class cls[] = {首页.class, 战队.class, 自习室.class, 糖果屋.class, 个人.class};
    private ImageView 首页Img, 战队Img, 自习室Img, 糖果屋Img, 个人Img;
    private TextView 首页Tv, 战队Tv, 自习室Tv, 糖果屋Tv, 个人Tv;
    private int userId;
    //清除sp
    private SharedPreferences npt;
    private boolean isExit;
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }

    };
    private SharedPreferences readInfo;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        List<String> permissionList = new ArrayList<>();
//
//        if (ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.READ_PHONE_STATE) !=
//                PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.READ_PHONE_STATE);
//        }
//        if (ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
//                PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        }
//        if (ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) !=
//                PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
//        }
//        if (ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
//                PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
//        }
//        if (!permissionList.isEmpty()) {
//            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
//            ActivityCompat.requestPermissions(HomeActivity.this, permissions, 1);
//        } else {
//            Log.d("homeA", "已授权");
//        }
        npt = getSharedPreferences("user_npt", MODE_PRIVATE);

        mHandler = new Handler();
        addView();
        Intent intent = getIntent();
        int index = intent.getIntExtra("huan", -1);
        readInfo = getSharedPreferences("save_update", Context.MODE_PRIVATE);
        editor = readInfo.edit();
        Log.d("home_index", String.valueOf(index));
        if (String.valueOf(index).equals("1")) {
            setLayoutButton1();
            mTabHost.setCurrentTabByTag(tabs[0]);
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isAvailable()) {
            Toast.makeText(this, "网络已断开,请检查网络", Toast.LENGTH_SHORT).show();
        } else {
            Log.d("tag", "网络已连接");
        }


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.fontScale != 1)//非默认值
            getResources();
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if (res.getConfiguration().fontScale != 1) {//非默认值
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();//设置默认
            res.updateConfiguration(newConfig, res.getDisplayMetrics());
        }
        return res;
    }



    private void addView() {

        //实例化控件
        this.首页Img = findViewById(R.id.home_image);
        this.战队Img = findViewById(R.id.car_image);
        this.自习室Img = findViewById(R.id.countryside_image);
        this.糖果屋Img = findViewById(R.id.chat_image);
        this.个人Img = findViewById(R.id.mine_image);
        this.首页Tv = findViewById(R.id.home_text);
        this.战队Tv = findViewById(R.id.car_text);
        this.自习室Tv = findViewById(R.id.countryside_text);
        this.糖果屋Tv = findViewById(R.id.chat_text);
        this.个人Tv = findViewById(R.id.mine_text);
        mTabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabHost.setup(HomeActivity.this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.getTabWidget().setVisibility(View.GONE);//隐藏顶部切换菜单
        for (int i = 0; i < tabs.length; i++) {
            //向 FragmentTabHost 添加标签以及 Fragment 界面
            mTabHost.addTab(mTabHost.newTabSpec(tabs[i]).setIndicator(tabs[i]),
                    cls[i], null);

        }
        npt = getSharedPreferences("user_npt", MODE_PRIVATE);

        homell = findViewById(R.id.home_ll);
        carll = findViewById(R.id.car_ll);
        countryll = findViewById(R.id.countryside_ll);
        chatll = findViewById(R.id.chat_ll);
        minell = findViewById(R.id.mine_ll);

        //设置监听事件
        this.homell.setOnClickListener(this);
        this.carll.setOnClickListener(this);
        this.countryll.setOnClickListener(this);
        this.chatll.setOnClickListener(this);
        this.minell.setOnClickListener(this);

        //设置默认选中标签
        mTabHost.setCurrentTabByTag(tabs[0]);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_ll:
                setLayoutButton0();
                mTabHost.setCurrentTabByTag(tabs[0]);
                break;
            case R.id.car_ll:
                setLayoutButton1();
                mTabHost.setCurrentTabByTag(tabs[1]);
                break;
            case R.id.countryside_ll:
                setLayoutButton2();
                mTabHost.setCurrentTabByTag(tabs[2]);
                break;
            case R.id.chat_ll:
                setlayoutbutton3();
                mTabHost.setCurrentTabByTag(tabs[3]);
                break;
            case R.id.mine_ll:
                setlayoutbutton4();
                mTabHost.setCurrentTabByTag(tabs[4]);
                break;

        }
    }

    //设置点击切换标签字体颜色与背景图片的切换
    private void setLayoutButton0() {
        首页Img.setBackgroundResource(R.mipmap.ic_launcher);
        战队Img.setBackgroundResource(R.mipmap.ic_launcher);
        自习室Img.setBackgroundResource(R.mipmap.ic_launcher);
        糖果屋Img.setBackgroundResource(R.mipmap.ic_launcher);
        个人Img.setBackgroundResource(R.mipmap.ic_launcher);
        首页Tv.setTextColor(this.getResources().getColor(R.color.home_text_lv));
        战队Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        自习室Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        糖果屋Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        个人Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
    }

    private void setLayoutButton1() {
        首页Img.setBackgroundResource(R.mipmap.ic_launcher);
        战队Img.setBackgroundResource(R.mipmap.ic_launcher);
        自习室Img.setBackgroundResource(R.mipmap.ic_launcher);
        糖果屋Img.setBackgroundResource(R.mipmap.ic_launcher);
        个人Img.setBackgroundResource(R.mipmap.ic_launcher);
        首页Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        战队Tv.setTextColor(this.getResources().getColor(R.color.home_text_lv));
        自习室Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        糖果屋Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        个人Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
    }

    private void setLayoutButton2() {
        首页Img.setBackgroundResource(R.mipmap.ic_launcher);
        战队Img.setBackgroundResource(R.mipmap.ic_launcher);
        自习室Img.setBackgroundResource(R.mipmap.ic_launcher);
        糖果屋Img.setBackgroundResource(R.mipmap.ic_launcher);
        个人Img.setBackgroundResource(R.mipmap.ic_launcher);
        首页Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        战队Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        自习室Tv.setTextColor(this.getResources().getColor(R.color.home_text_lv));
        糖果屋Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        个人Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
    }

    private void setlayoutbutton3() {
        首页Img.setBackgroundResource(R.mipmap.ic_launcher);
        战队Img.setBackgroundResource(R.mipmap.ic_launcher);
        自习室Img.setBackgroundResource(R.mipmap.ic_launcher);
        糖果屋Img.setBackgroundResource(R.mipmap.ic_launcher);
        个人Img.setBackgroundResource(R.mipmap.ic_launcher);
        首页Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        战队Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        自习室Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        糖果屋Tv.setTextColor(this.getResources().getColor(R.color.home_text_lv));
        个人Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
    }

    private void setlayoutbutton4() {
        首页Img.setBackgroundResource(R.mipmap.ic_launcher);
        战队Img.setBackgroundResource(R.mipmap.ic_launcher);
        自习室Img.setBackgroundResource(R.mipmap.ic_launcher);
        糖果屋Img.setBackgroundResource(R.mipmap.ic_launcher);
        个人Img.setBackgroundResource(R.mipmap.ic_launcher);
        首页Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        战队Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        自习室Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        糖果屋Tv.setTextColor(this.getResources().getColor(R.color.home_text_hui));
        个人Tv.setTextColor(this.getResources().getColor(R.color.home_text_lv));
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            System.gc();

            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    public void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            editor.clear();
            editor.apply();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            System.exit(0);
        }
    }

}


