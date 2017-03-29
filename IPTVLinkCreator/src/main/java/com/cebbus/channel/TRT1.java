package com.cebbus.channel;

import com.cebbus.LinkCreator;

/**
 * Created by cebbus on 26.03.2017.
 * TRT1 parser
 */
public class TRT1 extends LinkCreator {

    private static final String NAME = "TRT 1";
    private static final String LINK = "http://trtcanlitv-lh.akamaihd.net/i/TRT1HD_1@181842/master.m3u8";

    public String createLink() {
        return LINK;
    }

    public String getChannelName() {
        return NAME;
    }
}
