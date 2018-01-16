package com.liusl;

import com.alibaba.fastjson.JSON;
import com.liusl.controller.TestController;
import com.liusl.jobmaker.JobManagement;
import com.liusl.model.XMLProperties;
import com.liusl.service.JenkinsJobServiceImp;
import com.liusl.service.XMLConfigruationServiceImp;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.dom4j.DocumentException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JenkinsUiApplicationTests {
	@Autowired
	private XMLConfigruationServiceImp xmlConfigruationServiceImp;
	@Autowired
	private JenkinsJobServiceImp jenkinsJobServiceImp;
	@Test
	public void copyTest() throws IOException, DocumentException {
////		System.out.println(ClassPath.getClassPath()+"/resource/static/config.xml");
//		File source = new File("src/main/resources/static/config.xml");
//		File dest = new File("src/main/resources/static/config/config.xml");
//		dest.delete();
////		System.out.println(source.toPath());
//
////		System.out.println(ClassLoader.getSystemClassLoader().getResource("src/main/resources/sattic/config.xml"));
//		Files.copy(source.toPath(),dest.toPath());
//		JenkinsJobManagement.createConfigXML();
//		JobManagement jobManagement = new JobManagement();
//		jobManagement.createJobByName("lius12Test");
//		System.out.println(TestController.class.getResource("/"));
		TestController testController = new TestController();
		testController.createJob("1");
	}
	@Test
	public void getXMLRootNode(){
		XMLProperties xmlProperties = xmlConfigruationServiceImp.getXMLRootNode();
		System.out.println(JSON.toJSONString(xmlProperties));
	}
	@Test
	public void getXMLChildrenNode(){
		List<XMLProperties> xmlProperties = xmlConfigruationServiceImp.getXMLChildrenNode("actions");
		System.out.println(JSON.toJSONString(xmlProperties));
	}
	@Test
	public void createConfigXML() throws IOException {
		jenkinsJobServiceImp.createJob("liusl12_test666");
	}

}
