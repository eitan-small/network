package com.example.network.controller;

import com.example.network.dto.ApiResponse;
import com.example.network.dto.NetworkData;
import com.example.network.service.NetworkDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/network")
public class NetworkDataController {
    private NetworkDataService networkDataService;

    @Autowired
    public NetworkDataController(NetworkDataService networkDataService) {
        this.networkDataService = networkDataService;
    }

    @PostMapping("data")
    public ApiResponse getData() {
        NetworkData data = networkDataService.getData();
        return ApiResponse.success(data);
    }

    @PostMapping("saveData")
    public ApiResponse saveData(@RequestBody NetworkData networkData) {
        networkDataService.saveData(networkData);
        return ApiResponse.success(null);
    }
}
