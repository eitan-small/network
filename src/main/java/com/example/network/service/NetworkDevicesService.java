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

    void deleteCombo(String combo);

    void addCombo(String combo);

    List<Map<String, Object>> getCombos();

    List<NetworkDevices> getAddDevices(String combo, String type);

    void addComboDevices(Map<String, Object> map);

    void deleteDeviceCombo(String deviceName);

    List<Map<String, Object>> getDeviceTypes();

    void deleteDeviceType(String deviceName);
}
