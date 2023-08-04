package com.example.network.service.impl;

import com.example.network.entity.DeviceConnections;
import com.example.network.mapper.DeviceConnectionsMapper;
import com.example.network.service.DeviceConnectionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 设备连接信息表 服务实现类
 * </p>
 *
 * @author eitan
 * @since 2023-08-04
 */
@Service
public class DeviceConnectionsServiceImpl extends ServiceImpl<DeviceConnectionsMapper, DeviceConnections> implements DeviceConnectionsService {

}
