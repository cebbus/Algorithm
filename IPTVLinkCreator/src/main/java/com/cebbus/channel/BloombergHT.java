package com.cebbus.channel;

import com.cebbus.LinkCreator;

/**
 * Created by cebbus on 26.03.2017.
 * Bloomberg HT
 */
public class BloombergHT extends LinkCreator{

    private static final String NAME = "Bloomberg HT";
    private static final String LINK = "http://mn-i.mncdn.com/bloomberght_ios/smil:bloomberght.smil/chunklist_w668226506_b848000.m3u8";

    @Override
    public String createLink() {
        return LINK;
    }

    @Override
    public String getChannelName() {
        return NAME;
    }

}
