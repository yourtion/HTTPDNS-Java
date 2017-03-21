package com.yourtion.httpdns;

import com.yourtion.httpdns.provider.AliYun;
import com.yourtion.httpdns.provider.Base;
import com.yourtion.httpdns.provider.DNSPod;

import java.util.HashMap;

/**
 * Created by Yourtion on 9/1/16.
 */
public class HTTPDNS {

    public final static String sHTTPDNS_DNSPOD_SERVER_ADDRESS = "119.29.29.29";
    public final static String sHTTPDNS_ALIYUN_SERVER_ADDRESS = "203.107.1.1";

    private HashMap<String, Record> mCache = new HashMap<>();
    private Base mClient;
    private Debug mDebug = new Debug("Main");

    public static void setDebugMode(boolean mode) {
        Debug.isshow = mode;
    }

    public void cleanCache() {
        mDebug.info("cleanCache");
        mCache.clear();
    }

    public void useDNSPod() {
        this.cleanCache();
        mClient = new DNSPod();
    }

    public void useAliYun(String account) {
        this.cleanCache();
        mClient = new AliYun(account);
    }

    public void useAliYunHTTP(String account) {
        this.cleanCache();
        mClient = new AliYun(account, false);
    }
}
