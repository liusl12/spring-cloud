package com.liusl.model;

import java.io.Serializable;

/**
 * created by l1 on 2018/1/12.
 * 创建job的xml文件属性类
 */
public class XMLProperties implements Serializable{
    private Integer id;                         //id
    private String node;                        //XML属性节点
    private String fatherNode;                  //属性节点的父节点
    private Integer level;                      //属性节点的等级
    private String clazz;                       //属性节点的class
    private String plugin;                      //插件
    private String pluginName;                  //插件名称
    private String pluginVersion;               //插件版本
    private String text;                        //属性内容
    public XMLProperties(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getFatherNode() {
        return fatherNode;
    }

    public void setFatherNode(String fatherNode) {
        this.fatherNode = fatherNode;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public String getPluginVersion() {
        return pluginVersion;
    }

    public void setPluginVersion(String pluginVersion) {
        this.pluginVersion = pluginVersion;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
