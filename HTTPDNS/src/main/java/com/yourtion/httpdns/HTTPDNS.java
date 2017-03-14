package com.yourtion.httpdns;

/**
 * Created by Yourtion on 9/1/16.
 */
public class HTTPDNS {

    public final static String sHTTPDNS_DNSPOD_SERVER_ADDRESS = "119.29.29.29";
    public final static String sHTTPDNS_ALIYUN_SERVER_ADDRESS = "203.107.1.1";

    public static void setDebugMode(boolean mode) {
        Debug.isshow = mode;
    }
}
