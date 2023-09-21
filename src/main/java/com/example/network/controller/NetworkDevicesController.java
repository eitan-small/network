package com.example.network.controller;

import com.example.network.dto.ApiResponse;
import com.example.network.entity.NetworkDevices;
import com.example.network.service.NetworkDevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("deleteCombo")
    public ApiResponse deleteCombo(@RequestParam String combo) {
        networkDevicesService.deleteCombo(combo);
        return ApiResponse.success();
    }

    @GetMapping("addCombo")
    public ApiResponse addCombo(@RequestParam String combo) {
        networkDevicesService.addCombo(combo);
        return ApiResponse.success();
    }

    @GetMapping("getAddDevices")
    public ApiResponse getAddDevices(@RequestParam String combo, @RequestParam String type) {
        List<NetworkDevices> list = networkDevicesService.getAddDevices(combo, type);
        return ApiResponse.success(list);
    }

    @PostMapping("addComboDevices")
    public ApiResponse addComboDevices(@RequestBody Map<String, Object> map) {
        networkDevicesService.addComboDevices(map);
        return ApiResponse.success();
    }

    @GetMapping("deleteDeviceCombo")
    public ApiResponse deleteDeviceCombo(@RequestParam String deviceName) {
        networkDevicesService.deleteDeviceCombo(deviceName);
        return ApiResponse.success();
    }

    @PostMapping("getDeviceTypes")
    public ApiResponse getDeviceTypes() {
        List<Map<String, Object>> data = networkDevicesService.getDeviceTypes();
        return ApiResponse.success(data);
    }

    @GetMapping("deleteDeviceType")
    public ApiResponse deleteDeviceType(@RequestParam String deviceName) {
        networkDevicesService.deleteDeviceType(deviceName);
        return ApiResponse.success();
    }

}
