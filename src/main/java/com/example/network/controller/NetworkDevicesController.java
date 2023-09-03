package com.example.network.controller;

import com.example.network.dto.ApiResponse;
import com.example.network.entity.NetworkDevices;
import com.example.network.service.NetworkDevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 网络设备信息表 前端控制器
 * </p>
 *
 * @author eitan
 * @since 2023-08-04
 */
@RestController
@RequestMapping("/network/networkDevices")
public class NetworkDevicesController {
    private NetworkDevicesService networkDevicesService;

    @Autowired
    public NetworkDevicesController(NetworkDevicesService networkDevicesService) {
        this.networkDevicesService = networkDevicesService;
    }

    @PostMapping("list")
    public ApiResponse list() {
        List<NetworkDevices> data = networkDevicesService.networkDevices();
        return ApiResponse.success(data);
    }

    @PostMapping("getCombos")
    public ApiResponse getCombos() {
        List<Map<String, Object>> data = networkDevicesService.getCombos();
        return ApiResponse.success(data);
    }
}
