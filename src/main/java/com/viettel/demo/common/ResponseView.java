package com.viettel.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResponseView {
    private boolean isSuccess;
    // The message is displayed to the end user
    private String message;
    private DataTable data;
}
