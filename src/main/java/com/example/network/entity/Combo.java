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
@TableName("combo")
public class Combo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 一个 Combo 的唯一标识，必须是 string 类型，必须唯一
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
     * 指定该 Combo 的类型，可以是内置 Combo 的类型名，也可以是自定义 Combo 的类型名。默认是 "circle"
     */
    @TableField("type")
    private String type;

    /**
     * 该 Combo 的父 Combo 的 ID
     */
    @TableField("parentId")
    private String parentId;

    /**
     * Combo 的最小尺寸（非固定尺寸），默认 "circle" 类型 Combo 的 size 为 20，"rect" 类型的为 "[20, 5]"
     */
    @TableField("size")
    private String size;

    /**
     * 固定该 Combo 的尺寸，不指定时 Combo 大小由内部元素的分布和大小来决定。若指定了 fixSize 而没有指定 fixCollapseSize，则即使该 Combo 在收起状态下仍然保持 fixSize 指定的尺寸
     */
    @TableField("fixSize")
    private String fixSize;

    /**
     * 固定该 Combo 收起时的尺寸，不指定时，若未指定 fixSize 则由 size 决定收起时的尺寸，否则统一为 fixSize 尺寸
     */
    @TableField("fixCollapseSize")
    private String fixCollapseSize;

    /**
     * 该 Combo 内边距，默认 "circle" 类型 Combo 的 padding 为 "[25, 25, 25, 25]"，"rect" 类型的为 "[25, 20, 15, 20]"
     */
    @TableField("padding")
    private String padding;

    /**
     * 该 Combo 的样式配置项
     */
    @TableField("style")
    private String style;

    /**
     * 该 Combo 的文本标签
     */
    @TableField("label")
    private String label;

    /**
     * 该 Combo 的文本标签样式配置项
     */
    @TableField("labelCfg")
    private String labelCfg;

    @TableField("children")
    private String children;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFixSize() {
        return fixSize;
    }

    public void setFixSize(String fixSize) {
        this.fixSize = fixSize;
    }

    public String getFixCollapseSize() {
        return fixCollapseSize;
    }

    public void setFixCollapseSize(String fixCollapseSize) {
        this.fixCollapseSize = fixCollapseSize;
    }

    public String getPadding() {
        return padding;
    }

    public void setPadding(String padding) {
        this.padding = padding;
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

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }
}
