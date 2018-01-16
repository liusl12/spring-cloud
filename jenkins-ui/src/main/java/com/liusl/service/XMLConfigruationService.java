package com.liusl.service;

import com.liusl.model.XMLProperties;

import java.util.List;

/**
 * created by l1 on 2018/1/12.
 */
public interface XMLConfigruationService {
    /**
     * 返回创建xml的所有信息
     * @return
     */
    public List<XMLProperties> getAllXMLInfo();
    /**
     * 根据node名称返回xml的node信息
     * @param node
     * @return XMLProperties
     */
    public XMLProperties getXMLInfoByNode(String node);
    /**
     * 返回xml的root node信息
     * @return XMLProperties
     */
    public XMLProperties getXMLRootNode();
    /**
     * 根据node查询是否该node拥有子节点，若有，返回所有子节点信息
     * @param
     * @return List<XMLProperties>
     */
    public List<XMLProperties> getXMLChildrenNode(String node);
}
