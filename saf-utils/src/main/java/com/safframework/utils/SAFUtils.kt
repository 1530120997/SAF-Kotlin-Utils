package com.safframework.utils

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.Uri
import android.net.wifi.WifiManager
import android.os.Build
import java.io.File

/**
 * Created by Tony Shen on 2017/1/17.
 */
object SAFUtils {

    fun isFroyoOrHigher(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO
    }

    fun isGingerbreadOrHigher(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD
    }

    fun isHoneycombOrHigher(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB
    }

    fun isICSOrHigher(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH
    }

    fun isJellyBeanOrHigher(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
    }

    @TargetApi(17)
    fun isJellyBeanMR1OrHigher(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1
    }

    @TargetApi(18)
    fun isJellyBeanMR2OrHigher(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2
    }

    @TargetApi(19)
    fun isKitkatOrHigher(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
    }

    @TargetApi(20)
    fun isKitkatWatchOrHigher(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH
    }

    @TargetApi(21)
    fun isLOrHigher(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
    }

    /**
     * api level 22是android 5.1
     * @return
     */
    @TargetApi(22)
    fun isLMR1OrHigher(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1
    }

    @TargetApi(23)
    fun isMOrHigher(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
    }

    fun isWiFiActive(context: Context): Boolean {
        var wm: WifiManager? = null
        try {
            wm = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return wm!=null && wm.isWifiEnabled
    }

    /**
     * 安装apk
     * @param fileName apk文件的绝对路径
     * *
     * @param context
     */
    fun installAPK(fileName: String, context: Context) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(Uri.fromFile(File(fileName)), "application/vnd.android.package-archive")
        context.startActivity(intent)
    }

    /**
     * 检测网络状态
     * @param context
     * *
     * @return
     */
    fun checkNetworkStatus(context: Context): Boolean {
        var resp = false
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetInfo = connMgr.activeNetworkInfo
        if (activeNetInfo != null && activeNetInfo.isAvailable) {
            resp = true
        }
        return resp
    }

    /**
     * 检测gps状态
     * @param context
     * *
     * @return
     */
    fun checkGPSStatus(context: Context): Boolean {
        var resp = false
        val lm = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            resp = true
        }
        return resp
    }

    /**
     * 生成app日志tag
     * @param cls
     * *
     * @return
     */
    fun makeLogTag(cls: Class<*>): String {
        return cls.simpleName
    }
}