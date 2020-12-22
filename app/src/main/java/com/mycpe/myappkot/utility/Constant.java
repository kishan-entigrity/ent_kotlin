package com.mycpe.myappkot.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Constant {
    public static boolean isNetworkAvailable(Context con) {
        try{
            ConnectivityManager connectivityManager = (ConnectivityManager) con.getSystemService(Context.CONNECTIVITY_SERVICE);
            @SuppressLint("MissingPermission") NetworkInfo activeNetworkInfo = connectivityManager
                    .getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static void showToast(String strMsg, Context con) {
//        Snackbar.make(con, strMsg, Snackbar.LENGTH_SHORT).show();
        Toast.makeText(con, strMsg, Toast.LENGTH_SHORT).show();
    }
}