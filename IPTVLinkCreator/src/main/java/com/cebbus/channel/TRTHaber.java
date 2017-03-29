package com.cebbus.channel;

import com.cebbus.LinkCreator;

/**
 * Created by cebbus on 26.03.2017.
 * TRT Haber
 */
public class TRTHaber extends LinkCreator {

    private static final String NAME = "TRT Haber";
    private static final String LINK = "http://trtcanlitv-lh.akamaihd.net/i/TRTHABERHD_1@181942/master.m3u8";

    @Override
    public String createLink() {
        return LINK;
    }

    @Override
    public String getChannelName() {
        return NAME;
    }
}
