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
@TableName("node")
public class Node implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 节点唯一ID，必须是唯一的字符串
     */
    @TableId("id")
    private String id;

    /**
     * x坐标
     */
    @TableField("x")
    private Object x;

    /**
     * y坐标
     */
    @TableField("y")
    private Object y;

    /**
     * 指定节点类型，内置节点类型名称或自定义节点的名称。默认为 "circle"
     */
    @TableField("type")
    private String type;

    /**
     * 节点的大小
     */
    @TableField("size")
    private Object size;

    /**
     * 指定边连入节点的连接点的位置（相对于该节点而言），可以为空
     */
    @TableField("anchorPoints")
    private String anchorPoints;

    /**
     * 节点的样式属性
     */
    @TableField("style")
    private String style;

    /**
     * 文本文字
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

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getSize() {
        return size;
    }

    public void setSize(Object size) {
        this.size = size;
    }

    public String getAnchorPoints() {
        return anchorPoints;
    }

    public void setAnchorPoints(String anchorPoints) {
        this.anchorPoints = anchorPoints;
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
