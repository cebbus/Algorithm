package com.cebbus.channel;

import com.cebbus.LinkCreator;

/**
 * Created by cebbus on 26.03.2017.
 * Cnn Turk
 */
public class CNNTURK extends LinkCreator{

    private static final String NAME = "CNN Turk";
    private static final String LINK = "http://37.48.83.10/S2/HLS_LIVE/cnn_turk/1000/prog_index.m3u8?key=fee70ff1f3e3f203e52bd3eee9b0f124&live=true&app=com.cnnturk";

    @Override
    public String createLink() {
        return LINK;
    }

    @Override
    public String getChannelName() {
        return NAME;
    }
}
