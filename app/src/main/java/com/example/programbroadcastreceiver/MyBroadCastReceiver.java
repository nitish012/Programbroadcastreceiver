package com.example.programbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        String status=getConnectivityStatusString(context);
        Toast.makeText(context, status, Toast.LENGTH_SHORT).show();

    }
    public String getConnectivityStatusString(Context context){
        /*
        checking the received value to set status for showing connection and return it

         */
        int conn = getConnectivityStatus(context);
        String status = null;
        if (conn == 0) {
            status = "Wifi enabled";
        } else if (conn == 1) {
            status = "Mobile data enabled";
        } else if (conn ==2) {
            status = "Not connected to Internet";
        }
        return status;


    }

    public int getConnectivityStatus(Context context)
    {

        // check the network type and return it
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork!=null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return 0;

            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return 1;
        }
        return 2;


    }


}
