package com.example.network.controller;

import com.example.network.dto.ApiResponse;
import com.example.network.entity.DictionaryTable;
import com.example.network.service.DictionaryTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author eitan
 * @since 2023-08-26
 */
@RestController
@RequestMapping("/network/dictionary")
public class DictionaryTableController {
    @Autowired
    private DictionaryTableService dictionaryTableService;

    @GetMapping("/getByType")
    public ApiResponse getDictionaryByType(@RequestParam String type) {
        List<DictionaryTable> dictionaryList = dictionaryTableService.getDictionaryByType(type);
        return ApiResponse.success(dictionaryList);
    }
}
