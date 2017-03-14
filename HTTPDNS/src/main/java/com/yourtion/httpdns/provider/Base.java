package com.yourtion.httpdns.provider;

import com.yourtion.httpdns.Debug;
import com.yourtion.httpdns.Record;

/**
 * Created by Yourtion on 24/10/2016.
 */

abstract class Base {

    abstract Record parseResult(String data);
    abstract String getRequestString(String domain);

    private Debug mDebug = new Debug("Base");
    private HTTPClient mClient = new HTTPClient();

    public static void setTimeOut(int time) {
        HTTPClient.timeout = time;
    }

    public Record requestRecord(String domain) {
        String url = getRequestString(domain);
        try {
            String result = this.mClient.get(url);
            mDebug.debug(result);
            return parseResult(result);
        } catch (Exception e) {
            mDebug.exception(e);
            return null;
        }
    }

}
