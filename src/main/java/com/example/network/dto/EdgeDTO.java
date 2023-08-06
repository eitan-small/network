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

    private Map<String, Object> sourceData;
}
