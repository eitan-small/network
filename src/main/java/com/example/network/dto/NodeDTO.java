package com.example.network.dto;

import com.example.network.entity.Edge;
import com.example.network.entity.NetworkDevices;
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
     * 文本文字
     */
    private String label;

    private String comboId;

    private Map<String, Object> sourceData;
}
