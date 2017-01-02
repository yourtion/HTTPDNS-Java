package com.yourtion.httpdns;

import java.util.ArrayList;

/**
 * Created by Yourtion on 24/10/2016.
 */

public class Record {
    private String ip;
    private ArrayList<String> ips;
    private Long timeout;
    private Boolean cached;

    public Record(ArrayList<String>ips, Integer ttl) {
        if (ips.size() > 0) {
            this.ip = ips.get(0);
            this.ips = ips;
            this.timeout = System.currentTimeMillis()/1000 + ttl;
            this.cached = true;
        }
    }

    public Record(ArrayList<String>ips, Long timeout) {
        if (ips.size() > 0) {
            this.ip = ips.get(0);
            this.ips = ips;
            this.timeout = timeout;
            this.cached = true;
        }
    }

    public void setCached(Boolean cached) {
        this.cached = cached;
    }

    public String getIp() {
        return ip;
    }

    public ArrayList<String> getIps() {
        return ips;
    }

    public Long getTimeout() {
        return timeout;
    }

    public Boolean getCached() {
        return cached;
    }

    @Override
    public String toString() {
        String cached = this.cached ? "Cached" : "";
        return String.format("%s %s : %s in %s", cached, this.ip, this.timeout, this.ips);
    }
}
