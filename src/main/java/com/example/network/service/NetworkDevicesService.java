package com.example.network.service;

import com.example.network.entity.NetworkDevices;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 网络设备信息表 服务类
 * </p>
 *
 * @author eitan
 * @since 2023-08-04
 */
public interface NetworkDevicesService extends IService<NetworkDevices> {

    List<NetworkDevices> networkDevices();

    List<Map<String, Object>> getCombos();
}
