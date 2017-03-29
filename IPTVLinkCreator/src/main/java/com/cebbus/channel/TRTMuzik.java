package com.cebbus.channel;

import com.cebbus.LinkCreator;

/**
 * Created by cebbus on 26.03.2017.
 */
public class TRTMuzik extends LinkCreator {

    private static final String NAME = "TRT Muzik";
    private static final String LINK = "http://trtcanlitv-lh.akamaihd.net/i/TRTMUZIK_1@181845/master.m3u8";

    @Override
    public String createLink() {
        return LINK;
    }

    @Override
    public String getChannelName() {
        return NAME;
    }

}
