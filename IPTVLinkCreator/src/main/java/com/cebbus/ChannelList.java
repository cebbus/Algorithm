package com.cebbus;

import com.cebbus.channel.*;

/**
 * Created by cebbus on 26.03.2017.
 * Channel list
 */
public enum ChannelList {

    TRT1 (new TRT1()),
    KANALD (new KanalD()),
    CNNTURK (new CNNTURK()),
    TRTHABER (new TRTHaber()),
    BLOOMBERGHT (new BloombergHT()),
    TRTSPOR (new TRTSpor()),
    TRTBELGESEL (new TRTBelgesel()),
    TRTTURK (new TRTTurk()),
    TRTOKUL (new TRTOkul()),
    TRTMUZIK (new TRTMuzik()),
    TV8 (new TV8()),
    SHOWTV (new ShowTV()),
    STARTV (new STARTV()),
    FOXTV (new FoxTV()),
    NTV (new NTV()),
    EURONEWS (new EURONEWS()),
    ATV (new ATV());


    private LinkCreator creator;

    ChannelList(LinkCreator creator) {
        this.creator = creator;
    }

    public LinkCreator getCreator() {
        return creator;
    }
}
