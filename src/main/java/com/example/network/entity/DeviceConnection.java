package com.example.network.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author eitan
 * @since 2023-07-22
 */
@Getter
@Setter
@TableName("device_connections")
public class DeviceConnection implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("source_device_id")
    private Integer sourceDeviceId;

    @TableField("destination_device_id")
    private Integer destinationDeviceId;

    /**
     * 连接类型，描述连接的性质，例如"物理连接"、"逻辑连接"等
     */
    @TableField("connection_type")
    private String connectionType;

    /**
     * 记录创建时间，在插入新连接记录时自动设置为当前时间
     */
    @TableField("created_at")
    private LocalDateTime createdAt;

    /**
     * 记录更新时间，在更新连接记录时自动更新为当前时间
     */
    @TableField("updated_at")
    private LocalDateTime updatedAt;
}
