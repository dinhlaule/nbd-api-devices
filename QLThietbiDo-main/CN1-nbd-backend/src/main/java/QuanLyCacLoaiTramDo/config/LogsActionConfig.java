package QuanLyCacLoaiTramDo.config;

import QuanLyCacLoaiTramDo.entity.LogsValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogsActionConfig {
    @Bean
    public LogsValidator logsValidator() {
        return new LogsValidator();
    }
}
