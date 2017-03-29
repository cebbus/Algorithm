package com.cebbus.channel;

import com.cebbus.LinkCreator;

/**
 * Created by cebbus on 27.03.2017.
 * FOX
 */
public class FoxTV extends LinkCreator {

    private static final String NAME = "Fox TV";

    @Override
    public String createLink() {
        String source = downloadSource("http://www.fox.com.tr/canli-yayin");
        source = source.substring(source.indexOf("desktop : ["), source.length());
        source = source.substring(source.indexOf("'") + 1, source.length());
        source = source.substring(0, source.indexOf("'"));

        return source;
    }

    @Override
    public String getChannelName() {
        return NAME;
    }

}
