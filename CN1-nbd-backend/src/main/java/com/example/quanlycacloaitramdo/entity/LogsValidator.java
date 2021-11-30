package com.example.quanlycacloaitramdo.entity;

import org.thymeleaf.util.StringUtils;

import java.util.Optional;

public class LogsValidator {
    public boolean isValid(LogsAction logsAction) {
        return Optional.ofNullable(logsAction)
                .filter(t -> !StringUtils.isEmpty(t.getMenu_NAME()))
                .filter(t -> !StringUtils.isEmpty(t.getAction()))
                .filter(t -> !StringUtils.isEmpty(t.getUser_ACT()))
                .filter(t -> !StringUtils.isEmpty(t.getDate_ACT()))
                .filter(t -> !StringUtils.isEmpty(t.getTable_NAME()))
                .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
    }
}
