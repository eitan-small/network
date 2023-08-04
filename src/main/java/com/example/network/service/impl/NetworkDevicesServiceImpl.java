package com.example.network.service.impl;

import com.example.network.entity.NetworkDevices;
import com.example.network.mapper.NetworkDevicesMapper;
import com.example.network.service.NetworkDevicesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 网络设备信息表 服务实现类
 * </p>
 *
 * @author eitan
 * @since 2023-08-04
 */
@Service
public class NetworkDevicesServiceImpl extends ServiceImpl<NetworkDevicesMapper, NetworkDevices> implements NetworkDevicesService {

}
