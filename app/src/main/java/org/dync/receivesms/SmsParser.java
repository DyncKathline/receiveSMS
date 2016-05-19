package org.dync.receivesms;

import android.util.Log;

/**
 * Created by xiongxuesong-pc on 2016/5/17.
 */
public class SmsParser {
    private static final String TAG = SmsParser.class.getSimpleName();
    public static void processReceivedSms(String smsOriginatingAddress, String smsDisplayMessage) {
        final String tag = TAG + ".processReceivedSms";
        Log.i(tag, "SMS from  " + smsOriginatingAddress);
        Log.i(tag, "SMS body  " + smsDisplayMessage);
        String keyword = "Info?";
        if (doesSmsStartWith(smsDisplayMessage, keyword)) {
            Log.i(tag, "SMS does start with " + keyword);
        }
        else
            Log.e(TAG + ".onReceive", "SMS does not start with " + keyword);
    }
    /**
     * this is a very simple method to detect if
     * the SMS message starts with a given character sequence
     */
    private static boolean doesSmsStartWith(String smsMessage, String txt) {
        return smsMessage.trim().toLowerCase().startsWith(txt.trim().toLowerCase());
    }
}
