package com.yourtion.httpdns_demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.yourtion.httpdns.HTTPDNS;
import com.yourtion.httpdns.Record;
import com.yourtion.httpdns.provider.DNSPod;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread mThread = new Thread(GetWeatherDataThread);
        mThread.start();
    }
    Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if(msg.what == 0){
//                System.out.println(resultData);
                System.out.println("线程结束");
            }
        }

    };

    private Runnable  GetWeatherDataThread = new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            try {
                HTTPDNS.setDebugMode(true);
                DNSPod pod = new DNSPod();
                Record rec = pod.requestRecord("qq.com");
                System.out.println(rec);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            mHandler.sendEmptyMessage(0);
        }
    };
}
