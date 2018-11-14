package com.land.ch.sypartner.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.land.ch.sypartner.R;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * Created by CH
 * on 2018/9/12 08:49
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private ImageView mActivityLoginLogo;
    private EditText mActivityLoginUserEd;
    // 微信登录
    private static final String APP_ID = "wxdcf6fdcfc75f0a13";
    private IWXAPI api;
    private EditText mActivityLoginPsdEd;
    private TextView wxLogin, qqLogin;
    private TextView mActivityLoginSend;
    private AutoLinearLayout mActivityLoginLinear;
    private TimeCount time;
    private Button mActivityLoginBtn;
    private AutoLinearLayout mActivityLogoOutLoginLinear;
    private Handler mHandler;
    private boolean isExit;
    private String openid = "";
    private String nickname = "";
    private String headimgurl = "";
    /**
     * 立即注册
     */
    private TextView m立即注册tv;
    /**
     * 忘记密码?
     */
    private TextView m忘记密码tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_login);
        mHandler = new Handler();
        api = WXAPIFactory.createWXAPI(this, APP_ID, true);
        api.registerApp(APP_ID);
        // Tencent类是SDK的主要实现类，开发者可通过Tencent类访问腾讯开放的OpenAPI
        // 其中APP_ID是分配给第三方应用的appid，类型为String
        initView();
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isAvailable()) {
            Toast.makeText(this, "网络已断开,请检查网络", Toast.LENGTH_LONG).show();
        } else {
            Log.d("tag", "网络已连接");
        }
        time = new TimeCount(60000, 1000);


    }

    private void initView() {
        mActivityLoginLogo = (ImageView) findViewById(R.id.activity_login_logo);
        mActivityLoginUserEd = (EditText) findViewById(R.id.activity_login_user_ed);
        mActivityLoginUserEd.setInputType(EditorInfo.TYPE_CLASS_PHONE);
        mActivityLoginPsdEd = (EditText) findViewById(R.id.activity_login_psd_ed);
        mActivityLoginPsdEd.setInputType(EditorInfo.TYPE_CLASS_PHONE);

        mActivityLoginLinear = (AutoLinearLayout) findViewById(R.id.activity_login_linear);
        mActivityLoginLinear.setOnClickListener(this);
        mActivityLoginBtn = (Button) findViewById(R.id.activity_login_btn);
        mActivityLoginBtn.setOnClickListener(this);
        mActivityLogoOutLoginLinear = (AutoLinearLayout) findViewById(R.id.activity_logo_out_login_linear);
        mActivityLogoOutLoginLinear.setOnClickListener(this);
        wxLogin = findViewById(R.id.activity_logo_wx);
        wxLogin.setOnClickListener(this);
        qqLogin = findViewById(R.id.activity_logo_qq);
        qqLogin.setOnClickListener(this);
        m立即注册tv = findViewById(R.id.立即注册tv);
        m立即注册tv.setOnClickListener(this);
        m忘记密码tv = findViewById(R.id.忘记密码tv);
        m忘记密码tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.activity_logo_wx:
                if (!api.isWXAppInstalled()) {
                    Toast.makeText(this, "请安装微信", Toast.LENGTH_SHORT).show();
                } else {
                    final SendAuth.Req req = new SendAuth.Req();
                    req.scope = "snsapi_userinfo";
                    req.state = "wechat_sdk_demo_test";
                    api.sendReq(req);
                }
                break;
            case R.id.activity_logo_qq:
//                mTencent = Tencent.createInstance("101501411", getApplicationContext());
//                mTencent.login(LoginActivity.this, "all", new BaseUiListener());

                break;
            case R.id.activity_login_btn:
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
//                if (!TextUtils.isEmpty(mActivityLoginUserEd.getText()) && !TextUtils.isEmpty(mActivityLoginPsdEd.getText())) {
//                } else {
//                    Toast.makeText(this, "请填写手机号/密码", Toast.LENGTH_SHORT).show();
//                }
                break;
            case R.id.立即注册tv:
                break;
            case R.id.忘记密码tv:
                break;
        }
    }


//    private class BaseUiListener implements IUiListener {
//
//        //这个类需要实现三个方法 onComplete（）：登录成功需要做的操作写在这里
//        public void onComplete(Object response) {       //登录成功
//            // TODO Auto-generated method stub
//            Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
//            try {
//                //获得的数据是JSON格式的，获得你想获得的内容
//                //如果你不知道你能获得什么，看一下下面的LOG
//                Log.i("textShow", "-------------" + response.toString());
//                String openidString = ((JSONObject) response).getString("openid");
//                mTencent.setOpenId(openidString);
//                mTencent.setAccessToken(((JSONObject) response).getString("access_token"), ((JSONObject) response).getString("expires_in"));
//                openid = openidString;
//                Log.i("textShow", "-------------" + openidString);
//            } catch (JSONException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            QQToken qqToken = mTencent.getQQToken();
//            UserInfo info = new UserInfo(getApplicationContext(), qqToken);
//
//            info.getUserInfo(new IUiListener() {
//                @Override
//                public void onComplete(Object o) {
//                    //用户信息获取到了
//                    try {
//                        Log.i("textShow", ((JSONObject) o).getString("nickname"));
//                        Log.i("textShow", ((JSONObject) o).getString("gender"));
//                        Log.i("textShow", ((JSONObject) o).getString("figureurl_qq_2"));
//                        Log.i("textShow", o.toString());
//                        nickname = ((JSONObject) o).getString("nickname");
//                        headimgurl = ((JSONObject) o).getString("figureurl_qq_2");
//                        qqLogin();
//                    } catch (JSONException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//
//                @Override
//                public void onError(UiError uiError) {
//                    Log.i("textShow", "onError");
//                }
//
//                @Override
//                public void onCancel() {
//                    Log.i("textShow", "onCancel");
//                }
//            });
//        }
//
//        @Override
//        public void onError(UiError uiError) {      //登录错误
//            Toast.makeText(getApplicationContext(), "onError", Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onCancel() {            //取消登录
//            Toast.makeText(getApplicationContext(), "onCancel", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        Tencent.onActivityResultData(requestCode, resultCode, data, new BaseUiListener());
//
//        if (requestCode == Constants.REQUEST_API) {
//            if (resultCode == Constants.REQUEST_LOGIN) {
//                Tencent.handleResultData(data, new BaseUiListener());
//            }
//        }
//
//    }

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            //  mYZMBtn.setBackgroundColor(Color.parseColor("#60a0fa"));
            mActivityLoginSend.setClickable(false);
            mActivityLoginSend.setText(millisUntilFinished / 1000 + "秒后重发");
        }

        @Override
        public void onFinish() {
            mActivityLoginSend.setText("重新获取验证码");
            mActivityLoginSend.setClickable(true);
            // mYZMBtn.setBackgroundColor(Color.parseColor("#4EB84A"));

        }
    }

    public static boolean isMobileNO(String mobileNums) {

        String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobileNums))
            return false;
        else
            return mobileNums.matches(telRegex);
    }
    //ee64c8aa09b3516f9fec51cd6e2f81d2

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
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            System.exit(0);
        }
    }


}
