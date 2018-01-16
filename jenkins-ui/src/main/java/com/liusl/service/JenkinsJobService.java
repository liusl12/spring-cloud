package com.liusl.service;

import org.dom4j.Document;
import org.dom4j.Element;

/**
 * created by l1 on 2018/1/16.
 */
public interface JenkinsJobService {
    /**
     * 根据config.xml生成的Document对象创建jenkins job
     * @param jobName
     */
    public void createJob(String jobName);

    /**
     * 创建config文件对象
     * @return
     */
    public Document createConfigXML();

    /**
     * 构建config.xml文件
     * @param parentElement
     * @param node
     */
    public void createElements(Element parentElement, String node);
}
