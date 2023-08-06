package com.example.network.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author eitan
 * @since 2023-08-04
 */
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSourceAnchor() {
        return sourceAnchor;
    }

    public void setSourceAnchor(Integer sourceAnchor) {
        this.sourceAnchor = sourceAnchor;
    }

    public Integer getTargetAnchor() {
        return targetAnchor;
    }

    public void setTargetAnchor(Integer targetAnchor) {
        this.targetAnchor = targetAnchor;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelCfg() {
        return labelCfg;
    }

    public void setLabelCfg(String labelCfg) {
        this.labelCfg = labelCfg;
    }
}
