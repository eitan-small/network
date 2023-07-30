package com.example.network.entity;

import lombok.Data;

import java.util.List;

@Data
public class NetworkInfo {
    private List<Node> nodes;

    private List<Edge> edges;
}
