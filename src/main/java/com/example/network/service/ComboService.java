package com.example.network.service;

import com.example.network.dto.ComboDTO;
import com.example.network.entity.Combo;
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
public interface ComboService extends IService<Combo> {

    List<ComboDTO> getComboDtoList();
}
