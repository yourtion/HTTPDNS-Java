package com.yourtion.httpdns.provider;

import android.util.Log;
import com.yourtion.httpdns.BuildConfig;

/**
 * Created by Yourtion on 14/03/2017.
 */

class Debug {
    public static boolean isshow = BuildConfig.DEBUG;

    private static String PREFIX = "HTTPDNS:";
    private String name;

    Debug (String name) {
        this.name = name;
    }

    void error(String msg) {
        if (isshow) Log.e(PREFIX + this.name, msg);
    }

    void exception(Exception e) {
        if (isshow) this.error(Log.getStackTraceString(e));
    }

    void warn(String msg) {
        if (isshow) Log.w(PREFIX + this.name, msg);
    }

    void debug(String msg) {
        if (isshow) Log.d(PREFIX + this.name, msg);
    }

    void info(String msg) {
        if (isshow) Log.i(PREFIX + this.name, msg);
    }
}
