package com.yourtion.httpdns;

import com.yourtion.httpdns.provider.DNSPod;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class DNSPodTest {

    private DNSPod mDNSPod = new DNSPod();

    private final static String sURL = "http://119.29.29.29/d?dn=yourtion.com&ttl=1";
    private final static String sResult1 = "121.42.75.198,600";
    private final static String sResult2 = "121.42.75.198;121.42.75.199;121.42.75.200,600";

    @Test
    public void getRequestString() throws Exception {
        String url = mDNSPod.getRequestString("yourtion.com");
        assertEquals(sURL, url);
    }

    @Test
    public void parseResult1() throws Exception {
        Record result = mDNSPod.parseResult(sResult1);
        assertEquals(result.getIp(), "121.42.75.198");
        assertEquals(result.getIps().size(), 1);
        assertTrue(result.getTimeout() <= System.currentTimeMillis()/1000 + 600);
    }

    @Test
    public void parseResult2() throws Exception {
        Record result = mDNSPod.parseResult(sResult2);
        assertEquals(result.getIp(), "121.42.75.198");
        assertEquals(result.getIps().size(), 3);
        assertTrue(result.getTimeout() <= System.currentTimeMillis()/1000 + 600);
    }
}
