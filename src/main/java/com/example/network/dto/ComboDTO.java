package com.example.network.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ComboDTO {
    private String id;

    /**
     * x坐标
     */
    private Object x;

    /**
     * y坐标
     */
    private Object y;
}
