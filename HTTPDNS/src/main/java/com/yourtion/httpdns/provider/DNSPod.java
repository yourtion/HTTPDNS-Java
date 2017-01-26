package com.yourtion.httpdns.provider;

import com.yourtion.httpdns.HTTPDNS;
import com.yourtion.httpdns.Record;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Yourtion on 24/10/2016.
 */

public class DNSPod extends Base {
    public DNSPod() {

    }

    public String getRequestString(String domain) {
        return String.format("%sd?dn=%s&ttl=1", HTTPDNS.sHTTPDNS_DNSPOD_SERVER_ADDRESS, domain);
    }

    public Record parseResult(String data) {
        String[] res = data.split(",");
        System.out.println(res.length);
        System.out.println(res.toString());
        if(res.length == 2) {
            ArrayList<String> ipList = new ArrayList<>(Arrays.asList(res[0].split(";")));
            int ttl = Integer.parseInt(res[1]);
            return new Record(ipList, ttl);
        }
        return null;
    }
}
