package com.example.network.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author eitan
 * @since 2023-08-04
 */
@Data
@TableName("edge")
public class Edge implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 边唯一 ID，必须是唯一的字符串
     */
    @TableId("id")
    private String id;

    /**
     * 起始点 id
     */
    @TableField("source")
    private String source;

    /**
     * 结束点 id
     */
    @TableField("target")
    private String target;

    /**
     * 指定边的类型，可以是内置边的类型名称，也可以是自定义边的名称。默认为 "line"
     */
    @TableField("type")
    private String type;

    /**
     * 边的起始节点上的锚点的索引值
     */
    @TableField("sourceAnchor")
    private Integer sourceAnchor;

    /**
     * 边的终止节点上的锚点的索引值
     */
    @TableField("targetAnchor")
    private Integer targetAnchor;

    /**
     * 边的样式属性
     */
    @TableField("style")
    private String style;

    /**
     * 文本文字，如果没有则不会显示
     */
    @TableField("label")
    private String label;

    /**
     * 文本配置项
     */
    @TableField("labelCfg")
    private String labelCfg;
}
