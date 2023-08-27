package com.example.network.service;

import com.example.network.entity.DictionaryTable;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author eitan
 * @since 2023-08-26
 */
public interface DictionaryTableService extends IService<DictionaryTable> {

    List<DictionaryTable> getDictionaryByType(String type);
}
