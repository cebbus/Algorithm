package com.cebbus.channel;

import com.cebbus.LinkCreator;

/**
 * Created by cebbus on 27.03.2017.
 * Star TV
 */
public class STARTV extends LinkCreator {

    private static final String NAME = "STARTV";

    @Override
    public String createLink() {
        String source = downloadSource("https://www.canlitvlive.live/izle/star-tv.html");
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
