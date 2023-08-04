package com.example.network.service;

import com.example.network.dto.EdgeDTO;
import com.example.network.entity.Edge;
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
public interface EdgeService extends IService<Edge> {

    List<EdgeDTO> getEdgeDtoList();
}
