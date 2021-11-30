package com.example.quanlycacloaitramdo.config;

import com.example.quanlycacloaitramdo.entity.LogsValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogsActionConfig {
    @Bean
    public LogsValidator logsValidator() {
        return new LogsValidator();
    }
}
