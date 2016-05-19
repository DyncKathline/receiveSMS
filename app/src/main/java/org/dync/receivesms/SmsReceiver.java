package org.dync.receivesms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = SmsReceiver.class.getSimpleName();
    public static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private onSMSMessageListener mOnSMSMessageListener;
    private String patternCoder = "(?<!\\d)\\d{7}(?!\\d)";//匹配6位验证码

    @Override
    public void onReceive(Context context, Intent intent) {
        final String tag = TAG + ".onReceive";
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            Log.d(tag, "BroadcastReceiver failed, no intent data to process.");
            return;
        }
        if (intent.getAction().equals(SMS_RECEIVED)) {
            Log.d(tag, "SMS_RECEIVED");
            String smsOriginatingAddress = null, smsDisplayMessage = null;
            /**
             * You have to CHOOSE which code snippet to use NEW (KitKat+), or legacy
             * Please comment out the for{} you don't want to use.
             */
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Log.d(tag, "KitKat or newer + API " + Build.VERSION.SDK_INT);
                // API level 19 (KitKat 4.4) getMessagesFromIntent
                for (SmsMessage message : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                    if (message == null) {
                        Log.e(tag, "SMS message is null -- ABORT");
                        break;
                    }
                    smsOriginatingAddress = message.getDisplayOriginatingAddress();
                    smsDisplayMessage = message.getDisplayMessageBody(); //see getMessageBody();
                    SmsParser.processReceivedSms(smsOriginatingAddress, smsDisplayMessage);
                }
            } else { // BELOW KITKAT
                Log.d(tag, "legacy SMS implementation (before KitKat) API " + Build.VERSION.SDK_INT);
                // Processing SMS messages the OLD way, before KitKat, this WILL work on KitKat or newer Android
                // PDU is a “protocol data unit”, which is the industry format for an SMS message
                Object[] data = (Object[]) bundle.get("pdus");
                for (Object pdu : data) {
                    SmsMessage message = SmsMessage.createFromPdu((byte[]) pdu);
                    if (message == null) {
                        Log.d(tag, "SMS message is null -- ABORT");
                        break;
                    }
                    smsOriginatingAddress = message.getDisplayOriginatingAddress();
                    smsDisplayMessage = message.getDisplayMessageBody(); // see getMessageBody();
                    SmsParser.processReceivedSms(smsOriginatingAddress, smsDisplayMessage);
                }
            }
            Log.d(TAG, "onReceive: mOnSMSMessageListener = " + mOnSMSMessageListener);
            String patternCode = patternCode(smsDisplayMessage);
            if (mOnSMSMessageListener != null) {
                mOnSMSMessageListener.getDisplayMessageBody(smsDisplayMessage);
                mOnSMSMessageListener.getAuthCode(patternCode);
            }
        } // onReceive method
    }

    public interface onSMSMessageListener {
        /**
         * 获取整个短信内容
         *
         * @param smsDisplayMessage
         */
        void getDisplayMessageBody(String smsDisplayMessage);

        /**
         * 只获取短信验证码部分
         *
         * @param smsAuthCode
         */
        void getAuthCode(String smsAuthCode);
    }

    public void SetOnSMSMessageListener(onSMSMessageListener listener) {
        mOnSMSMessageListener = listener;
    }

    /**
     * 匹配短信中间的6个数字（验证码等）
     *
     * @param patternContent
     * @return
     */
    private String patternCode(String patternContent) {
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
}