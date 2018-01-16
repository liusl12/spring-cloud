package com.liusl.service;

import com.liusl.model.XMLProperties;
import com.liusl.xml.JenkinsJobManagement;
import com.offbytwo.jenkins.JenkinsServer;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * created by l1 on 2018/1/16.
 */
@Service
public class JenkinsJobServiceImp implements JenkinsJobService{
    private static final String FILE_PATH = "src/main/resources/static/config/config.xml";
    private static final String FILE_TEMP_PATH = "src/main/resources/static/config/config_temp.xml";
    private static final String ELEMENT_SCM = "scm";
    private static final String ELEMENT_URC = "userRemoteConfigs";
    private static final String ELEMENT_HPGURC = "hudson.plugins.git.UserRemoteConfig";
    private static final String ELEMENT_URL = "url";
    private static final String GIT = "git@10.122.23.149:BT-IT/discovery-server.git";
    private static final String CODE = "utf-8";
    private static final org.slf4j.Logger LOGER= LoggerFactory.getLogger(JenkinsJobServiceImp.class);
    @Autowired
    private XMLConfigruationServiceImp xmlConfigruationServiceImp;

    @Autowired
    private JenkinsServer jenkinsServer;
//    public static void createConfigXML() throws IOException {
//        XMLConfig.copyXML();
//        File file = new File(FILE_TEMP_PATH);
//        InputStream inputStream = new FileInputStream(file);
//        SAXReader saxReader = new SAXReader();
//        try {
//            Document document = saxReader.read(file.getAbsolutePath());
//            document.getRootElement().element(ELEMENT_SCM).element(ELEMENT_URC).element(ELEMENT_HPGURC).element(ELEMENT_URL).setText(GIT);
//            FileOutputStream out = new FileOutputStream("src/main/resources/static/config/config.xml");
//            OutputFormat format = OutputFormat.createPrettyPrint();
//            format.setEncoding(CODE);
//            XMLWriter writer = new XMLWriter(out,format);
//            writer.write(document);
//            writer.close();
//            out.close();
//            inputStream.close();
//            new File("src/main/resources/static/config/config_temp.xml").delete();
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 根据config.xml生成的Document对象创建jenkins job
     * @param jobName
     */
    public void createJob(String jobName){
        String documentStr = createConfigXML().asXML();
        JenkinsJobServiceImp.LOGER.info("开始创建jenkins作业......");
        try {
            jenkinsServer.createJob(jobName,documentStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JenkinsJobServiceImp.LOGER.info("jenkins作业创建成功！");
    }
    public Document createConfigXML() {
        JenkinsJobServiceImp.LOGER.info("开始创建config.xml文件......");
        // 创建Document对象
        Document document = DocumentHelper.createDocument();
        // 创建根节点
        Element rootElement = document.addElement(xmlConfigruationServiceImp.getXMLRootNode().getNode());
        String root = xmlConfigruationServiceImp.getXMLRootNode().getNode();
        createElements(rootElement,root);
        JenkinsJobServiceImp.LOGER.info("config.xml文件创建完成");
        return document;
//        Writer fileWriter = new FileWriter("D://foo.xml");
//        XMLWriter xmlWriter = new XMLWriter(fileWriter);
//        xmlWriter.write(document);
//        xmlWriter.close();

    }
    public void createElements(Element parentElement,String node){
        //获取所有子节点
        List<XMLProperties> childrenNode = xmlConfigruationServiceImp.getXMLChildrenNode(node);
        //新增节点
        Element element = null;
        while((childrenNode != null) && !(childrenNode.isEmpty())){
//            childrenNode = xmlConfigruationServiceImp.getXMLChildrenNode(node);
            //递归函数在回归的时候判断，如果子节点已经创建就不在循环了
            if((parentElement.elements() != null) && !(parentElement.elements().isEmpty())){
                break;
            }
            for(XMLProperties xml:childrenNode){
                if (parentElement.selectSingleNode(xml.getNode()) == null){
                    element = parentElement.addElement(xml.getNode());
                    JenkinsJobServiceImp.LOGER.info("子节点:"+xml.getNode()+"创建成功！");
//                    System.out.println("----------------------------------");
//                    System.out.println("Element"+xml.getNode()+"创建成功");
//                    System.out.println("----------------------------------");
                    String clazz = xml.getClazz();
                    String plugin = xml.getPlugin();
                    String text = xml.getText();
                    //如果该节点存在class属性，就添加该属性
                    if ((clazz != null) && (!("".equals(clazz)))){
                        element.addAttribute("class",clazz);
                    }
                    //如果该节点存在plugin属性，就添加该属性
                    if ((plugin != null) && (!("".equals(plugin)))){
                        element.addAttribute("plugin",plugin);
                    }
                    //如果该节点的文本内容
                    if ((text != null) && (!("".equals(text)))){
                        element.setText(text);
                    }
                    createElements(element,xml.getNode());
                }
            }
        }
    }
}
