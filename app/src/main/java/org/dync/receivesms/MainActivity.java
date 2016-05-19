package org.dync.receivesms;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements SmsReceiver.onSMSMessageListener{
    private SmsReceiver smsReceiver;
    private IntentFilter filter;
    private TextView tvShow;
    private TextView tvCode;
    private RadioGroup radioGroup;
    private SmsReceiver.onSMSMessageListener mOnSMSMessageListener;

    private SmsContentObserver smsContentObserver;
    private Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            String outbox = (String) msg.obj;
            tvShow.setText(outbox);
            tvCode.setText(patternCode(outbox));
        }
    };

    /**
     * 匹配短信中间的6个数字（验证码等）
     *
     * @param patternContent
     * @return
     */
    private String patternCode(String patternContent) {
        String patternCoder = "(?<!\\d)\\d{7}(?!\\d)";//匹配6位验证码
        if (TextUtils.isEmpty(patternContent)) {
            return null;
        }
        Pattern p = Pattern.compile(patternCoder);
        Matcher matcher = p.matcher(patternContent);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShow = (TextView) findViewById(R.id.tv_show);
        tvCode = (TextView) findViewById(R.id.tv_code);
        radioGroup = (RadioGroup) findViewById(R.id.rgroup);

        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.rb_receiver){
            useReceiverGetSMS();
        }else {
            useObserverGetSMS();
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //注意获取不到短信内容可能是没在"设置"-->"其他应用管理"-->"应用名"-->"权限管理"中打开"读取短信"权限
                //我的测试机是小米4手机，可能路径不一样
                if (checkedId == R.id.rb_receiver){
                    useReceiverGetSMS();
                }else {
                    useObserverGetSMS();
                }
            }
        });

    }

    private void useObserverGetSMS() {
        //注册内容观察者获取短信
        smsContentObserver = new SmsContentObserver(this, mHandler);
        // ”表“内容观察者 ，通过测试我发现只能监听此Uri -----> content://sms
        // 监听不到其他的Uri 比如说 content://sms/outbox
        Uri smsUri = Uri.parse("content://sms");
        getContentResolver().registerContentObserver(smsUri, true, smsContentObserver);
    }

    private void useReceiverGetSMS() {
        //注册广播获取短信，只能是默认构造方法，不能带参数
        //注意获取不到短信内容可能是没在"设置"-->"其他应用管理"-->"应用名"-->"权限管理"中打开"读取短信"权限
        smsReceiver = new SmsReceiver();
        smsReceiver.SetOnSMSMessageListener(this);
        filter = new IntentFilter();
        filter.addAction(SmsReceiver.SMS_RECEIVED);
        filter.setPriority(Integer.MAX_VALUE);
        registerReceiver(smsReceiver, filter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(smsReceiver);
        getContentResolver().unregisterContentObserver(smsContentObserver);
    }

    @Override
    public void getDisplayMessageBody(String smsDisplayMessage) {
        tvShow.setText(smsDisplayMessage);
    }

    @Override
    public void getAuthCode(String smsAuthCode) {
        tvCode.setText(smsAuthCode);
    }
}
