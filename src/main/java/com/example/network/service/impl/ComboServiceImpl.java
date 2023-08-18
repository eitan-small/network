package com.example.network.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.network.dto.ComboDTO;
import com.example.network.entity.Combo;
import com.example.network.entity.Edge;
import com.example.network.mapper.ComboMapper;
import com.example.network.service.ComboService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.network.utils.CommonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author eitan
 * @since 2023-08-04
 */
@Service
public class ComboServiceImpl extends ServiceImpl<ComboMapper, Combo> implements ComboService {

    @Override
    public List<ComboDTO> getComboDtoList() {
        List<Combo> comboList = list();
        return convertToDTO(comboList);
    }

    @Override
    public void saveComboDtoList(List<ComboDTO> combos) {
        List<Combo> comboList = combos.stream().map(i -> {
            Combo combo = new Combo();
            BeanUtils.copyProperties(i, combo);
            combo.setStyle(CommonUtil.objectToStr(i.getStyle()));
            combo.setLabelCfg(CommonUtil.objectToStr(i.getLabelCfg()));
            combo.setChildren(CommonUtil.objectToStr(i.getChildren()));
            return combo;
        }).collect(Collectors.toList());
        saveOrUpdateBatch(comboList);
    }

    private List<ComboDTO> convertToDTO(List<Combo> comboList) {
        return comboList.stream().map(i -> {
            ComboDTO comboDTO = new ComboDTO();
            BeanUtils.copyProperties(i, comboDTO);
            comboDTO.setStyle(CommonUtil.strToMap(i.getStyle()));
            comboDTO.setLabelCfg(CommonUtil.strToMap(i.getLabelCfg()));
            comboDTO.setChildren(CommonUtil.strToObject(i.getChildren()));
            return comboDTO;
        }).collect(Collectors.toList());
    }
}
