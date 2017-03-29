package com.cebbus.channel;

import com.cebbus.LinkCreator;

/**
 * Created by cebbus on 27.03.2017.
 * ATV
 */
public class ATV extends LinkCreator {

    private static final String NAME = "ATV";

    @Override
    public String createLink() {
        String source = downloadSource("https://www.canlitvlive.live/izle/atv.html");
        source = source.substring(source.indexOf("file:"), source.length());
        source = source.replaceAll("file:\"", "http:");
        source = source.substring(0, source.indexOf("\""));

        return source;
    }

    @Override
    public String getChannelName() {
        return NAME;
    }

}
