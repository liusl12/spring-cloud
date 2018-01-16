package com.liusl.service;

import com.liusl.mapper.XMLMapper;
import com.liusl.model.XMLProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by l1 on 2018/1/12.
 */
@Service
public class XMLConfigruationServiceImp {
    @Autowired
    private XMLMapper xmlMapper;


    /**
     * 返回创建xml的所有信息
     * @return
     */
    public List<XMLProperties> getAllXMLInfo(){
        List<XMLProperties> AllXMLProperties = null;                //所有xml文件配置信息
        AllXMLProperties = xmlMapper.getAllXMLInfo();
        return AllXMLProperties;
    }
    /**
     * 根据node名称返回xml的node信息
     * @param node
     * @return XMLProperties
     */
    public XMLProperties getXMLInfoByNode(String node){
        XMLProperties xmlProperties = null;                         //xml  Node信息
        xmlProperties = xmlMapper.getXMLInfoByNode(node);
        return xmlProperties;
    }
    /**
     * 返回xml的root node信息
     * @return XMLProperties
     */
    public XMLProperties getXMLRootNode(){
        XMLProperties xmlProperties = null;                         //xml  Node信息
        xmlProperties = xmlMapper.getXMLRootNode();
        return xmlProperties;
    }


    /**
     * 根据node查询是否该node拥有子节点，若有，返回所有子节点信息
     * @param
     * @return List<XMLProperties>
     */
    public List<XMLProperties> getXMLChildrenNode(String node){
        List<XMLProperties> AllXMLProperties = null;                //该node所有子节点配置信息
        AllXMLProperties = xmlMapper.getXMLChildrenNode(node);
        return AllXMLProperties;
    }
}
