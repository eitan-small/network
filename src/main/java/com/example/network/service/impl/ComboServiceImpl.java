package com.example.network.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.network.dto.ComboDTO;
import com.example.network.entity.Combo;
import com.example.network.mapper.ComboMapper;
import com.example.network.service.ComboService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

    private List<ComboDTO> convertToDTO(List<Combo> comboList) {
        return comboList.stream().map(i -> {
            ComboDTO comboDTO = new ComboDTO();
            BeanUtils.copyProperties(i, comboDTO);
            Map<String, Object> style = JSON.parseObject(i.getStyle());
            Map<String, Object> lableCfg = JSON.parseObject(i.getLabelCfg());
            comboDTO.setStyle(style);
            comboDTO.setLabelCfg(lableCfg);
            return comboDTO;
        }).collect(Collectors.toList());
    }
}
