package com.example.putera_demo.common.model;

import lombok.Data;

import java.util.List;

@Data
public class Pagination<T> {
    private Integer first;
    private Integer prev;
    private Integer next;
    private Integer last;
    private Integer page;
    private Integer items;
    private List<T> data;

}
