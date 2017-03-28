package com.yourtion.httpdns;

import android.util.Log;

/**
 * Created by Yourtion on 14/03/2017.
 */

public class Debug {
    static boolean isshow = false;

    private static String PREFIX = "HTTPDNS:";
    private String name;

    public Debug (String name) {
        this.name = name;
    }

    public void error(String msg) {
        if (isshow && msg != null) Log.e(PREFIX + this.name, msg);
    }

    public void exception(Exception e) {
        if (isshow && e != null) this.error(Log.getStackTraceString(e));
    }

    public void warn(String msg) {
        if (isshow && msg != null) Log.w(PREFIX + this.name, msg);
    }

    public void debug(String msg) {
        if (isshow && msg != null) Log.d(PREFIX + this.name, msg);
    }

    public void info(String msg) {
        if (isshow && msg != null) Log.i(PREFIX + this.name, msg);
    }
}
