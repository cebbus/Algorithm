package com.cebbus.channel;

import com.cebbus.LinkCreator;

/**
 * Created by cebbus on 26.03.2017.
 * TRT Turk
 */
public class TRTTurk extends LinkCreator {

    private static final String NAME = "TRT Turk";
    private static final String LINK = "http://trtcanlitv-lh.akamaihd.net/i/TRTTURK_1@182144/master.m3u8";

    @Override
    public String createLink() {
        return LINK;
    }

    @Override
    public String getChannelName() {
        return NAME;
    }

}
