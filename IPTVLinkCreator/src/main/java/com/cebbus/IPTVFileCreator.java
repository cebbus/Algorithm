package com.cebbus;

import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

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

                String channelName = creator.getChannelName();
                String link = creator.createLink();

                linkBuilder.append("#EXTINF:-1, ").append(channelName);
                linkBuilder.append(System.lineSeparator());
                linkBuilder.append(link);
                linkBuilder.append(System.lineSeparator());

                System.out.println(channelName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return linkBuilder.toString();
    }

    private static void writeFile(String channelList){
        BufferedWriter bw = null;

        try {
            String path = IPTVFileCreator.class.getProtectionDomain()
                    .getCodeSource().getLocation().toURI().getPath();

            path = path.substring(0, path.lastIndexOf("/"));

            System.out.println(path);

            File file = new File(path + FILE_NAME);

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            bw.write(channelList);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
