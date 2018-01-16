package com.liusl.controller;

import com.alibaba.fastjson.JSON;
import com.liusl.model.XMLProperties;
import com.liusl.plugins.PluginsManagement;
import com.liusl.service.XMLConfigruationServiceImp;
import com.liusl.xml.XMLConfig;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.Plugin;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * created by l1 on 2017/12/5.
 */
@RestController
@RequestMapping(value = "/jenkins")
public class TestController {
    @Autowired
    private JenkinsServer jenkinsServer;
    @Autowired
    private XMLConfigruationServiceImp xmlConfigruationServiceImp;

    @RequestMapping(value = "/getJobs",method = RequestMethod.GET)
    public Map<String,Job> getJobs() throws IOException {
        Map<String,Job> jobs = jenkinsServer.getJobs();
        return jobs;
    }
//    @RequestMapping(value = "/createJob",method = RequestMethod.POST)
//    public void createJob() throws IOException {
//        Document document = DocumentHelper.createDocument();
//        Element root = document.addElement("root");
//
//        Element author1 = root.addElement("author")
//                .addAttribute("name", "James")
//                .addAttribute("location", "UK")
//                .addText("James Strachan");
//
//        Element author2 = root.addElement("author")
//                .addAttribute("name", "Bob")
//                .addAttribute("location", "US")
//                .addText("Bob McWhirter");
//
//        Writer fileWriter = new FileWriter("D://foo.xml");
//        XMLWriter xmlWriter = new XMLWriter(fileWriter);
//        xmlWriter.write(document);
//        xmlWriter.close();
//    }
    @RequestMapping(value = "/pluginVersion/{pluginName}",method = RequestMethod.GET)
    public String getPluginVersion(@PathVariable("pluginName") String pluginName) throws IOException {
//        List<Plugin> plugins = new ArrayList<Plugin>();
        return PluginsManagement.getPluginVersion(pluginName);
    }
    @RequestMapping(value = "/{jobName}",method = RequestMethod.POST)
    public void createJob(@PathVariable("jobName") String jobName) throws IOException, DocumentException {
//        String configXML = "resources/static/config/config.xml";
//        //创建SAXReader对象
//        SAXReader reader = new SAXReader();
//        File file = new File("src/main/resources/static/config/config.xml");
//        this.getClass().getClassLoader().getResource("src/main/resources/static/config/config.xml").getPath();
//        //读取文件 转换成Document
////        Document document = reader.read(new File("D:\\MicroservicePlatform\\workspace\\spring-cloud\\jenkins-ui\\src\\main\\resources\\static\\config\\config.xml"));
//        //document转换为String字符串
//        Document document = reader.read(file);
//        String documentStr = document.asXML();
//        jenkinsServer.createJob(jobName,documentStr);
//        System.out.println(this.getClass().getResource("/"));
        XMLConfig.copyXML();

    }
    @RequestMapping(value = "/XMLProperties",method = RequestMethod.POST)
    public List<XMLProperties> getAllXMLProperties() {
        return xmlConfigruationServiceImp.getAllXMLInfo();
    }
    @RequestMapping(value = "/XMLProperties/{node}",method = RequestMethod.POST)
    public XMLProperties getXMLPropertiesByNode(@PathVariable("node")String node) {
        return xmlConfigruationServiceImp.getXMLInfoByNode(node);
    }
}
