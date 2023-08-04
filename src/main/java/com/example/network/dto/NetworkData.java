package com.example.network.dto;

import lombok.Data;

import java.util.List;

@Data
public class NetworkData {
    private List<NodeDTO> nodes;

    private List<EdgeDTO> edges;

    private List<ComboDTO> combos;
}
