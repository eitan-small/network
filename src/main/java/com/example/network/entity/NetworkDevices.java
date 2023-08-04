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
 * 网络设备信息表
 * </p>
 *
 * @author eitan
 * @since 2023-08-04
 */
@Data
@TableName("network_devices")
public class NetworkDevices implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备ID，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 设备序列号，唯一标识设备的字符串
     */
    @TableField("serial_number")
    private String serialNumber;

    /**
     * 设备名称，简短地描述设备
     */
    @TableField("device_name")
    private String deviceName;

    /**
     * 设备类型，表示设备的分类，比如路由器、交换机、防火墙等
     */
    @TableField("device_type")
    private String deviceType;

    /**
     * 记录创建时间，在插入新设备记录时自动设置为当前时间
     */
    @TableField("created_at")
    private LocalDateTime createdAt;

    /**
     * 记录更新时间，在更新设备记录时自动更新为当前时间
     */
    @TableField("updated_at")
    private LocalDateTime updatedAt;
}
