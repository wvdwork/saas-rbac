package com.wvd.saas.rbac.web.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wvd.saas.rbac.web.vo.OrgTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrgTree {
    /**
     * 递归处理   数据库树结构数据->树形json
     * @param nodeId
     * @param nodes
     * @return
     */
    public static JSONArray getNodeJson(Long nodeId, Map<Long,OrgTreeNode> nodes){

        //当前层级当前node对象
        OrgTreeNode cur = nodes.get(nodeId);
        //当前层级当前点下的所有子节点（实战中不要慢慢去查,一次加载到集合然后慢慢处理）
        List<OrgTreeNode> childList = getChildNodes(nodeId,nodes);

        JSONArray childTree = new JSONArray();
        for (OrgTreeNode node : childList) {
            JSONObject o = JSON.parseObject(JSON.toJSONString(node));
            JSONArray childs = getNodeJson(node.getId(),nodes);  //递归调用该方法
            if(!childs.isEmpty()) {
                o.put("children",childs);
            }
            childTree.fluentAdd(o);
        }
        return childTree;
    }

    /**
     * 获取当前节点的所有子节点
     * @param nodeId
     * @param nodes
     * @return
     */
    public static List<OrgTreeNode> getChildNodes(Long nodeId, Map<Long,OrgTreeNode> nodes){
        List<OrgTreeNode> list = new ArrayList<>();
        for (Long key : nodes.keySet() ) {
            if(nodes.get(key).getParentId().equals(nodeId)){
                list.add(nodes.get(key));
            }
        }
        return list;
    }
}
