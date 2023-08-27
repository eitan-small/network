package com.example.network.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.network.entity.DictionaryTable;
import com.example.network.mapper.DictionaryTableMapper;
import com.example.network.service.DictionaryTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author eitan
 * @since 2023-08-26
 */
@Service
public class DictionaryTableServiceImpl extends ServiceImpl<DictionaryTableMapper, DictionaryTable> implements DictionaryTableService {

    @Override
    public List<DictionaryTable> getDictionaryByType(String type) {
        LambdaQueryWrapper<DictionaryTable> queryWrapper = new QueryWrapper<DictionaryTable>().lambda();
        queryWrapper.eq(DictionaryTable::getType, type);
        return list(queryWrapper);
    }
}
