package com.liusl.plugins;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Plugin;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * created by l1 on 2018/1/11.
 */
public class PluginsManagement {
    private static final String URL = "http://10.99.246.99:8080/jenkins";
    private static final String USERNAME = "microservice";
    private static final String PASSWORD = "abcd-1234";
    static List<Plugin> plugins =new ArrayList<Plugin>();
    private static Plugin plugin = null;
    private static JenkinsServer jenkinsServer;

    static {
        try {
            jenkinsServer = new JenkinsServer(new URI(URL), USERNAME, PASSWORD);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     通过插件的shorname查询插件版本
     */
    public static String getPluginVersion(String shortname) throws IOException {
        return getPluginByShortname(shortname).getVersion();
    }

    /**
     * 获取所有插件信息
     */
    public static List<Plugin> getPlugins() throws IOException {
        return jenkinsServer.getPluginManager().getPlugins();
    }

    /**
     * 根据shorname查询plugin信息
     */
    public static Plugin getPluginByShortname(String shortname) throws IOException {
        plugin = null;
        plugins = getPlugins();
        for(Plugin p:plugins){
            if (p.getShortName().equals(shortname)){
                plugin = p;
                break;
            }
        }
        return plugin;
    }
}
