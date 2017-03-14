package com.yourtion.httpdns;

import com.yourtion.httpdns.provider.AliYun;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class AliYunTest {

    private AliYun mAliYunHttp = new AliYun("100000", false);
    private AliYun mAliYunHttps = new AliYun("100000");

    private final static String sURL = "://203.107.1.1/100000/d?host=yourtion.com";
    private String sResult = "{\"host\":\"www.taobao.com\",\"ips\":[\"121.9.212.177\",\"121.9.212.176\"],\"ttl\":60,\"origin_ttl\":60}";

    @Test
    public void getRequestStringHttp() throws Exception {
        String url = mAliYunHttp.getRequestString("yourtion.com");
        assertEquals("http" + sURL, url);
    }

    @Test
    public void getRequestStringHttps() throws Exception {
        String url = mAliYunHttps.getRequestString("yourtion.com");
        assertEquals("https" + sURL, url);
    }

    @Test
    public void parseResult() throws Exception {
        Record result = mAliYunHttp.parseResult(sResult);
        assertEquals(result.getIp(), "121.9.212.177");
        assertEquals(result.getIps().size(), 2);
        assertTrue(result.getTimeout() <= System.currentTimeMillis()/1000 + 600);
    }

}
