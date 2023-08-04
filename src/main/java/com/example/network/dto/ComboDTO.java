package com.example.network.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ComboDTO {
    private String id;

    /**
     * 指定该 Combo 的类型，可以是内置 Combo 的类型名，也可以是自定义 Combo 的类型名。默认是 "circle"
     */
    private String type;

    /**
     * 该 Combo 的父 Combo 的 ID
     */
    private String parentId;

    /**
     * Combo 的最小尺寸（非固定尺寸），默认 "circle" 类型 Combo 的 size 为 20，"rect" 类型的为 "[20, 5]"
     */
    private String size;

    /**
     * 固定该 Combo 的尺寸，不指定时 Combo 大小由内部元素的分布和大小来决定。若指定了 fixSize 而没有指定 fixCollapseSize，则即使该 Combo 在收起状态下仍然保持 fixSize 指定的尺寸
     */
    private String fixSize;

    /**
     * 固定该 Combo 收起时的尺寸，不指定时，若未指定 fixSize 则由 size 决定收起时的尺寸，否则统一为 fixSize 尺寸
     */
    private String fixCollapseSize;

    /**
     * 该 Combo 内边距，默认 "circle" 类型 Combo 的 padding 为 "[25, 25, 25, 25]"，"rect" 类型的为 "[25, 20, 15, 20]"
     */
    private String padding;

    /**
     * 该 Combo 的样式配置项
     */
    private Map<String, Object> style;

    /**
     * 该 Combo 的文本标签
     */
    private String label;

    /**
     * 该 Combo 的文本标签样式配置项
     */
    private Map<String, Object> labelCfg;
}
