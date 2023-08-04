package com.example.network.mapper;

import com.example.network.entity.NetworkDevices;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 网络设备信息表 Mapper 接口
 * </p>
 *
 * @author eitan
 * @since 2023-08-04
 */
@Mapper
public interface NetworkDevicesMapper extends BaseMapper<NetworkDevices> {

}
