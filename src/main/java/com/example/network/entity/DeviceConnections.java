package com.example.network.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * <p>
 * 设备连接信息表
 * </p>
 *
 * @author eitan
 * @since 2023-08-04
 */
@Data
@TableName("device_connections")
public class DeviceConnections implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 连接ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 源设备ID
     */
    @TableField("source_device_id")
    private Integer sourceDeviceId;

    /**
     * 目标设备ID
     */
    @TableField("destination_device_id")
    private Integer destinationDeviceId;

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

    /**
     * 链路类型，表示其是万兆光纤链路、千兆光纤链路、千兆铜缆链路
     */
    @TableField("link_type")
    private String linkType;

    /**
     * 源设备接口名
     */
    @TableField("source_interface_name")
    private String sourceInterfaceName;

    /**
     * 目标设备接口名
     */
    @TableField("destination_interface_name")
    private String destinationInterfaceName;
}
