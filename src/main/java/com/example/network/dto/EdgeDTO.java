package com.example.network.dto;

import com.example.network.entity.Edge;
import lombok.Data;

import java.util.Map;

@Data
public class EdgeDTO {
    private String id;

    /**
     * 起始点 id
     */
    private String source;

    /**
     * 结束点 id
     */
    private String target;

    /**
     * 指定边的类型，可以是内置边的类型名称，也可以是自定义边的名称。默认为 "line"
     */
    private String type;

    /**
     * 边的起始节点上的锚点的索引值
     */
    private Integer sourceAnchor;

    /**
     * 边的终止节点上的锚点的索引值
     */
    private Integer targetAnchor;

    /**
     * 边的样式属性
     */
    private Map<String, Object> style;

    /**
     * 文本文字，如果没有则不会显示
     */
    private String label;

    /**
     * 文本配置项
     */
    private Map<String, Object> labelCfg;

    private Edge sourceData;
}
