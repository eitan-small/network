package com.example.network.service;

import com.example.network.dto.NodeDTO;
import com.example.network.entity.Node;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author eitan
 * @since 2023-08-04
 */
public interface NodeService extends IService<Node> {

    List<NodeDTO> getNodeDtoList();
}
