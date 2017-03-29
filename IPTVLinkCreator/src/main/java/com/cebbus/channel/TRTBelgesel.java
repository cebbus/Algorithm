package com.cebbus.channel;

import com.cebbus.LinkCreator;

/**
 * Created by cebbus on 26.03.2017.
 * TRT Belgesel
 */
public class TRTBelgesel extends LinkCreator {

    private static final String NAME = "TRT Belgesel";
    private static final String LINK = "http://trtcanlitv-lh.akamaihd.net/i/TRTBELGESEL_1@182145/master.m3u8";

    @Override
    public String createLink() {
        return LINK;
    }

    @Override
    public String getChannelName() {
        return NAME;
    }
}
