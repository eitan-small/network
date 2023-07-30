package com.example.network.controller;

import com.example.network.entity.NetworkInfo;
import com.example.network.service.NetworkDevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author eitan
 * @since 2023-07-22
 */
@RestController
@RequestMapping("/network")
public class NetworkController {
    private NetworkDevicesService networkDevicesService;

    @Autowired
    public NetworkController(NetworkDevicesService networkDevicesService) {
        this.networkDevicesService = networkDevicesService;
    }

    @PostMapping("info")
    public NetworkInfo getInfo() {
        return networkDevicesService.getInfo();
    }
}
