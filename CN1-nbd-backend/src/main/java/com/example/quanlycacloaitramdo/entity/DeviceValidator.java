package com.example.quanlycacloaitramdo.entity;

import org.thymeleaf.util.StringUtils;

import java.util.Optional;

public class DeviceValidator {
    public boolean isValid(Device device) {
        return Optional.ofNullable(device)
                .filter(t -> !StringUtils.isEmpty(t.getObject_TYPE())) // Kiểm tra code khác rỗng
                .filter(t -> !StringUtils.isEmpty(t.getObject_TYPE_SHORTNAME())) // Kiểm tra name khác rỗng
                .filter(t -> (StringUtils.equals(t.getIs_AUTO(), "Tự động đo")) || (StringUtils.equals(t.getIs_AUTO(), "Thủ công"))) // Kiểm tra type
                .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
    }
}
