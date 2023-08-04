package com.example.network.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.network.dto.NodeDTO;
import com.example.network.entity.NetworkDevices;
import com.example.network.entity.Node;
import com.example.network.mapper.NodeMapper;
import com.example.network.service.NetworkDevicesService;
import com.example.network.service.NodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author eitan
 * @since 2023-08-04
 */
@Service
public class NodeServiceImpl extends ServiceImpl<NodeMapper, Node> implements NodeService {

    private NetworkDevicesService networkDevicesService;

    @Autowired
    public NodeServiceImpl(NetworkDevicesService networkDevicesService) {
        this.networkDevicesService = networkDevicesService;
    }

    @Override
    public List<NodeDTO> getNodeDtoList() {
        Map<String, Node> nodeMap = list().stream().collect(Collectors.toMap(Node::getId, i -> i));

        List<NetworkDevices> networkDevicesList = networkDevicesService.list();

        return convertToDTO(nodeMap, networkDevicesList);
    }

    private List<NodeDTO> convertToDTO(Map<String, Node> nodeMap, List<NetworkDevices> networkDevicesList) {

        return networkDevicesList.stream().map(i -> {
            NodeDTO nodeDTO = new NodeDTO();
            Node node = nodeMap.get(i.getId());
            if (Objects.isNull(node)) {
                nodeDTO.setId(i.getId().toString());
                nodeDTO.setLabel(i.getDeviceName());
            } else {
                BeanUtils.copyProperties(node, nodeDTO);
                Map<String, Object> style = JSON.parseObject(node.getStyle());
                Map<String, Object> lableCfg = JSON.parseObject(node.getLabelCfg());
                nodeDTO.setStyle(style);
                nodeDTO.setLabelCfg(lableCfg);
            }
            return nodeDTO;
        }).collect(Collectors.toList());
    }
}
