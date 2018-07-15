package com.example.vincent8280.calls.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by vincent on 18-7-13.
 */


public class HttpUtil {

    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}