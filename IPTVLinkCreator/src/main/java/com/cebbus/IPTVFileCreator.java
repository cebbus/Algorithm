package com.cebbus;

import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by cebbus on 26.03.2017.
 * Create ip tv file
 */
public class IPTVFileCreator {

    private static final String FILE_NAME = System.getProperty("user.home") + "/Desktop/channelList.m3u";

    private static String createChannelLinkList() {

        StringBuilder linkBuilder = new StringBuilder();
        linkBuilder.append("#EXTM3U");
        linkBuilder.append(System.lineSeparator());


        ChannelList[] values = ChannelList.values();

        for (ChannelList channel : values) {
            LinkCreator creator = channel.getCreator();

            linkBuilder.append("#EXTINF:-1, ").append(creator.getChannelName());
            linkBuilder.append(System.lineSeparator());
            linkBuilder.append(creator.createLink());
            linkBuilder.append(System.lineSeparator());
        }

        return linkBuilder.toString();
    }

    public static void main(String[] args) {

        String channelList = createChannelLinkList();

        /*
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))){
            bw.write(channelList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        Sardine sardine = SardineFactory.begin("", "");
        byte[] data = channelList.getBytes();

        try {
            sardine.put("https://webdav.yandex.com.tr/channelList.m3u", data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
