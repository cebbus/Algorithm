package com.cebbus.channel;

import com.cebbus.LinkCreator;

/**
 * Created by cebbus on 26.03.2017.
 * Show TV
 */
public class ShowTV extends LinkCreator {

    private static final String NAME = "Show TV";

    @Override
    public String createLink() {
        String source = downloadSource("http://www.showtv.com.tr/canli-yayin");
        source = source.substring(source.indexOf("ht_stream_m3u8"), source.length());
        source = source.substring(source.indexOf("\":\"") + 3, source.length());
        source = source.substring(0, source.indexOf("\""));
        source = source.replaceAll("\\\\", "");

        return source;
    }

    @Override
    public String getChannelName() {
        return NAME;
    }

}
