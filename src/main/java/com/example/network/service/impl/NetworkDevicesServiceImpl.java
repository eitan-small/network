package com.example.network.service.impl;

import com.example.network.entity.*;
import com.example.network.mapper.NetworkDevicesMapper;
import com.example.network.service.DeviceConnectionsService;
import com.example.network.service.NetworkDevicesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author eitan
 * @since 2023-07-22
 */
@Service
public class NetworkDevicesServiceImpl extends ServiceImpl<NetworkDevicesMapper, NetworkDevice> implements NetworkDevicesService {

    private DeviceConnectionsService deviceConnectionsService;

    @Autowired
    public NetworkDevicesServiceImpl(DeviceConnectionsService deviceConnectionsService) {
        this.deviceConnectionsService = deviceConnectionsService;
    }

    @Override
    public NetworkInfo getInfo() {
        NetworkInfo networkInfo = new NetworkInfo();

        List<NetworkDevice> networkDevices = list();
        List<Node> nodeList = networkDevices.stream().map(i -> {
            Node node = new Node();
            node.setId(i.getId().toString());
            BeanUtils.copyProperties(i, node);
            return node;
        }).collect(Collectors.toList());

        List<DeviceConnection> deviceConnections = deviceConnectionsService.list();
        List<Edge> edgeList = deviceConnections.stream().map(i -> {
            Edge edge = new Edge();
            edge.setId("e" + i.getId());
            edge.setSource(i.getSourceDeviceId().toString());
            edge.setTarget(i.getDestinationDeviceId().toString());
            return edge;
        }).collect(Collectors.toList());

        networkInfo.setNodes(nodeList);
        networkInfo.setEdges(edgeList);
        return networkInfo;
    }
}
