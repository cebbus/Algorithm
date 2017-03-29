package com.cebbus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by cebbus on 26.03.2017.
 * Link creator interface
 */
public abstract class LinkCreator {

    public abstract String createLink();

    public abstract String getChannelName();

    protected String downloadSource(String liveUrl) {

        StringBuilder source = new StringBuilder();

        URL url;
        URLConnection uc;
        InputStream is = null;
        BufferedReader br;
        String line;

        try {
            url = new URL(liveUrl);
            uc = url.openConnection();
            uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            uc.connect();

            is = uc.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                source.append(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }

        return source.toString();
    }
}
