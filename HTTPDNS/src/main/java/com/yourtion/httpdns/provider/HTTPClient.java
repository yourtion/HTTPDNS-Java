package com.yourtion.httpdns.provider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Yourtion on 24/10/2016.
 */

class HTTPClient {

    private Debug mDebug = new Debug("Client");

    public String get(String url) throws Exception {

        URL obj = new URL(url);
        mDebug.info(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");
        con.setConnectTimeout(1000);

        int responseCode = con.getResponseCode();

        mDebug.info("Sending 'GET' request to URL : " + url);
        mDebug.info("Response Code : " + responseCode);

        BufferedReader in;
        if (200 <= responseCode && responseCode <= 299) {
            in = new BufferedReader(new InputStreamReader((con.getInputStream())));
        } else {
            in = new BufferedReader(new InputStreamReader((con.getErrorStream())));
        }
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        mDebug.debug(response.toString());

        return response.toString();
    }

}
