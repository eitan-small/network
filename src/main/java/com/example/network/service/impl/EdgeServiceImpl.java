package com.example.network.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.network.dto.EdgeDTO;
import com.example.network.dto.NodeDTO;
import com.example.network.entity.DeviceConnections;
import com.example.network.entity.Edge;
import com.example.network.entity.NetworkDevices;
import com.example.network.entity.Node;
import com.example.network.mapper.EdgeMapper;
import com.example.network.service.DeviceConnectionsService;
import com.example.network.service.EdgeService;
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
public class EdgeServiceImpl extends ServiceImpl<EdgeMapper, Edge> implements EdgeService {

    private DeviceConnectionsService deviceConnectionsService;

    @Autowired
    public EdgeServiceImpl(DeviceConnectionsService deviceConnectionsService) {
        this.deviceConnectionsService = deviceConnectionsService;
    }

    @Override
    public List<EdgeDTO> getEdgeDtoList() {
        Map<String, Edge> edgeMap = list().stream().collect(Collectors.toMap(Edge::getId, i -> i));

        List<DeviceConnections> deviceConnectionsList = deviceConnectionsService.list();

        return convertToDTO(edgeMap, deviceConnectionsList);
    }

    private List<EdgeDTO> convertToDTO(Map<String, Edge> edgeMap, List<DeviceConnections> deviceConnectionsList) {
        return deviceConnectionsList.stream().map(i -> {
            EdgeDTO edgeDTO = new EdgeDTO();
            Edge edge = edgeMap.get(i.getId());
            if (Objects.isNull(edge)) {
                edgeDTO.setId(i.getId().toString());
            } else {
                BeanUtils.copyProperties(edge, edgeDTO);
                Map<String, Object> style = JSON.parseObject(edge.getStyle());
                Map<String, Object> lableCfg = JSON.parseObject(edge.getLabelCfg());
                edgeDTO.setStyle(style);
                edgeDTO.setLabelCfg(lableCfg);
            }
            return edgeDTO;
        }).collect(Collectors.toList());
    }
}
