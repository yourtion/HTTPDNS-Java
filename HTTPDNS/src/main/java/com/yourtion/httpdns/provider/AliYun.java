package com.yourtion.httpdns.provider;

import com.yourtion.httpdns.Debug;
import com.yourtion.httpdns.HTTPDNS;
import com.yourtion.httpdns.Record;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Yourtion on 14/03/2017.
 */

public class AliYun extends Base {

    private Debug mDebug = new Debug("AliYun");
    private String mServer = "";

    public AliYun(String accountId) {
        this(accountId, true);
    }

    public AliYun(String accountId, boolean https) {
        String prefix = "http";
        if(https) {
            prefix = "https";
        }
        this.mServer = String.format("%s://%s/%s", prefix, HTTPDNS.sHTTPDNS_ALIYUN_SERVER_ADDRESS, accountId);
    }

    public String getRequestString(String domain) {
        mDebug.info(domain);
        return String.format("%s/d?host=%s", this.mServer, domain);
    }

    public Record parseResult(String data) {
        try {
            JSONObject res = new JSONObject(data);
            mDebug.debug(String.format("res: %s", res.toString()));
            JSONArray ips = res.getJSONArray("ips");
            int ttl = res.getInt("ttl");
            if(ttl > 0 && ips.length() > 0) {
                ArrayList<String> ipList = new ArrayList<>();
                int len = ips.length();
                for (int i=0;i<len;i++){
                    ipList.add(ips.get(i).toString());
                }
                return new Record(ipList, ttl);
            }
        } catch (Exception e) {
            mDebug.exception(e);
        }
        return null;
    }
}