package com.example.network.service.impl;

import com.example.network.dto.ComboDTO;
import com.example.network.dto.EdgeDTO;
import com.example.network.dto.NetworkData;
import com.example.network.dto.NodeDTO;
import com.example.network.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NetworkDataServiceImpl implements NetworkDataService {

    private NodeService nodeService;

    private EdgeService edgeService;

    private ComboService comboService;

    @Autowired
    public NetworkDataServiceImpl(NodeService nodeService, EdgeService edgeService, ComboService comboService) {
        this.nodeService = nodeService;
        this.edgeService = edgeService;
        this.comboService = comboService;
    }

    @Override
    public NetworkData getData() {
        NetworkData networkData = new NetworkData();

        List<NodeDTO> nodeDTOList = nodeService.getNodeDtoList();
        List<EdgeDTO> edgeDtoList = edgeService.getEdgeDtoList();
        List<ComboDTO> comboDtoList = comboService.getComboDtoList();

        networkData.setNodes(nodeDTOList);
        networkData.setEdges(edgeDtoList);
        networkData.setCombos(comboDtoList);
        return networkData;
    }

    @Override
    @Transactional
    public void saveData(NetworkData networkData) {
        nodeService.saveNodeDtoList(networkData.getNodes());
        edgeService.saveEdgeDtoList(networkData.getEdges());
        comboService.saveComboDtoList(networkData.getCombos());
    }
}
