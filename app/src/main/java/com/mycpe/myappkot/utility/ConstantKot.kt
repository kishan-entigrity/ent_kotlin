package com.mycpe.myappkot.utility

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

object ConstantKot {
    fun isNetworkAvailable(con: Context): Boolean {
        return try {
            val connectivityManager = con.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            @SuppressLint("MissingPermission") val activeNetworkInfo = connectivityManager
                    .activeNetworkInfo
            activeNetworkInfo != null && activeNetworkInfo.isConnected
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    fun showToast(strMsg: String?, con: Context?) {
//        Snackbar.make(con, strMsg, Snackbar.LENGTH_SHORT).show();
        Toast.makeText(con, strMsg, Toast.LENGTH_SHORT).show()
    }
}