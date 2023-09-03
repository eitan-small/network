package com.example.network.service.impl;

import com.example.network.entity.DictionaryTable;
import com.example.network.entity.NetworkDevices;
import com.example.network.mapper.NetworkDevicesMapper;
import com.example.network.service.DictionaryTableService;
import com.example.network.service.NetworkDevicesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    private DictionaryTableService dictionaryTableService;

    @Autowired
    public NetworkDevicesServiceImpl(DictionaryTableService dictionaryTableService) {
        this.dictionaryTableService = dictionaryTableService;
    }

    @Override
    public List<NetworkDevices> networkDevices() {
        return list();
    }

    @Override
    public List<Map<String, Object>> getCombos() {
        List<Map<String, Object>>list = new ArrayList<>();
        Map<String, List<NetworkDevices>> listMap = list().stream().filter(i -> !StringUtils.isEmpty(i.getComboId())).collect(Collectors.groupingBy(NetworkDevices::getComboId));
        List<DictionaryTable> combos = dictionaryTableService.getDictionaryByType("combo");
        for (DictionaryTable combo : combos) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", combo.getId());
            map.put("value", combo.getValue());
            map.put("devices", listMap.get(combo.getValue()));
            list.add(map);
        }
        return list;
    }
}
