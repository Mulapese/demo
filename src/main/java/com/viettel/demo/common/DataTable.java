package com.viettel.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class DataTable {
    private long totalElements;
    private int totalPages;
    private List<?> content;
}
