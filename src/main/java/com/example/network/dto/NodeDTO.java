package com.example.network.dto;

import com.example.network.entity.Edge;
import com.example.network.entity.Node;
import lombok.Data;

import java.util.Map;

@Data
public class NodeDTO {
    private String id;

    /**
     * x坐标
     */
    private Object x;

    /**
     * y坐标
     */
    private Object y;

    /**
     * 指定节点类型，内置节点类型名称或自定义节点的名称。默认为 "circle"
     */
    private String type;

    /**
     * 节点的大小
     */
    private Object size;

    /**
     * 指定边连入节点的连接点的位置（相对于该节点而言），可以为空
     */
    private String anchorPoints;

    /**
     * 节点的样式属性
     */
    private Map<String, Object> style;

    /**
     * 文本文字
     */
    private String label;

    /**
     * 文本配置项
     */
    private Map<String, Object> labelCfg;

    private Node sourceData;
}
