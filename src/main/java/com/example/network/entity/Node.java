package com.example.network.entity;

import lombok.Data;

@Data
public class Node {
    private String id;

    /**
     * 设备序列号，唯一标识设备的字符串
     */
    private String serialNumber;

    /**
     * 设备名称，简短地描述设备
     */
    private String deviceName;

    /**
     * 设备类型，表示设备的分类，比如路由器、交换机、防火墙等
     */
    private String deviceType;

    /**
     * 设备层级，表示设备所属的核心层、接入层、汇聚层、出口区或其他分类
     */
    private String deviceLayer;
}
