package com.example.programbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.aware.WifiAwareManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    IntentFilter intentFilter;
MyBroadCastReceiver myBroadCastReceiver=new MyBroadCastReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFilter();
        addAction();
        registerBroadcast();

     //   intentFilter.addAction("android.net.wifi.WifiManager.WIFI_STATE_CHANGED_ACTION");
    }

    private void getFilter() {
        //getting intent filter
       intentFilter = new IntentFilter();
    }
    private void addAction() {
        //add action to filter
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
    }

    private void registerBroadcast() {
        //registering broadcast
        registerReceiver(myBroadCastReceiver, intentFilter);
    }
}