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

    private static final String FILE_NAME = "/channelList.m3u";

    private static String createChannelLinkList() {

        StringBuilder linkBuilder = new StringBuilder();
        linkBuilder.append("#EXTM3U");
        linkBuilder.append(System.lineSeparator());

        ChannelList[] values = ChannelList.values();

        for (ChannelList channel : values) {
            try {
                LinkCreator creator = channel.getCreator();

                linkBuilder.append("#EXTINF:-1, ").append(creator.getChannelName());
                linkBuilder.append(System.lineSeparator());
                linkBuilder.append(creator.createLink());
                linkBuilder.append(System.lineSeparator());

                System.out.println(creator.getChannelName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return linkBuilder.toString();
    }

    private static void writeFile(String channelList){

        File jarDir = new File(ClassLoader.getSystemClassLoader()
                .getResource(".").getPath() + FILE_NAME);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(jarDir))){
            bw.write(channelList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void uploadFile(String channelList) {
        Sardine sardine = SardineFactory.begin("", "");
        byte[] data = channelList.getBytes();

        try {
            sardine.put("https://webdav.yandex.com.tr/channelList.m3u", data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String channelList = createChannelLinkList();

        writeFile(channelList);

        //uploadFile(channelList);
    }

}
