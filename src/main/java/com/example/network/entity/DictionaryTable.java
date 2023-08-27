package com.example.network.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author eitan
 * @since 2023-08-26
 */
@Getter
@Setter
@TableName("dictionary_table")
public class DictionaryTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识符
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型，用于区分不同的选择器
     */
    @TableField("type")
    private String type;

    /**
     * 标签，用于在 Select 中显示
     */
    @TableField("label")
    private String label;

    /**
     * 文本，用于在 Select 中作为选项的文本
     */
    @TableField("value")
    private String value;
}
