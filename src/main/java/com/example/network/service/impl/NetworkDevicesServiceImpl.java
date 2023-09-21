package com.example.network.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.network.entity.DictionaryTable;
import com.example.network.entity.NetworkDevices;
import com.example.network.mapper.NetworkDevicesMapper;
import com.example.network.service.DictionaryTableService;
import com.example.network.service.NetworkDevicesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
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
    @Transactional
    public void deleteCombo(String combo) {
        LambdaQueryWrapper<DictionaryTable> queryWrapper = new QueryWrapper<DictionaryTable>().lambda();
        queryWrapper.eq(DictionaryTable::getType, "combo").eq(DictionaryTable::getValue, combo);
        dictionaryTableService.remove(queryWrapper);

        LambdaUpdateWrapper<NetworkDevices> updateWrapper = new UpdateWrapper<NetworkDevices>().lambda();
        updateWrapper.eq(NetworkDevices::getComboId, combo);
        updateWrapper.set(NetworkDevices::getComboId, null);
        update(updateWrapper);
    }

    @Override
    @Transactional
    public void addCombo(String combo) {
        LambdaQueryWrapper<DictionaryTable> queryWrapper = new QueryWrapper<DictionaryTable>().lambda();
        queryWrapper.eq(DictionaryTable::getValue, combo).last("LIMIT 1");
        DictionaryTable dictionaryTable = dictionaryTableService.getOne(queryWrapper);
        if (!Objects.isNull(dictionaryTable)) {
            throw new RuntimeException("分区" + dictionaryTable.getValue() + "已存在");
        }
        dictionaryTable = new DictionaryTable();
        dictionaryTable.setType("combo");
        dictionaryTable.setLabel(combo);
        dictionaryTable.setValue(dictionaryTable.getLabel());
        dictionaryTableService.saveOrUpdate(dictionaryTable);
    }

    @Override
    public List<Map<String, Object>> getCombos() {
        List<Map<String, Object>> list = new ArrayList<>();
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

    @Override
    public List<NetworkDevices> getAddDevices(String combo, String type) {
        LambdaQueryWrapper<NetworkDevices> wrapper = new QueryWrapper<NetworkDevices>().lambda();
        if ("1".equals(type)) {
            wrapper.ne(NetworkDevices::getComboId, combo).or().isNull(NetworkDevices::getComboId);
        } else if ("2".equals(type)) {
            wrapper.ne(NetworkDevices::getDeviceType, combo).or().isNull(NetworkDevices::getDeviceType);
        }

        List<NetworkDevices> list = list(wrapper);
        return list;
    }

    @Override
    public void addComboDevices(Map<String, Object> map) {

        List<Map<String, Object>> devices = (List<Map<String, Object>>) map.get("devices");
        List<Integer> ids = devices.stream().map(i -> (Integer) i.get("id")).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        LambdaUpdateWrapper<NetworkDevices> updateWrapper = new UpdateWrapper<NetworkDevices>().lambda();

        String comboId = (String) map.get("comboId");
        String deviceType = (String) map.get("deviceType");
        if (StringUtils.isNotEmpty(comboId)) {
            updateWrapper.set(NetworkDevices::getComboId, comboId).in(NetworkDevices::getId, ids);
        } else if (StringUtils.isNotEmpty(deviceType)) {
            updateWrapper.set(NetworkDevices::getDeviceType, deviceType).in(NetworkDevices::getId, ids);
        }

        update(updateWrapper);
    }

    @Override
    public void deleteDeviceCombo(String deviceName) {
        LambdaUpdateWrapper<NetworkDevices> updateWrapper = new UpdateWrapper<NetworkDevices>().lambda();
        updateWrapper.set(NetworkDevices::getComboId, null).in(NetworkDevices::getDeviceName, deviceName);
        update(updateWrapper);
    }

    @Override
    public List<Map<String, Object>> getDeviceTypes() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, List<NetworkDevices>> listMap = list().stream().filter(i -> !StringUtils.isEmpty(i.getDeviceType())).collect(Collectors.groupingBy(NetworkDevices::getDeviceType));
        List<DictionaryTable> combos = dictionaryTableService.getDictionaryByType("device_type");
        for (DictionaryTable combo : combos) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", combo.getId());
            map.put("value", combo.getValue());
            map.put("devices", listMap.get(combo.getValue()));
            list.add(map);
        }
        return list;
    }

    @Override
    public void deleteDeviceType(String deviceName) {
        LambdaUpdateWrapper<NetworkDevices> updateWrapper = new UpdateWrapper<NetworkDevices>().lambda();
        updateWrapper.set(NetworkDevices::getDeviceType, null).in(NetworkDevices::getDeviceName, deviceName);
        update(updateWrapper);
    }
}
