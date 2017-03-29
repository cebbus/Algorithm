package com.cebbus.channel;

import com.cebbus.LinkCreator;

/**
 * Created by cebbus on 26.03.2017.
 * Kanal D
 */
public class KanalD extends LinkCreator {

    private static final String NAME = "Kanal D";
    private static final String LINK = "http://37.48.83.9/S2/HLS_LIVE/kanald/1000/prog_index.m3u8?key=fee70ff1f3e3f203e52bd3eee9b0f124&live=true&app=com.kanald&min=0&max=1250";

    @Override
    public String createLink() {
        return LINK;
    }

    @Override
    public String getChannelName() {
        return NAME;
    }
}
