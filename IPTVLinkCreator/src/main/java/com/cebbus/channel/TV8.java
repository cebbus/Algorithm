package com.cebbus.channel;

import com.cebbus.LinkCreator;

/**
 * Created by cebbus on 26.03.2017.
 * TV 8
 */
public class TV8 extends LinkCreator{

    private static final String NAME = "TV 8";

    @Override
    public String createLink() {
        String source = downloadSource("https://www.tv8.com.tr/canli-yayin");
        source = source.substring(source.indexOf("configPlayer.source.media.push"), source.length());
        source = source.substring(source.indexOf("\"") + 1, source.length());
        source = source.substring(0, source.indexOf("\""));

        return source;
    }

    @Override
    public String getChannelName() {
        return NAME;
    }
}
